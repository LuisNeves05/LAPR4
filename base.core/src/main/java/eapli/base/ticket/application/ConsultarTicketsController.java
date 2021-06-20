package eapli.base.ticket.application;

import com.google.common.collect.Lists;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConsultarTicketsController {

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabPedido = colabPorUserName(systemUser.username());


    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();


    public Colaborador colabPorUserName(Username username) {
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public List<Ticket> returnAllTicketsPorConcluir() {
        return Lists.newArrayList(ticketRepositorio.ticketPorColabEmExecucao(colabPedido));
    }


    public List<Ticket> returnAllTicketsConcluidos() {
        return Lists.newArrayList(ticketRepositorio.ticketPorColabConcluido(colabPedido));
    }


}
