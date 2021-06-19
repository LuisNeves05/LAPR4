package eapli.base.app.common.console.presentation.SLA_UI;

import eapli.base.app.common.console.presentation.PesquisarCatalogo.PesquisaCatalogoDescBreveUI;
import eapli.base.app.common.console.presentation.PesquisarCatalogo.PesquisaCatalogoTituloUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class SLA_UI extends Menu {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private static final String MENU_TITLE = "Consultar SLA >";

    private static final int EXIT_OPTION = 0;

    private static final int CONSULTAR_SLA = 1;

    public SLA_UI(){
        super(MENU_TITLE);
        buildSLAMenu();
    }

    private void buildSLAMenu() {

        if (authz.hasSession()) {
            addItem(MenuItem.of(CONSULTAR_SLA, "Consultar SLA", new ConsultaSLA_UI()::show));
        } else {
            System.out.println("Não tem acesso");
        }
        addItem(MenuItem.of(EXIT_OPTION, "Voltar ", Actions.SUCCESS));
    }
}
