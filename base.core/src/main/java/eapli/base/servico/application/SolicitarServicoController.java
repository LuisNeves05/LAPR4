package eapli.base.servico.application;


import eapli.base.Utils.bibliotecaTarefa.TiposDeTarefa;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.atividadeAprovacao.persistence.AtividadeAprovacaoRepositorio;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.atividadeRealizacao.persistence.AtividadeRealizacaoRepositorio;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.persistence.FluxoAtividadeRepositorio;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualExecucao.domain.EstadoRealizacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
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

    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();

    private final CatalogoRepositorio catRep = PersistenceContext.repositories().catalogoRepositorio();

    private final FormularioRepositorio repoForm = PersistenceContext.repositories().formularioRepositorio();

    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();

    private final FluxoAtividadeRepositorio fluxoAtividadeRepositorio = PersistenceContext.repositories().fluxoAtividadeRepositorio();

    private final AtividadeRealizacaoRepositorio atividadeRealizacaoRepositorio = PersistenceContext.repositories().atividadeRealizacaoRepositorio();

    private final AtividadeAprovacaoRepositorio atividadeAprovacaoRepositorio = PersistenceContext.repositories().atividadeAprovacaoRepositorio();

    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();

    private final TarefaManualExecucaoRepositorio tarefaManualExecucaoRep = PersistenceContext.repositories().tarefaManualExecucaoRepositorio();

    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRep = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();

    private final TarefaAutomaticaRepositorio tarefaAutomaticaRepositorio = PersistenceContext.repositories().tarefaAutomaticaRepositorio();

    private final TiposDeTarefa tiposDeTarefa = new TiposDeTarefa();


    public SolicitarServicoController(){
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if(authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
            this.colabPedido = colabPorUserName(systemUser.username());
        }
    }

    public List<Catalogo> listarCatalogosPorUser(){

        List<Equipa> equipasColaborador = (List<Equipa>) equipasDoColaborador();
        List<Catalogo> catalogosColab = new ArrayList<>();

        for(Equipa eq : equipasColaborador){
            catalogosColab.addAll((List<Catalogo>) catRep.catalogosPorEquipa(eq));
        }

        return catalogosColab;
    }

    public List<Servico> listarServicosPorCat(Catalogo catalogo){
        return repoServ.servicoPorCatalogo(catalogo);
    }

    public List<Formulario> formulariosServico(Servico servico){
        return (List<Formulario>) repoForm.formularioPorServico(servico);
    }

    public Iterable<Equipa> equipasDoColaborador(){
        return colaboradorRepositorio.equipasColaboradorPorUsername(systemUser.username());
    }

    public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public void saveFormPreenchido(FormularioPreenchido fp){
        fpr.save(fp);
    }


    public TiposDeTarefa tiposDeTarefa(){
        return tiposDeTarefa;
    }

    public Colaborador colaboradorLogado(){
        return colabPedido;
    }

    public boolean validaUrgencia(String urgencia) {
        return urgencia.equalsIgnoreCase("baixa") || urgencia.equalsIgnoreCase("moderada") || urgencia.equalsIgnoreCase("alta");
    }

    public Ticket criarTicket(Servico s, String urgencia){
        if(s.fluxoDoServico().ativAprovacaoDoFluxo() == null)
            return ticketRepositorio.save(new Ticket(colabPedido, s, s.nivelCriticidadeServico(), urgencia, EstadoTicket.POR_APROVAR));
        else
            return ticketRepositorio.save(new Ticket(colabPedido, s, s.nivelCriticidadeServico(), urgencia, EstadoTicket.EM_EXECUCAO));
    }

    public boolean criarTarefaAprovacao(Servico s, Ticket ticket) {
        AtividadeAprovacao at = s.fluxoDoServico().ativAprovacaoDoFluxo();

        if (at != null) {
            Set<ColaboradoresAprovacao> colabsApov = at.colabsDeAprovacao();
            TarefaManualAprovacao tarefaManualAprovacao = tiposDeTarefa().novaTarefaManualAprovacao(ticket);
            if (colabsApov.contains(ColaboradoresAprovacao.RESPONSAVEL_HIERARQUICO)) {
                Colaborador respHierarquico = colaboradorLogado().seuColabResponsavel();
                tarefaManualAprovacao.assignaColabAprovacao(respHierarquico);
            }
            if (colabsApov.contains(ColaboradoresAprovacao.RESPONSAVEL_PELO_SERVICO)) {
                Colaborador respServico = s.catalogo().colaboradorResponsavelDoCatalogo();
                tarefaManualAprovacao.assignaColabAprovacao(respServico);
            }
            TarefaManualAprovacao tarManAprov = tarefaManualAprovacaoRep.save(tarefaManualAprovacao);
            at.adicionaTarefaAprov(tarManAprov);
            atividadeAprovacaoRepositorio.save(at);
            return true;
        }else{
            return false;
        }
    }

    public void criarTarefaExecucao(Servico s, Ticket ticket) {
        AtividadeRealizacao ar = s.fluxoDoServico().ativRealizacaoDoFluxo();

        if (ar.tipoExecucao() == TipoExecucao.MANUAL) {
            if (!ar.equipasExecucao().isEmpty()) {
                TarefaManualExecucao tme = tiposDeTarefa().novaTarefaManualExecucaoEquipa(ticket, ar.equipasExecucao());
                for (Equipa equipa : ar.equipasExecucao()) {
                    tme.adicionaEquipaExecucao(equipa);
                }
                TarefaManualExecucao tarManExec = tarefaManualExecucaoRep.save(tme);
                ar.adicionarTarefaExecucao(tarManExec);

            } else if (ar.colabExec() != null) {
                TarefaManualExecucao tarManExec = tarefaManualExecucaoRep.save(tiposDeTarefa().
                        novaTarefaManualExecucaoColaborador(ticket, ar.colabExec(), EstadoRealizacao.POR_EXECUTAR));
                ar.adicionarTarefaExecucao(tarManExec);
            }
        } else {
            TarefaAutomatica tarefaAutomatica = tiposDeTarefa().novaTarefaAutomatica(ticket, ar.scriptAutomatico());
            TarefaAutomatica tarAut = tarefaAutomaticaRepositorio.save(tarefaAutomatica);
            ar.adicionarTarefaAutomatica(tarAut);
        }
        atividadeRealizacaoRepositorio.save(ar);
    }

    public FluxoAtividade guardarFluxo(FluxoAtividade fluxoDoServico) {
        return fluxoAtividadeRepositorio.save(fluxoDoServico);
    }

    public void ativarFluxoServico(FluxoAtividade fluxoDoServico) {
        fluxoDoServico.ativar();
    }

    public boolean solicitarServico(Servico s, String urgencia) {
        Ticket ticket = criarTicket(s, urgencia);

        if(!criarTarefaAprovacao(s, ticket))
            criarTarefaExecucao(s, ticket);

            ativarFluxoServico(s.fluxoDoServico());
            return guardarFluxo(s.fluxoDoServico()) != null;
    }
}