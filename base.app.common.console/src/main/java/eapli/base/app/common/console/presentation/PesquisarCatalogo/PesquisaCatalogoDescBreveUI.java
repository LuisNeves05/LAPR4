package eapli.base.app.common.console.presentation.PesquisarCatalogo;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.persistencia.EquipaRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.application.PesquisarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PesquisaCatalogoDescBreveUI extends AbstractUI {

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();

    private final EquipaRepositorio equipaRepositorio = PersistenceContext.repositories().equipaRepositorio();

    private final CatalogoRepositorio catalogoRep = PersistenceContext.repositories().catalogoRepositorio();

    private UserSession userSession;

    public PesquisaCatalogoDescBreveUI(){
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        if(authorizationService.hasSession()) {
            this.userSession = authorizationService.session().get();
        }
    }

    @Override
    protected boolean doShow() {

        final String descBreve = Console.readLine("Indique a Descrição Breve que quer pesquisar:");

        SystemUser systemUser = userSession.authenticatedUser();

        System.out.println(systemUser.username().toString() + "#######################################\n");

        List<Equipa> equipasColaborador = colaboradorRepositorio.equipasColaboradorPorUsername(systemUser.username());

        List<Catalogo> listaCatalogo = new ArrayList<>();

        for(Equipa eq : equipasColaborador){
            listaCatalogo.addAll(equipaRepositorio.catalogosPorEquipaPorDescBreve(eq, descBreve));
        }

        if(!listaCatalogo.isEmpty()){
            for (Catalogo ct : listaCatalogo){
                System.out.println(ct.toString());
            }
            return true;
        }

        System.out.println("Não conseguimos encontrar esse Serviço");
        return false;
    }

    @Override
    public String headline() {
        return "Pesquisar pela Descrição Breve do Catálogo";
    }
}
