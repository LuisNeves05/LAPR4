package eapli.base.tarefaManual.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManual.domain.TarefaManualAprovacao;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.base.tarefaManual.persistance.TarefaExecucaoRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;

public class ExecutarTarefaController {

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TarefaExecucaoRepositorio tarefaExecucaoRepositorio =  PersistenceContext.repositories().tarefaExecucaoRepositorio();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabPedido =colabPorUserName(systemUser.username());
    private final List<Equipa> equipasColab = colabPedido.obterEquipasColaborador();
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();

    public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }



    public List<TarefaManualExecucao> tarefasManualExecucao(){
        return  tarefaExecucaoRepositorio.tarefasManuaisExecucaoNA(equipasColab);
    }

    public List<TarefaManualExecucao> tarefasManualExecucaoPendente(){
        return  tarefaExecucaoRepositorio.tarefasManuaisExecEmExecucao(colabPedido);
    }

    public List<TarefaManualAprovacao> tarefasManualAprovacao( ){
        return tarefaExecucaoRepositorio.tarefasManuaisAprovacaoNA(colabPedido);
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
//todo executarTarefa Aprovacao
    public TarefaManualAprovacao executarTarefaAprPendente(TarefaManualAprovacao tarefa ) {
    //    tarefa.defineColaboradorExecutante(colabPedido);

        try {
            //TODO GUARDAR TAREFA MANUAL APROVACAO
            return tarefaExecucaoRepositorio.save(tarefa);
        } catch (IntegrityViolationException violation) {
            System.out.println("Erro na persistência da tarefa!");
        }
        return null;
    }
}
