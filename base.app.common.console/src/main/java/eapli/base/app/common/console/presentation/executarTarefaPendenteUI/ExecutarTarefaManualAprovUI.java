package eapli.base.app.common.console.presentation.executarTarefaPendenteUI;

import eapli.base.Utils.DecisaoEnum;
import eapli.base.formulario.domain.Formulario;
import eapli.base.tarefaManualAprovacao.application.ExecutarTarefaAprovacaoController;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ExecutarTarefaManualAprovUI extends AbstractUI {
    private final ExecutarTarefaAprovacaoController controller = new ExecutarTarefaAprovacaoController();
    List<TarefaManualAprovacao> listaTarefaAprov;

    @Override
    protected boolean doShow() {
        TarefaManualAprovacao tarefaManualAprovacao = null;
        listaTarefaAprov = controller.tarefasManualAprovacao();
        int index = 1;
        for (TarefaManualAprovacao t : listaTarefaAprov) {
            System.out.println(index + " " + t.toString());
            index++;
        }

        boolean escolherTarefa = false;

        while (!escolherTarefa) {
            int opcao = Console.readInteger("Escolha a tarefa que pretende analisar : (prima 0 para sair)");

            if (opcao == 0) {
                return false;
            } else if (opcao <= listaTarefaAprov.size() && opcao > 0) {
                escolherTarefa = true;
                tarefaManualAprovacao = listaTarefaAprov.get(opcao - 1);
            } else {
                System.out.println("Coloque um index válido");
            }
        }
        List<Formulario> forms = controller.obterAtividadeAprovacao(tarefaManualAprovacao);

        boolean aprovar = false;

        while (!(aprovar)) {
            String decisao = Console.readLine("Pretende aprovar esta tarefa?(S/N ou 0 para sair)? ");
            if (decisao.equalsIgnoreCase("0")) {
                return false;
            } else if (decisao.equalsIgnoreCase("S")) {
                tarefaManualAprovacao.decidirTarefa(DecisaoEnum.APROVADO);
                if (!forms.isEmpty()) {// precisa de comentario
                    String comentario = Console.readLine("Justifique a sua escolha :");
                    tarefaManualAprovacao.fazerComentario(comentario);
                }
                tarefaManualAprovacao.definirMomentoAprovacao();
                aprovar = true;
            }
            else if (decisao.equalsIgnoreCase("N")) {
                tarefaManualAprovacao.decidirTarefa(DecisaoEnum.REJEITADO);
                if (!forms.isEmpty()) {// precisa de comentario
                    String comentario = Console.readLine("Justifique a sua escolha :");
                    tarefaManualAprovacao.fazerComentario(comentario);
                }
                tarefaManualAprovacao.definirMomentoAprovacao();
                aprovar = true;}
            else {
                System.out.println("Insira uma resposta válida");

            }
        }

        // todo se tiver decisao e comment


        return true;
    }


    @Override
    public String headline() {
        return "Tarefa a aprovar ";
    }
}



