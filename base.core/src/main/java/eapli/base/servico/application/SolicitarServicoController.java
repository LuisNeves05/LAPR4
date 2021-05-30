package eapli.base.servico.application;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
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
import eapli.base.atividadeRealizacao.domain.TipoExecucao;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaManual.domain.TarefaManual;
import eapli.base.Utils.bibliotecaTarefa.TiposDeTarefa;
import eapli.base.tarefaManual.domain.TarefaManualAprovacao;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.base.tarefaManual.domain.estado.EstadoRealizacao;
import eapli.base.tarefaManual.persistance.TarefaExecucaoRepositorio;
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


    public FluxoAtividade guardarFluxo(FluxoAtividade fluxoAtividade){
        return fluxoAtividadeRepositorio.save(fluxoAtividade);
    }

    public TiposDeTarefa tiposDeTarefa(){
        return tiposDeTarefa;
    }

    public Colaborador colaboradorLogado(){
        return colabPedido;
    }

    public Ticket criarTicket(Servico s, String urgencia) {
        return new Ticket(this.colabPedido, s, s.nivelCriticidadeServico(), urgencia, EstadoTicket.POR_APROVAR);
    }

    public void  criarTarefaAprovacao(Servico s, Ticket ticket) {
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
            at.adicionaTarefaAprov(tarefaManualAprovacao);
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
                ar.adicionarTarefaExecucao(tme);
            } else if (ar.colabExec() != null) {
                TarefaManualExecucao tme = tiposDeTarefa().novaTarefaManualExecucaoColaborador(ticket, ar.colabExec(), EstadoRealizacao.POR_EXECUTAR);
                ar.adicionarTarefaExecucao(tme);
            }
        } else {
            TarefaAutomatica tarefaAutomatica = tiposDeTarefa().novaTarefaAutomatica(ticket, ar.scriptAutomatico());
            ar.adicionarTarefaAutomatica(tarefaAutomatica);
        }

    }
}