package eapli.base.ticket.service;

import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;

public class VerificaFluxoPeloTicket {
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();

    public boolean verificaFluxosPeloTicket(FluxoAtividade fluxoAtividade){
        //return ticketRepositorio.ticketsPorConcluirDoFluxo(fluxoAtividade);
        return false;
    }
}
