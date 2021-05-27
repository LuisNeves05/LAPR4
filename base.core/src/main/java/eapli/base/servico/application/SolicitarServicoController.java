package eapli.base.servico.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tarefa.persistance.TarefaExecucaoRepositorio;
import eapli.base.ticket.domain.Ticket;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.ArrayList;
import java.util.List;

public class SolicitarServicoController {

    private SystemUser systemUser;

    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();

    private final CatalogoRepositorio catRep = PersistenceContext.repositories().catalogoRepositorio();

    private final FormularioRepositorio repoForm = PersistenceContext.repositories().formularioRepositorio();

    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();

    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();




    public SolicitarServicoController(){
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if(authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
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

    public Ticket guardarTicket(Ticket ticket){
        return ticketRepositorio.save(ticket);
    }
}