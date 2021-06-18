package eapli.base.app.common.console.presentation.executarTarefaManualAprovacaoUI;

import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.visitor.Visitor;

public class TarefasAprovacaoPrinter implements Visitor<TarefaManualAprovacao> {

    @Override
    public void visit(final TarefaManualAprovacao visitee) {
        System.out.printf("%-30s", visitee.ticketDaTarefa().toString());
    }
}
