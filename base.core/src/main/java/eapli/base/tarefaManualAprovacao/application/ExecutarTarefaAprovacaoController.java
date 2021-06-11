package eapli.base.tarefaManualAprovacao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;

public class ExecutarTarefaAprovacaoController {
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio =  PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabPedido =colabPorUserName(systemUser.username());
    private final List<Equipa> equipasColab = colabPedido.obterEquipasColaborador();


    public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public List<TarefaManualAprovacao> tarefasManualAprovacao( ){
        return  tarefaManualAprovacaoRepositorio.tarefasManuaisAprovacaoNA(colabPedido);
    }

    public TarefaManualAprovacao executarTarefaAprPendente(TarefaManualAprovacao tarefa ) {
        //    tarefa.defineColaboradorExecutante(colabPedido);

        try {
            //TODO GUARDAR TAREFA MANUAL APROVACAO
            return tarefaManualAprovacaoRepositorio.save(tarefa);
        } catch (IntegrityViolationException violation) {
            System.out.println("Erro na persistência da tarefa!");
        }
        return null;
    }
}
