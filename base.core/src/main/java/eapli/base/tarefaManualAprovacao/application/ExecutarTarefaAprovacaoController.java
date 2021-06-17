package eapli.base.tarefaManualAprovacao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualAprovacao.service.TarefaManualAprovacaoService;
import eapli.base.tarefaManualExecucao.services.CriarTarefaManualExecucaoService;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.base.tarefaManualAprovacao.service.TarefasAprovadasService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;
import java.util.Set;


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
    private final CriarTarefaManualExecucaoService criarTarefaManualExecucaoService = new CriarTarefaManualExecucaoService();
    private final TarefasAprovadasService aprovarTicketService = new TarefasAprovadasService();


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

    public TarefaManualAprovacao executarTarefaAprPendente(TarefaManualAprovacao tarefa) {
        //    tarefa.defineColaboradorExecutante(colabPedido);

        return tarefaManualAprovacaoRepositorio.save(tarefa);
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

    public void saveTicket(Ticket ticket) {
        ticketRepo.save(ticket);
    }

    public void criarTarefaManualExecucao(Servico s, Ticket t) {
        criarTarefaManualExecucaoService.criarTarefaExecucao(s, t);
    }

    public boolean tarefasAprovacaoAprovadas(Ticket ticket) {
        return aprovarTicketService.tarefasTotalmenteAprovadas(ticket);
    }


    public void isDecisao(String resposta, TarefaManualAprovacao tarefaManualAprovacao) {
        if (resposta.equalsIgnoreCase("Deferido")) {
            //TODO APROVAR NO MOTOR
            tarefaManualAprovacao.aprovado();
            if (tarefasAprovacaoAprovadas(tarefaManualAprovacao.ticketDaTarefa())) {
                criarTarefaManualExecucao(tarefaManualAprovacao.ticketDaTarefa().servicoDoTicket(), tarefaManualAprovacao.ticketDaTarefa());
                tarefaManualAprovacao.ticketDaTarefa().aprovarTicket();
            }
        } else {
            tarefaManualAprovacao.rejeitado();
            tarefaManualAprovacao.ticketDaTarefa().rejeitarTicket();
        }
    }

    public Resposta adicionarResposta(String reposta, String nomeVar){
        return new Resposta(reposta,nomeVar);
    }

    public void terminarExecucao(Formulario f, Set<Resposta> respostas, TarefaManualAprovacao tarefaManualAprovacao){
        FormularioPreenchido fp = new FormularioPreenchido(f, respostas, tarefaManualAprovacao.ticketDaTarefa(), colabLogged());
        saveFormPreenchido(fp);
        saveTicket(tarefaManualAprovacao.ticketDaTarefa());
        saveTarefaAprovacao(tarefaManualAprovacao);
    }
}
