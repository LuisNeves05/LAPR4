package eapli.base.app.common.console.presentation.executarTarefaManualExecucaoUI;

import eapli.base.Utils.HelpMethods;
import eapli.base.app.common.console.presentation.executarTarefaManualAprovacaoUI.TarefasAprovacaoPrinter;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.application.ExecutarTarefaExecucaoController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExecutarTarefaManualExecUI extends AbstractUI {
    private final ExecutarTarefaExecucaoController controller = new ExecutarTarefaExecucaoController();


    @Override
    protected boolean doShow() {
        List<TarefaManualExecucao> listaTarefasManualExecucao = controller.tarefasManualExecucaoPendente();

        if(listaTarefasManualExecucao.isEmpty()){
            System.out.println("Ainda não existem tarefas de execução atribuidas a si.");
            return false;
        }

        final SelectWidget<TarefaManualExecucao> selector = new SelectWidget<>("Tarefas a Realizar:", listaTarefasManualExecucao,
                new TarefasExecucaoPrinter());
        selector.show();
        final TarefaManualExecucao tarefaManualExecucao = selector.selectedElement();
        if(tarefaManualExecucao == null)
            return true;

        AtividadeRealizacao ar = tarefaManualExecucao.atividadeRealizacaoDaTarefa();
        Formulario f = ar.formularioRealizacao();

        System.out.println("\nFormulario " + f.name() + "\n");

        Set<Resposta> respostas = new HashSet<>();
        Map<Atributo, Integer> a = f.atributos();
        for (Atributo atributo : a.keySet()) {
            TipoDados td = atributo.tipoDados();
            String ajudaResposta = atributo.tipoDadosStr(td);
            boolean flag = true;
            String resposta;
            do {
                resposta = Console.readLine(atributo.nomeVar() + " " + "    Responda conforme -> " + ajudaResposta);
                if (HelpMethods.validaResposta(resposta, atributo.obterExpRegular())) {
                    if (atributo.tipoDados() == TipoDados.CONCLUSAO) {
                        if (resposta.equalsIgnoreCase("Concluido")) {
                            tarefaManualExecucao.ticketDaTarefa().completarTicket();
                        } else {
                            tarefaManualExecucao.ticketDaTarefa().inacabadoTicket();
                        }
                    }
                    flag = false;
                }
                if(flag){
                    System.out.println("Dado incorreto.");
                }
            } while (flag);

            respostas.add(controller.adicionaResposta(resposta, atributo.nomeVar()));
        }

        try {
            controller.terminaExecucao(f, respostas, tarefaManualExecucao);
        }catch (Exception x){
            System.out.println("Ocorreu um erro");
        }


        return true;
    }

    @Override
    public String headline() {
        return "Tarefa a executar ";

    }
}

