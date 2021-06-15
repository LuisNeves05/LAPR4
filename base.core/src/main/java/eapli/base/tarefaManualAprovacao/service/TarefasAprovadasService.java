package eapli.base.tarefaManualAprovacao.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualAprovacao.domain.EstadoAprovacao;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.ticket.domain.Ticket;

import java.util.List;

public class TarefasAprovadasService {

    private final TarefaManualAprovacaoRepositorio tarManAprovRep = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();

    public boolean tarefasTotalmenteAprovadas(Ticket ticket) {

        List<TarefaManualAprovacao> tarsManDoTicket = tarManAprovRep.tarefasAprovacaoDoTicket(ticket);

        int nrAprovados = 0;
        for (TarefaManualAprovacao tma : tarsManDoTicket){
            if(tma.estadoAprov() == EstadoAprovacao.APROVADO){
                nrAprovados++;
            }
        }

        return nrAprovados == tarsManDoTicket.size() - 1;
    }
}
