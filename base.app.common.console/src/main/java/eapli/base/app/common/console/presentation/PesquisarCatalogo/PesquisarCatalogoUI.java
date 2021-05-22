package eapli.base.app.common.console.presentation.PesquisarCatalogo;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class PesquisarCatalogoUI extends Menu {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private static final String MENU_TITLE = "Pesquisa Catálogo >";

    private static final int EXIT_OPTION = 0;

    private static final int PESQUISAR_CATALOGO_TITULO = 1;
    private static final int PESQUISAR_CATALOGO_DESC_BREVE = 2;

    public PesquisarCatalogoUI(){
            super(MENU_TITLE);
            buildPesquisarCatalogoMenu();
    }

    private void buildPesquisarCatalogoMenu() {

        if (authz.hasSession()) {
            addItem(MenuItem.of(PESQUISAR_CATALOGO_TITULO, "Pesquisar por Titulo", new PesquisaCatalogoTituloUI()::show));
            addItem(MenuItem.of(PESQUISAR_CATALOGO_DESC_BREVE, "Pesquisar por Descrição Breve", new PesquisaCatalogoDescBreveUI()::show));
        } else {
            System.out.println("Não tem acesso");
        }
        addItem(MenuItem.of(EXIT_OPTION, "Voltar ", Actions.SUCCESS));
    }
}
