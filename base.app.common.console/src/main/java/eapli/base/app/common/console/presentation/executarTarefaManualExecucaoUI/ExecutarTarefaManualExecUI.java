package eapli.base.app.common.console.presentation.executarTarefaManualExecucaoUI;

import eapli.base.Utils.HelpMethods;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.tarefaManualExecucao.application.ExecutarTarefaExecucaoController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.*;
import java.util.logging.Logger;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

public class ExecutarTarefaManualExecUI extends AbstractUI {
    private final ExecutarTarefaExecucaoController controller = new ExecutarTarefaExecucaoController();


    @Override
    protected boolean doShow() {
        List<TarefaManualExecucao> listaTarefasManualExecucao = controller.tarefasManualExecucaoPendente();

        if (listaTarefasManualExecucao.isEmpty()) {
            System.out.println("Ainda não existem tarefas de execução atribuidas a si.");
            return false;
        }

        final SelectWidget<TarefaManualExecucao> selector = new SelectWidget<>("Tarefas a Realizar:", listaTarefasManualExecucao,
                new TarefasExecucaoPrinter());
        selector.show();
        final TarefaManualExecucao tarefaManualExecucao = selector.selectedElement();
        if (tarefaManualExecucao == null)
            return true;

        AtividadeRealizacao ar = tarefaManualExecucao.atividadeRealizacaoDaTarefa();
        Formulario f = ar.formularioRealizacao();

        System.out.println("\nFormulario " + f.name() + "\n");

        Map<Resposta, Integer> respostas = new HashMap<>();
        Map<Atributo, Integer> a = f.atributos();
        for (Atributo atributo : a.keySet()) {
            TipoDados td = atributo.tipoDados();
            String ajudaResposta = atributo.tipoDadosStr(td);
            boolean flag = true;
            String resposta;
            do {
                resposta = Console.readLine(atributo.nomeVar() + " " + "    Responda conforme -> " + ajudaResposta);
                if (HelpMethods.validaResposta(resposta, atributo.obterExpRegular())) {
                    controller.conclusao(resposta, tarefaManualExecucao, atributo);
                    flag = false;
                }
                if (flag) {
                    System.out.println("Dado incorreto.");
                }
            } while (flag);

            respostas.put(controller.adicionaResposta(resposta, atributo.nomeVar()), respostas.size()+1);
        }

        try {
            controller.executaTarefa(f, respostas, tarefaManualExecucao);
            LOGGER.info(tarefaManualExecucao);
        } catch (Exception x) {
            System.out.println("Ocorreu um erro");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Tarefa a executar ";

    }
}

