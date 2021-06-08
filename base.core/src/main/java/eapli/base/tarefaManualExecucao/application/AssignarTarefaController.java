package eapli.base.tarefaManualExecucao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

public class AssignarTarefaController {

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TarefaManualExecucaoRepositorio tarefaManualExecucaoRepositorio =  PersistenceContext.repositories().tarefaManualExecucaoRepositorio();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabPedido =colabPorUserName(systemUser.username());
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();

    public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public Iterable<Equipa>equipasColab(){
       return colaboradorRepositorio.equipasColaboradorPorUsername(systemUser.username());
    }

    public Iterable<TarefaManualExecucao> tarefasManualExecucao( Equipa equipa){
        return tarefaManualExecucaoRepositorio.tarefasManuaisExecucaoNA(equipa);
    }

    public Iterable<TarefaManualAprovacao> tarefasManualAprovacao( ){
        return tarefaManualExecucaoRepositorio.tarefasManuaisAprovacaoNA(colabPedido);
    }

    public TarefaManualExecucao assignarTarefaExecutante(TarefaManualExecucao tarefa) {
        tarefa.defineColaboradorExecutante(colabPedido);

        try {
            return tarefaManualExecucaoRepositorio.save(tarefa);
        } catch (IntegrityViolationException violation) {
            System.out.println("Erro na persistência da tarefa!");
        }
        return null;
    }

    public Colaborador responsavelTarefa(){
        return this.colabPedido;
    }
}
