package eapli.base.servico.application;


import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
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
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SolicitarServicoController {

    private SystemUser systemUser;

    private Colaborador colabPedido;

    //private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final CatalogoRepositorio catRep = PersistenceContext.repositories().catalogoRepositorio();
    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();
    private final CriarTarefaManualExecucaoService criarTarefaManualExecucaoService = new CriarTarefaManualExecucaoService();
    private final CriarTarefaManualAprovacaoService criarTarefaManualAprovacaoService = new CriarTarefaManualAprovacaoService();
    private final AtivarDesativarFluxoService ativarDesativarFluxoService = new AtivarDesativarFluxoService();

    public SolicitarServicoController() {
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if (authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
            this.colabPedido = colabPorUserName(systemUser.username());
        }
    }

    public Ticket criarTicket(Servico s, String urgencia) {
        //txCtx.beginTransaction();
        if (s.fluxoDoServico().ativAprovacaoDoFluxo() != null)
            return ticketRepositorio.save(new Ticket(colabPedido, s, urgencia, EstadoTicket.POR_APROVAR));
        else
            return ticketRepositorio.save(new Ticket(colabPedido, s, urgencia, EstadoTicket.EM_EXECUCAO));
    }


    public void solicitarServico(Servico s, Ticket ticket, Set<FormularioPreenchido> fps) {
        if (!criarTarefaManualAprovacaoService.criarTarefaAprovacao(s, ticket, colabPedido))
            criarTarefaManualExecucaoService.criarTarefaExecucao(s, ticket);

        for(FormularioPreenchido fp : fps){
            fpr.save(fp);
        }
        ativarDesativarFluxoService.ativarFluxo(s.fluxoDoServico());
        //txCtx.commit();
        //txCtx.close();
    }

    public List<Catalogo> listarCatalogosPorUser() {

        Iterable<Equipa> equipasColaborador = colaboradorRepositorio.equipasColaboradorPorUsername(systemUser.username());
        List<Catalogo> catalogosColab = new ArrayList<>();

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

    public FormularioPreenchido adicionaFormularioPreenchido(Formulario f, String urgencia, Set<Resposta> respostas, Ticket ticket) {
        return new FormularioPreenchido(f, urgencia, respostas, ticket, colabPedido);
    }
}
