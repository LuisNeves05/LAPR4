package eapli.base.app.common.console.presentation.finalizarEspecificacaoServicoUI;

import eapli.base.servico.domain.Servico;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.visitor.Visitor;

public class ServicoIncompletosPrinter implements Visitor<Servico> {
    @Override
    public void visit(final Servico visitee) {
        System.out.printf("%-30s", visitee.toString());
    }
}
