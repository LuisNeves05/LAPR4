package eapli.base.app.common.console.presentation.executarTarefaPendenteUI;

import eapli.base.Utils.HelpMethods;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.tarefaManualAprovacao.application.ExecutarTarefaAprovacaoController;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import eapli.framework.visitor.Visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExecutarTarefaManualAprovUI extends AbstractUI {
    private final ExecutarTarefaAprovacaoController controller = new ExecutarTarefaAprovacaoController();
    List<TarefaManualAprovacao> listaTarefaAprov;

    @Override
    protected boolean doShow() {


        listaTarefaAprov = controller.tarefasManualAprovacao();

        if(listaTarefaAprov.isEmpty()){
            System.out.println("Ainda não existem tarefas de aprovação atribuidas a si.");
            return false;
        }

        final SelectWidget<TarefaManualAprovacao> selector = new SelectWidget<>("Tarefas de Aprovação:", listaTarefaAprov,
                new TarefasAprovacaoPrinter());
        selector.show();
        final TarefaManualAprovacao tarefaManualAprovacao = selector.selectedElement();
        if(tarefaManualAprovacao == null)
            return true;

        AtividadeAprovacao ap = tarefaManualAprovacao.atividadeAprovacaoDaTarefa();
        Formulario f = ap.formularioAprovacao();

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
                            if (atributo.tipoDados() == TipoDados.DECISAO) {
                              controller.isDecisao(resposta,tarefaManualAprovacao);
                            }
                            flag = false;
                        }
                        if(flag){
                            System.out.println("Dado incorreto.");
                        }
                    } while (flag);
                    respostas.add(controller.adicionarResposta(resposta,atributo.nomeVar()));
                }

            controller.terminarExecucao(f,respostas,tarefaManualAprovacao);

        return true;
    }

    @Override
    public String headline() {
        return "Tarefa a aprovar";
    }
}



