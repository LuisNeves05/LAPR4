/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.app.common.console;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.app.common.console.presentation.RegistarTipoEquipaUI.RegistarTipoEquipaUI;
import eapli.base.catalogo.application.EspecificarCatalogoController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.application.EspecificarNivelCriticidadeController;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.application.ListarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.application.EspecificarFormularioController;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.Servico;
import eapli.base.tipoEquipa.application.RegistarTipoEquipaController;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;
import eapli.framework.infrastructure.eventpubsub.impl.inprocess.InProcessPubSub;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *
 * @author Paulo Gandra Sousa
 */
@SuppressWarnings("squid:S106")
public abstract class BaseApplication {

    final EventDispatcher dispatcher = InProcessPubSub.dispatcher();

    protected static final String SEPARATOR_HR = "=====================================";
    private static final Logger LOGGER = LogManager.getLogger(BaseApplication.class);

    /**
     * @param args
     *            the command line arguments
     */
    public void run(final String[] args) {

        EspecificarEquipaController controllerEquipa = new EspecificarEquipaController();
        EspecificarCatalogoController catalogoController = new EspecificarCatalogoController();
        EspecificarColaboradorController colaboradorController = new EspecificarColaboradorController();
        EspecificarServicoController especificarServicoController = new EspecificarServicoController();
        RegistarTipoEquipaController registarTipoEquipaController = new RegistarTipoEquipaController();
        AddUserController acd = new AddUserController();
        EspecificarFormularioController efc = new EspecificarFormularioController();
        EspecificarNivelCriticidadeController enc = new EspecificarNivelCriticidadeController();

        /**
         * CRIAR TIPO EQUIPA
         */
        TipoEquipa te = registarTipoEquipaController.tipoEquipaServico("Id123","Equipa de Software", Color.BLACK);

        /**
         * CRIAR EQUIPA
         */
        Acronimo acr = new Acronimo("LAPR");
        Equipa equipa = controllerEquipa.especificarEquipa(123L,acr,"Designação Equipa",null,te);

        /**
         * CRIAR COLABORADOR
         */
        List<Equipa> equipasList = new ArrayList<>();
        Set<Equipa> equipasSet = new HashSet<>();
        equipasList.add(equipa);
        equipasSet.add(equipa);
        Date date = new Date("05-12-2000");
        Colaborador c = colaboradorController.especificarColaborador(new NomeCurto("Luis"), new NomeCompleto("Luis Neves"),
                new MecanographicNumber("1191421"), new Morada("Porto", "Penafiel"),
                new NrContacto(910900398), date, null, equipasList);
        Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);
        roles.add(BaseRoles.COLABORADOR);
        acd.addUser("Luis","Password1","Luis","Neves","luismanuelneves@gmail.com",roles);
        colaboradorController.especificarColaborador(new NomeCurto("Rui"), new NomeCompleto("Rui Alves"),
                new MecanographicNumber("1181597"), new Morada("Porto", "Marco de Canaveses"),
                new NrContacto(927206840), date, c, equipasList);

        /**
         * CRIAR CATALOGO
         */
        Catalogo catalogo = catalogoController.especificarCatalogo("Titulo Catalogo","Catalogo RH", "Catalogo de recursos humanos",12,c, equipasSet);

        /**
         * CRIAR Servico
         */
        Keyword k = new Keyword("Software");
        Keyword k2 = new Keyword("JAVA");
        Set<Keyword> keywords = new HashSet<>();
        keywords.add(k);
        keywords.add(k2);
        Servico servico = especificarServicoController.especificarServico("123IDSERV","Titulo Servico","Desc breve Serv","Desc comp Servico",2,true,true,keywords,"COMPLETO",false,catalogo);

        /**
         * CRIAR FORMULARIO
         */
        efc.addAtributo("Nome Variavel","Label do Form","Descricao Ajuda","INTEIRO","EXP regular");
        efc.especificarFormulario(new NomeFormulario("Nome Formulario"),servico);

        /**
         * CRIAR NIVEL CRITICIDADE
         */
        Objetivo obj = new Objetivo(12,50,0,0);
        enc.especificarNivelCriticidade("Etiqueta do nivel", 4, Color.RED,obj);


        printHeader();

        try {
            setupEventHandlers();

            doMain(args);

            printFooter();
        } catch (final Exception e) {
            System.out.println(
                    "Something unexpected has happened and the application will terminate. Please check the logs.\n");
            LOGGER.error(e);
        } finally {
            clearEventHandlers();
        }

        // exiting the application, closing all threads
        System.exit(0);
    }

    protected void printFooter() {
        System.out.println("\n");
        System.out.println(SEPARATOR_HR);
        System.out.println(appGoodbye());
        System.out.println(SEPARATOR_HR);
    }

    protected void printHeader() {
        System.out.println(SEPARATOR_HR);
        System.out.println(appTitle() + " " + Application.VERSION);
        System.out.println(Application.COPYRIGHT);
        System.out.println(SEPARATOR_HR);
    }

    private final void clearEventHandlers() {
        try {
            doClearEventHandlers(dispatcher);

            dispatcher.shutdown();
        } catch (final Exception e) {
            LOGGER.error("Unable to cleanup event handlers", e);
        }
    }

    private final void setupEventHandlers() {
        doSetupEventHandlers(dispatcher);
    }

    protected abstract void doMain(final String[] args);

    protected abstract String appTitle();

    protected abstract String appGoodbye();

    protected void doClearEventHandlers(final EventDispatcher dispatcher) {
        // nothing to do
    }

    protected abstract void doSetupEventHandlers(EventDispatcher dispatcher);
}
