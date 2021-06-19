package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PesquisarCatalogoController {

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();

    private final CatalogoRepositorio repoCat = PersistenceContext.repositories().catalogoRepositorio();

    private final EquipaRepositorio equipaRepositorio = PersistenceContext.repositories().equipaRepositorio();

    private SystemUser systemUser;
    private Colaborador colaborador;

    public PesquisarCatalogoController(){
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if(authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
            this.colaborador = colaboradorRepositorio.colabPorUsername(systemUser.username()).iterator().next();
        }
    }

    /**
     * Repositório do Catalogo
     */

    public Iterable<Catalogo> pesquisaTitulo(final String titulo){

        Iterable<Equipa> equipasColaborador = equipasDoColaborador();

        Set<Catalogo> listaCatalogo = new HashSet<>();

        for(Equipa eq : equipasColaborador){
            listaCatalogo.addAll((List<Catalogo>) pesquisarCatalogoPorTitulo(eq,titulo));
        }

        return listaCatalogo;
    }

    public Iterable<Catalogo> pesquisaDescBreve(final String descBreve){

        Iterable<Equipa> equipasColaborador = equipasDoColaborador();

        Set<Catalogo> listaCatalogo = new HashSet<>();

        for(Equipa eq : equipasColaborador){
            listaCatalogo.addAll((List<Catalogo>) pesquisarCatalogoPorDescBreve(eq,descBreve));
        }

        return listaCatalogo;
    }

    public Iterable<Catalogo> pesquisarCatalogoPorTitulo(final Equipa equipa, final String titulo){
        return repoCat.catalogosPorEquipaPorTitulo(equipa,titulo);
    }

    public Iterable<Catalogo> pesquisarCatalogoPorDescBreve(final Equipa equipa, final String descbreve){
        return repoCat.catalogosPorEquipaPorDescBreve(equipa, descbreve);
    }

    public Iterable<Equipa> equipasDoColaborador(){
        return equipaRepositorio.equipasDoColaborador(colaborador);
    }
}
