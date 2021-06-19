package eapli.base.app.common.console.presentation.executarTarefaManualAprovacaoUI;

import eapli.base.Utils.HelpMethods;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.tarefaManualAprovacao.application.ExecutarTarefaAprovacaoController;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.*;

public class ExecutarTarefaManualAprovUI extends AbstractUI {
    private final ExecutarTarefaAprovacaoController controller = new ExecutarTarefaAprovacaoController();

    @Override
    protected boolean doShow() {

        List<TarefaManualAprovacao> listaTarefaAprov = controller.tarefasManualAprovacao();

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

        Formulario f = tarefaManualAprovacao.atividadeAprovacaoDaTarefa().formularioAprovacao();

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
                            if (atributo.tipoDados() == TipoDados.DECISAO) {
                              controller.decisao(resposta,tarefaManualAprovacao);
                            }
                            flag = false;
                        }
                        if(flag){
                            System.out.println("Dado incorreto.");
                        }
                    } while (flag);
                    respostas.put(controller.adicionarResposta(resposta,atributo.nomeVar()), respostas.size()+1);
                }

            try {
                TarefaManualAprovacao tarManAprov = controller.terminarAprovacao(f, respostas, tarefaManualAprovacao);
                System.out.println(tarManAprov.toString());
                System.out.println("Tarefa aprovada/rejeitada!");
            }catch (Exception x){
                System.out.println("Ocorreu algum erro ao terminar a execução");
            }


        return true;
    }

    @Override
    public String headline() {
        return "Tarefa a aprovar";
    }
}



