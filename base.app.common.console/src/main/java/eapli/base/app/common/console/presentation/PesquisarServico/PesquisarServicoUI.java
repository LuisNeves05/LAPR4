package eapli.base.app.common.console.presentation.PesquisarServico;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class PesquisarServicoUI extends Menu {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private static final String MENU_TITLE = "Pesquisa Serviço >";

    private static final int EXIT_OPTION = 0;

    private static final int PESQUISAR_SERVICO_IDENTIFICADOR = 1;
    private static final int PESQUISAR_SERVICO_TITULO = 2;
    private static final int PESQUISAR_SERVICO_DESC_BREVE = 3;
    private static final int PESQUISAR_SERVICO_KEYWORD = 4;

    public PesquisarServicoUI(){
            super(MENU_TITLE);
            buildPesquisarMenu();
    }

    private void buildPesquisarMenu() {

        if (authz.hasSession()) {
            addItem(MenuItem.of(PESQUISAR_SERVICO_IDENTIFICADOR, "Pesquisar por Identificador", new PesquisaServicoIdentificadorUI()::show));
            addItem(MenuItem.of(PESQUISAR_SERVICO_TITULO, "Pesquisar por Título", new PesquisaServicoTituloUI()::show));
            addItem(MenuItem.of(PESQUISAR_SERVICO_DESC_BREVE, "Pesquisar por Descrição Breve", new PesquisaServicoDescBreveUI()::show));
            addItem(MenuItem.of(PESQUISAR_SERVICO_KEYWORD, "Pesquisar por palavra-chave (Keyword)", new PesquisaServicoKeywordUI()::show));
        } else {
            System.out.println("Não tem acesso");
        }
        addItem(MenuItem.of(EXIT_OPTION, "Voltar ", Actions.SUCCESS));
    }
}
