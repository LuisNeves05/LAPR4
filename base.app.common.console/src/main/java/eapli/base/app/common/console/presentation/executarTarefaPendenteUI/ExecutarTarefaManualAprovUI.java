package eapli.base.app.common.console.presentation.executarTarefaPendenteUI;

import eapli.base.Utils.HelpMethods;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.tarefaManualAprovacao.application.ExecutarTarefaAprovacaoController;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

                        if (HelpMethods.validaResposta(resposta,atributo.obterExpRegular())) {
                            if (atributo.tipoDados() == TipoDados.DECISAO) {
                                if (resposta.equalsIgnoreCase("deferido")) {
                                    tarefaManualAprovacao.procurarTicket().aprovarTicket();

                                } else {
                                    tarefaManualAprovacao.procurarTicket().rejeitarTicket();
                                }
                                flag = false;
                            }
                        }
                    } while (flag);
                    Resposta rAtr = new Resposta(resposta, atributo.nomeVar());
                    respostas.add(rAtr);
                }

                FormularioPreenchido fp = new FormularioPreenchido(f, respostas, tarefaManualAprovacao.procurarTicket(), controller.colabLogged());
                fps.add(fp);

                controller.saveFormPreenchido(fp);

                controller.saveTicket(tarefaManualAprovacao.procurarTicket());

                controller.saveTarefaAprovacao(tarefaManualAprovacao);
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Tarefa a aprovar ";

    }

}



