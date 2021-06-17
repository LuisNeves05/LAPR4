package eapli.base.tarefaManualExecucao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.tarefaManualExecucao.services.ExecutarTarefaManualExecucaoService;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;

public class ExecutarTarefaExecucaoController {
    private final ExecutarTarefaManualExecucaoService execucaoService = new ExecutarTarefaManualExecucaoService();
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TarefaManualExecucaoRepositorio tarefaExecucaoRepositorio =  PersistenceContext.repositories().tarefaManualExecucaoRepositorio();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabPedido =colabPorUserName(systemUser.username());
    private final List<Equipa> equipasColab = colabPedido.obterEquipasColaborador();
    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();


    public ExecutarTarefaExecucaoController() {}

    public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }



    public List<TarefaManualExecucao> tarefasManualExecucao(){
        return tarefaExecucaoRepositorio.tarefasManuaisExecucaoNA(equipasColab);
    }

    public List<TarefaManualExecucao> tarefasManualExecucaoPendente(){
        return tarefaExecucaoRepositorio.tarefasManuaisExecEmExecucao(colabPedido);
    }



    public TarefaManualExecucao executarTarefaExecPendente(TarefaManualExecucao tarefa ) {
        tarefa.defineColaboradorExecutante(colabPedido);

        try {
            return tarefaExecucaoRepositorio.save(tarefa);
        } catch (IntegrityViolationException violation) {
            System.out.println("Erro na persistência da tarefa!");
        }
        return null;
    }


    public Colaborador colablogged(){
        return this.colabPedido;
    }


    public void saveFormPreenchido(FormularioPreenchido fp) {
        fpr.save(fp);
    }

    public void saveTarefaExecucao(TarefaManualExecucao tarefa) {
        tarefa.definirMomentoRealizacao();
        tarefaExecucaoRepositorio.save(tarefa);
    }
    public void saveTicket(Ticket ticket){
        ticketRepositorio.save(ticket);
    }
}
