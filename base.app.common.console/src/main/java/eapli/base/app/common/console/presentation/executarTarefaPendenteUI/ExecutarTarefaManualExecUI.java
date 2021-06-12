package eapli.base.app.common.console.presentation.executarTarefaPendenteUI;

import eapli.base.Utils.HelpMethods;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.tarefaManualExecucao.application.ExecutarTarefaExecucaoController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExecutarTarefaManualExecUI extends AbstractUI {
    private final ExecutarTarefaExecucaoController controller = new ExecutarTarefaExecucaoController();
    List<TarefaManualExecucao> listaTarefasManualExecucao;

    @Override
    protected boolean doShow() {
        TarefaManualExecucao tarefaManualExecucao = null;
        listaTarefasManualExecucao = controller.tarefasManualExecucaoPendente();
        int index = 1;
        for (TarefaManualExecucao t : listaTarefasManualExecucao) {
            System.out.println(index + " " + t.toString());
            index++;
        }

        boolean escolherTarefa = false;

        while (!escolherTarefa) {
            int opcao = Console.readInteger("Escolha a tarefa que pretende realizar : (prima 0 para sair)");

            if (opcao == 0) {
                return false;
            } else if (opcao <= listaTarefasManualExecucao.size() && opcao > 0) {
                escolherTarefa = true;
                tarefaManualExecucao = listaTarefasManualExecucao.get(opcao - 1);
            } else {
                System.out.println("Coloque um index válido");
            }
        }
        List<Formulario> forms = controller.obterAtividadeRealizacao(tarefaManualExecucao);
        Set<FormularioPreenchido> fps = new HashSet<>();

        if (!forms.isEmpty()) {// precisa de comentario
            for (Formulario f : forms) {
                System.out.println("\nFormulario " + f.name() + "\n");

                Set<Resposta> respostas = new HashSet<>();
                Set<Atributo> a = f.atributos();
                for (Atributo atributo : a) {
                    TipoDados td = atributo.tipoDados();
                    String ajudaResposta = atributo.tipoDadosStr(td);
                    String resposta = Console.readLine(atributo.nomeVar() + " " + "    Responda conforme -> " + ajudaResposta);
                    boolean flag = true;
                    do {
                        if (HelpMethods.validaResposta(resposta, atributo.obterExpRegular()))
                            flag = false;

                    } while (flag);
                    Resposta rAtr = new Resposta(resposta, atributo.nomeVar());
                    respostas.add(rAtr);
                }

                FormularioPreenchido fp = new FormularioPreenchido(f, respostas, tarefaManualExecucao.procurarTicket(), controller.colablogged());
                fps.add(fp);

                controller.saveFormPreenchido(fp);
                controller.saveTicket(tarefaManualExecucao.procurarTicket());
                controller.saveTarefaExecucao(tarefaManualExecucao);
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Tarefa a executar ";

    }
}

