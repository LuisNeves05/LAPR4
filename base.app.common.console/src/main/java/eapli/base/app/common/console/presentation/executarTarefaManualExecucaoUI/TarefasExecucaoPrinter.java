package eapli.base.app.common.console.presentation.executarTarefaManualExecucaoUI;

import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.visitor.Visitor;

public class TarefasExecucaoPrinter implements Visitor<TarefaManualExecucao> {

    @Override
    public void visit(final TarefaManualExecucao visitee) {
        System.out.printf("%-30s", visitee.ticketDaTarefa().toString());
    }
}
