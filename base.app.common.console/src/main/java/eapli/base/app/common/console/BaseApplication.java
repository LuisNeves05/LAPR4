/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.app.common.console;

import eapli.base.catalogo.application.EspecificarCatalogoController;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.*;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.application.ListarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eapli.base.Application;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;
import eapli.framework.infrastructure.eventpubsub.impl.inprocess.InProcessPubSub;

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

        /*System.out.println("EQUIPAS:");
        EspecificarEquipaController controller = new EspecificarEquipaController();
        EspecificarCatalogoController catalogoController = new EspecificarCatalogoController();
        EspecificarColaboradorController colaboradorController = new EspecificarColaboradorController();
        ListarEquipaController controllerList = new ListarEquipaController();
        Morada morada = new Morada("asaffa", "afsfas");
        Funcao funcao = new Funcao("funcao");
        Colaborador c = new Colaborador(new NomeCurto("asdasdasdas"), new NomeCompleto("jkdashdjkashjash"), null, morada, null, null, null, null);

        Colaborador c2 = colaboradorController.especificarColaborador(new NomeCurto("asdasdasdad"), new NomeCompleto("asdasdasd"), null, morada, null, null, null, null);
        //catalogoController.especificarCatalogo("Titulo Catalogo","Breve","Completa",2);
        catalogoController.especificarCatalogo("ola", "fsafsa", "fasfas", 10, c2, null);
        controller.especificarEquipa(325L, new Acronimo("TXT"), "ISTO E UM TESTE");
        controller.especificarEquipa(323L, new Acronimo("TXT"), "324");

        System.out.println(controllerList.listarEquipa());*/

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
