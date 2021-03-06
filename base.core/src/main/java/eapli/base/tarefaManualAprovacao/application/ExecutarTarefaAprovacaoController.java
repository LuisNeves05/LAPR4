package eapli.base.tarefaManualAprovacao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualAprovacao.service.TarefasAprovadasService;
import eapli.base.tarefaManualExecucao.services.CriarTarefaManualExecucaoService;
import eapli.base.tarefaManualAprovacao.service.TerminarAprovacaoService;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import java.util.List;
import java.util.Map;


public class ExecutarTarefaAprovacaoController {
    private Colaborador colabPedido;
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();
    private final CriarTarefaManualExecucaoService criarTarefaManualExecucaoService = new CriarTarefaManualExecucaoService(txCtx);
    private final TarefasAprovadasService aprovarTicketService = new TarefasAprovadasService();
    private final TerminarAprovacaoService terminarAprovacaoService = new TerminarAprovacaoService(txCtx);

    public ExecutarTarefaAprovacaoController() {
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if (authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            SystemUser systemUser = userSession.authenticatedUser();
            this.colabPedido = colabPorUserName(systemUser.username());
        }
    }

    public TarefaManualAprovacao terminarAprovacao(Formulario f, Map<Resposta, Integer> respostas, TarefaManualAprovacao tarefaManualAprovacao){
        txCtx.beginTransaction();
        TarefaManualAprovacao tarManAprov = terminarAprovacaoService.terminaAprovacao(f, respostas, tarefaManualAprovacao, colabPedido);
        txCtx.commit();
        txCtx.close();
        return tarManAprov;
    }
    public void decisao(String resposta, TarefaManualAprovacao tarefaManualAprovacao) {
        if (resposta.equalsIgnoreCase("deferido")) {
            tarefaManualAprovacao.aprovado();
            tarefaManualAprovacao.ticketDaTarefa().aprovarTicket();
            if (tarefasAprovacaoAprovadas(tarefaManualAprovacao.ticketDaTarefa())) {
                criarTarefaManualExecucao(tarefaManualAprovacao.ticketDaTarefa().servicoDoTicket(), tarefaManualAprovacao.ticketDaTarefa());
                tarefaManualAprovacao.ticketDaTarefa().emExecucao();
            }
        } else {
            tarefaManualAprovacao.rejeitado();
            tarefaManualAprovacao.ticketDaTarefa().rejeitarTicket();
        }
    }

    public Colaborador colabPorUserName(Username username) {
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public List<TarefaManualAprovacao> tarefasManualAprovacao() {
        return tarefaManualAprovacaoRepositorio.tarefasManuaisAprovacaoNA(colabPedido);
    }

    public void criarTarefaManualExecucao(Servico s, Ticket t) {
        criarTarefaManualExecucaoService.criarTarefaExecucao(s, t);
    }

    public boolean tarefasAprovacaoAprovadas(Ticket ticket) {
        return aprovarTicketService.tarefasTotalmenteAprovadas(ticket);
    }

    public Resposta adicionarResposta(String reposta, String nomeVar){
        return new Resposta(reposta,nomeVar);
    }


}
