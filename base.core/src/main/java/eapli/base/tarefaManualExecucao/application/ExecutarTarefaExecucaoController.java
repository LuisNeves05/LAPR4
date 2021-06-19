package eapli.base.tarefaManualExecucao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.TipoDados;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.tarefaManualExecucao.services.ExecutarTarefaManualExecucaoService;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;
import java.util.Map;

public class ExecutarTarefaExecucaoController {
    private final TransactionalContext tcCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TarefaManualExecucaoRepositorio tarefaExecucaoRepositorio =  PersistenceContext.repositories().tarefaManualExecucaoRepositorio();
    private Colaborador colabPedido;
    private List<Equipa> equipasColab;
    private final ExecutarTarefaManualExecucaoService execTarManExecService = new ExecutarTarefaManualExecucaoService(tcCtx);

    public ExecutarTarefaExecucaoController() {
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if (authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            SystemUser systemUser = userSession.authenticatedUser();
            this.colabPedido = colabPorUserName(systemUser.username());
            equipasColab = colabPedido.obterEquipasColaborador();
        }
    }

    public void executaTarefa(Formulario f, Map<Resposta, Integer> respostas, TarefaManualExecucao tarefaManualExecucao) {
        tcCtx.beginTransaction();
        execTarManExecService.executarTarefa(f, respostas, tarefaManualExecucao, colabPedido);
        tcCtx.commit();
        tcCtx.close();
    }

    public void conclusao(String resposta, TarefaManualExecucao tarefaManualExecucao, Atributo atributo){
            if (atributo.tipoDados() == TipoDados.CONCLUSAO) {
                if (resposta.equalsIgnoreCase("Concluido")) {
                    tarefaManualExecucao.ticketDaTarefa().completarTicket();
                } else {
                    tarefaManualExecucao.ticketDaTarefa().inacabadoTicket();
                }
            }
    }

    public List<TarefaManualExecucao> tarefasManualExecucao(){
        return tarefaExecucaoRepositorio.tarefasManuaisExecucaoNA(equipasColab);
    }

    public List<TarefaManualExecucao> tarefasManualExecucaoPendente(){
        return tarefaExecucaoRepositorio.tarefasManuaisExecEmExecucao(colabPedido);
    }

    public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
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

    public Resposta adicionaResposta(String resposta, String nomeVar) {
        return new Resposta(resposta, nomeVar);
    }


}
