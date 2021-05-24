package eapli.base.servico.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.formulario.domain.Formulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe Controller da Especificação de um Serviço
 */
public class EspecificarServicoController {

    /**
     * Repositório do Serviço
     */
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();
    private final CatalogoRepositorio repoCat = PersistenceContext.repositories().catalogoRepositorio();
    private final ColaboradorRepositorio colabRep = PersistenceContext.repositories().colaboradorRepositorio();
    private final EquipaRepositorio eqRep = PersistenceContext.repositories().equipaRepositorio();

    private SystemUser systemUser;

    public EspecificarServicoController(){
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if(authorizationService.hasSession() && authorizationService.session().isPresent()) {
            UserSession userSession = authorizationService.session().get();
            this.systemUser = userSession.authenticatedUser();
        }
    }

    /**
     * Especificação de um novo Serviço
     */
    public Servico especificarServico(Servico servico) {
       return this.repoServ.save(servico);
    }

    /**
     * Listar todas os Catalogos da base de dados
     */
    public Iterable<Catalogo> listaCatalogos() {
        return repoCat.findAll();
    }

    public void adicionaFormulario(Servico s, Formulario formulario){
        s.adicionaFormulario(formulario);
        repoServ.save(s);
        s.limpaForms();
    }

    public void adicionaColabAprov(Servico s, List<Colaborador> colabs){
        s.adicionaColaboradorAprov(colabs);
        repoServ.save(s);
        s.limpaColabs();
    }

    public void adicionaEquipaExec(Servico s, List<Equipa> equipas){
        s.adicionaEquipaExec(equipas);
        repoServ.save(s);
        s.limpaEquipasExec();
    }

    public List<Servico> servicosIncompletos() {
        return repoServ.servicosIncompletos();
    }

    public List<Colaborador> colabsAprov() {
        Colaborador mainColab = colabRep.colabPorUsername(systemUser.username()).iterator().next();
        Set<Colaborador> colabs = new HashSet<>();
        colabs.add(mainColab);
        colabs.add(mainColab.seuColabResponsavel());
        return new ArrayList<>(colabs);
    }

    public List<Equipa> equipasExecDoCatalogo(Catalogo catalogo) {
        return (List<Equipa>) eqRep.equipasDoCatalogo(catalogo);
    }

    public List<Colaborador> colabsExecCatalogo(Catalogo catalogo) {
        List<Equipa> equipasCatalogo = (List<Equipa>) eqRep.equipasDoCatalogo(catalogo);
        Set<Colaborador> colabsExec = new HashSet<>();
        for(Equipa eq : equipasCatalogo){
            Iterable<Colaborador> colaboradores = colabRep.colabsDoCatalogo(eq);
            for(Colaborador c : colaboradores){
                colabsExec.add(c);
            }
        }
        return new ArrayList<>(colabsExec);
    }

    public void adicionarNivelCritServ(Servico s, NivelCriticidade nC){
        s.adicionarNivelCriticidade(nC);
        repoServ.save(s);
    }
}
