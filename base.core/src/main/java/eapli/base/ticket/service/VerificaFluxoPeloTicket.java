package eapli.base.ticket.service;

import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;

public class VerificaFluxoPeloTicket {
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();

    public boolean verificaFluxosPeloTicket(FluxoAtividade fluxoAtividade){
        //FIXME VERIFICAR SE O FLUXO TEM TICKETS POR CONCLUIR/INACABADO, E SE NÃO, DESATIVAR O FLUXO
        //return ticketRepositorio.ticketsPorConcluirDoFluxo(fluxoAtividade);
        return false;
    }
}
