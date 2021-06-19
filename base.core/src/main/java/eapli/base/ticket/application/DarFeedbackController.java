package eapli.base.ticket.application;

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

import java.util.List;

public class DarFeedbackController {

    private Colaborador colabLogado;
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();

    public DarFeedbackController(){
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if(authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            SystemUser systemUser = userSession.authenticatedUser();
            this.colabLogado = colabPorUserName(systemUser.username());
        }
    }

    public List<Ticket> ticketsComFeedbackDoColab(){
        return ticketRepositorio.ticketsComFeedbackDoColab(colabLogado);
    }

    public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public void feedbackDoColaborador(String respostaFeedback, Ticket ticket) {
        ticket.feedbackDoColaborador(respostaFeedback);
        ticketRepositorio.save(ticket);
    }
}
