package eapli.base.servico.application;


import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.fluxoAtividade.service.AtivarDesativarFluxoService;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tarefaManualAprovacao.service.CriarTarefaManualAprovacaoService;
import eapli.base.tarefaManualExecucao.services.CriarTarefaManualExecucaoService;
import eapli.base.ticket.domain.EstadoTicket;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolicitarServicoController {

    private SystemUser systemUser;

    private Colaborador colabPedido;

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final CatalogoRepositorio catRep = PersistenceContext.repositories().catalogoRepositorio();
    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio(txCtx);
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio(txCtx);
    private final CriarTarefaManualExecucaoService criarTarefaManualExecucaoService = new CriarTarefaManualExecucaoService(txCtx);
    private final CriarTarefaManualAprovacaoService criarTarefaManualAprovacaoService = new CriarTarefaManualAprovacaoService(txCtx);
    private final AtivarDesativarFluxoService ativarDesativarFluxoService = new AtivarDesativarFluxoService(txCtx);
    private final EquipaRepositorio equipaRepositorio = PersistenceContext.repositories().equipaRepositorio();

    public SolicitarServicoController() {
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if (authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
            this.colabPedido = colabPorUserName(systemUser.username());
        }
    }


    public void solicitarServico(Servico s, Ticket ticket, Set<FormularioPreenchido> fps) {
        txCtx.beginTransaction();

        for (FormularioPreenchido fp : fps) {
            ticket.adicionaFormularioResposta(fpr.save(fp));
        }

        Ticket tic = ticketRepositorio.save(ticket);

        if (!criarTarefaManualAprovacaoService.criarTarefaAprovacao(s, tic, colabPedido))
            criarTarefaManualExecucaoService.criarTarefaExecucao(s, tic);

        ativarDesativarFluxoService.ativarFluxo(s.fluxoDoServico());
        txCtx.commit();
        txCtx.close();
    }

    public Ticket criarTicket(Servico s, String urgencia) {
        if (s.fluxoDoServico().ativAprovacaoDoFluxo() != null)
            return new Ticket(colabPedido, s, urgencia, EstadoTicket.POR_APROVAR);
        else
            return new Ticket(colabPedido, s, urgencia, EstadoTicket.EM_EXECUCAO);
    }

    public Set<Catalogo> listarCatalogosPorUser() {

        Iterable<Equipa> equipasColaborador = equipaRepositorio.equipasDoColaborador(colabPedido);
        Set<Catalogo> catalogosColab = new HashSet<>();

        for (Equipa eq : equipasColaborador) {
            catalogosColab.addAll((List<Catalogo>) catRep.catalogosPorEquipa(eq));
        }

        return catalogosColab;
    }

    public List<Servico> listarServicosPorCat(Catalogo catalogo) {
        return repoServ.servicoPorCatalogo(catalogo);
    }

    public Colaborador colabPorUserName(Username username) {
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public boolean validaUrgencia(String urgencia) {
        return urgencia.equalsIgnoreCase("baixa") || urgencia.equalsIgnoreCase("moderada") || urgencia.equalsIgnoreCase("alta");
    }

    public FormularioPreenchido adicionaFormularioPreenchido(Formulario f, String urgencia, Map<Resposta, Integer> respostas) {
        return new FormularioPreenchido(f, urgencia, respostas, colabPedido);
    }
}
