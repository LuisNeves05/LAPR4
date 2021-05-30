/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.common.console.presentation.authz;

import eapli.base.app.common.console.presentation.EspecificarEquipa.EspecificarEquipaUI;
import eapli.base.app.common.console.presentation.adicionarNivelCriticidadeUI.AdicionarNivelCriticidadeUI;
import eapli.base.app.common.console.presentation.assignarTarefa.AssignarTarefasUI;
import eapli.base.app.common.console.presentation.especificarNivelCriticidadeUI.EspecificarNivelCriticidadeUI;
import eapli.base.app.common.console.presentation.especificarcatalogoUI.EspecificarCatalogoUI;
import eapli.base.app.common.console.presentation.EspecificarServicoUI.EspecificarServicoUI;

import eapli.base.app.common.console.presentation.especificarcolaboradorUI.EspecificarColaboradorUI;
import eapli.base.app.common.console.presentation.EspecificarServicoUI.TerminarEspecificacaoServicoPendenteUI;
import eapli.base.app.common.console.presentation.solicitarservicoUI.SolicitarServicoUI;
import eapli.base.tarefaManual.domain.TarefaManual;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;

public class MyUserMenu extends Menu {

    private static final String MENU_TITLE = "My account >";

    private static final int EXIT_OPTION = 0;

    private static final int CHANGE_PASSWORD_OPTION = 1;
    private static final int LOGIN_OPTION = 2;
    private static final int LOGOUT_OPTION = 3;
    private static final int ESPECIFICAR_SERVICO_OPTION = 4;
    private static final int ESPECIFICAR_COLABORADOR_OPTION = 5;
    private static final int CRIAR_EQUIPA_OPTION = 6;
    private static final int TERMINAR_ESPECIFICAR_SERVICO_OPTION = 7;
    private static final int ESPECIFICAR_CATALOGO_OPTION = 8;
    private static final int SOLICITAR_SERVICO_OPTION = 9;
    private static final int ADICIONAR_NIVEL_CRITICIDADE =10 ;
    private static final int CRIAR_NIVEL_CRITICIDADE =11 ;
    private static final int REIVINDICAR_TAREFA = 12;

    public MyUserMenu() {
        super(MENU_TITLE);
        buildMyUserMenu(null);
    }

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public MyUserMenu(final Role onlyWithThis) {
        super(MENU_TITLE);
        buildMyUserMenu(onlyWithThis);
    }

    private void buildMyUserMenu(final Role onlyWithThis) {
        if (authz.hasSession()) {


            System.out.println("Antes de rodar");
            //ServicoRHCliente n = new ServicoRHCliente();
           //n.start();

            System.out.println("\n depois de rodar");


            addItem(MenuItem.of(CHANGE_PASSWORD_OPTION, "Change password", new ChangePasswordUI()::show));
            addItem(MenuItem.of(LOGIN_OPTION, "Change user", new LoginUI(onlyWithThis)::show));
            addItem(MenuItem.of(LOGOUT_OPTION, "Logout", new LogoutUI()::show));
            //REMOVER DEPOIS //TODO
            addItem(MenuItem.of(ESPECIFICAR_SERVICO_OPTION, "Especificar Serviço", new EspecificarServicoUI()::show));
            addItem(MenuItem.of(ESPECIFICAR_COLABORADOR_OPTION, "Especificar Colaborador", new EspecificarColaboradorUI()::show));
            addItem(MenuItem.of(CRIAR_EQUIPA_OPTION, "Criar nova Equipa", new EspecificarEquipaUI()::show));
            addItem(MenuItem.of(TERMINAR_ESPECIFICAR_SERVICO_OPTION, "Terminar especificação de servicos", new TerminarEspecificacaoServicoPendenteUI()::show));
            addItem(MenuItem.of(ESPECIFICAR_CATALOGO_OPTION, "Especificar catalogo", new EspecificarCatalogoUI()::show));
            addItem(MenuItem.of(SOLICITAR_SERVICO_OPTION, "Solicitar Serviço", new SolicitarServicoUI()::show));
            addItem(MenuItem.of( ADICIONAR_NIVEL_CRITICIDADE , "Adicionar Nível de Criticidade", new AdicionarNivelCriticidadeUI()::show));
            addItem(MenuItem.of( CRIAR_NIVEL_CRITICIDADE , "Criar Nível de Criticidade", new EspecificarNivelCriticidadeUI()::show));
            addItem(MenuItem.of( REIVINDICAR_TAREFA , "Reivindicar Tarefa", new AssignarTarefasUI()::show));

        } else {
            addItem(MenuItem.of(LOGIN_OPTION, "Login", new LoginUI(onlyWithThis)::show));
        }
        addItem(MenuItem.of(EXIT_OPTION, "Return ", Actions.SUCCESS));
    }
}
