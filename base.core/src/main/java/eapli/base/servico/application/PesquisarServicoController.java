package eapli.base.servico.application;

import eapli.base.catalogo.application.PesquisarCatalogoController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PesquisarServicoController {

    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();

    private final CatalogoRepositorio catRep = PersistenceContext.repositories().catalogoRepositorio();

    private SystemUser systemUser;

    public PesquisarServicoController(){
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if(authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
        }
    }

    /**
     * Repositório do Serviço
     */
    public Iterable<Servico> pesquisaIdentificador(final String identificador){

        Iterable<Catalogo> listaCatalogo = catalogosColaborador();

        Set<Servico> servicos = new HashSet<>();

        for(Catalogo cs : listaCatalogo){
            servicos.addAll((List<Servico>) pesquisarServicoPorIdentificador(identificador, cs));
        }

        return servicos;
    }

    public Iterable<Servico> pesquisaTitulo(final String titulo){

        Iterable<Catalogo> listaCatalogo = catalogosColaborador();

        Set<Servico> servicos = new HashSet<>();

        for(Catalogo cs : listaCatalogo){
            servicos.addAll((List<Servico>) pesquisarServicoPorTitulo(titulo, cs));
        }

        return servicos;
    }

    public Iterable<Servico> pesquisaDescBreve(final String descBreve){

        Iterable<Catalogo> listaCatalogo = catalogosColaborador();

        Set<Servico> servicos = new HashSet<>();

        for(Catalogo cs : listaCatalogo){
            servicos.addAll((List<Servico>) pesquisarServicoPorDescBreve(descBreve, cs));
        }

        return servicos;
    }

    public Iterable<Servico> pesquisaKeyword(final String keyword){

        Iterable<Catalogo> listaCatalogo = catalogosColaborador();

        Set<Servico> servicos = new HashSet<>();

        for(Catalogo cs : listaCatalogo){
            servicos.addAll((List<Servico>) pesquisarServicoPorKeyword(keyword, cs));
        }

        return servicos;
    }

    public Iterable<Servico> pesquisarServicoPorIdentificador(final String identificador, final Catalogo catalogo){
        return repoServ.servicoPorIdentificadorCatalogo(identificador, catalogo);
    }

    public Iterable<Servico> pesquisarServicoPorTitulo(final String titulo, final Catalogo catalogo){
        return repoServ.servicoPorTitulo(titulo, catalogo);
    }

    public Iterable<Servico> pesquisarServicoPorDescBreve(final String descBreve, final Catalogo catalogo){
        return repoServ.servicoPorDescBreve(descBreve, catalogo);
    }

    public Iterable<Servico> pesquisarServicoPorKeyword(final String keyword, final Catalogo catalogo){
        return repoServ.servicoPorKeyword(keyword, catalogo);
    }

    public Iterable<Equipa> equipasDoColaborador(){
        return colaboradorRepositorio.equipasColaboradorPorUsername(systemUser.username());
    }

    public Iterable<Catalogo> catalogosColaborador(){
        Iterable<Equipa> equipasColaborador = equipasDoColaborador();

        Set<Catalogo> listaCatalogo = new HashSet<>();

        for(Equipa eq : equipasColaborador){
            listaCatalogo.addAll((List<Catalogo>) catRep.catalogosPorEquipa(eq));
        }

        return listaCatalogo;
    }
}
