package eapli.base.tarefaManualAprovacao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualAprovacao.service.TarefaManualAprovacaoService;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.ArrayList;
import java.util.List;


public class ExecutarTarefaAprovacaoController {
    private SystemUser systemUser;
    private Colaborador colabPedido;
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();
    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TarefaManualAprovacaoService tarefaService = new TarefaManualAprovacaoService();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final TicketRepositorio ticketRepo = PersistenceContext.repositories().ticketRepositorio();
    private final UserSession userSession = authorizationService.session().get();


    public ExecutarTarefaAprovacaoController() {
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if (authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
            this.colabPedido = colabPorUserName(systemUser.username());
            List<Equipa> equipasColab = colabPedido.obterEquipasColaborador();
        }
    }

    public Colaborador colabPorUserName(Username username) {
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public List<TarefaManualAprovacao> tarefasManualAprovacao() {
        return tarefaManualAprovacaoRepositorio.tarefasManuaisAprovacaoNA(colabPedido);
    }

    public List<Formulario> obterAtividadeAprovacao(TarefaManualAprovacao tarefa) {
        return tarefaManualAprovacaoRepositorio.obterAtividadeRealizacao(tarefa);
    }

    public TarefaManualAprovacao executarTarefaAprPendente(TarefaManualAprovacao tarefa) {
        //    tarefa.defineColaboradorExecutante(colabPedido);

        try {
            //TODO GUARDAR TAREFA MANUAL APROVACAO
            return tarefaManualAprovacaoRepositorio.save(tarefa);
        } catch (IntegrityViolationException violation) {
            System.out.println("Erro na persistência da tarefa!");
        }
        return null;
    }



    public Colaborador colabLogged() {
        return this.colabPedido;
    }

    public void saveFormPreenchido(FormularioPreenchido fp) {
        fpr.save(fp);
    }

    public void saveTarefaAprovacao(TarefaManualAprovacao tarefa) {
        tarefa.definirMomentoAprovacao();
        tarefaManualAprovacaoRepositorio.save(tarefa);
    }

public void saveTicket(Ticket ticket){
        ticketRepo.save(ticket);
}
}
