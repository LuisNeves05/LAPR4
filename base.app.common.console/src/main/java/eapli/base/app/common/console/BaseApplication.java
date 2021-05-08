/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.app.common.console;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.catalogo.application.EspecificarCatalogoController;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.colaborador.domain.*;
import eapli.base.equipa.application.EspecificarEquipaController;
import eapli.base.equipa.application.ListarEquipaController;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;
import eapli.framework.infrastructure.eventpubsub.impl.inprocess.InProcessPubSub;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        EspecificarEquipaController controller = new EspecificarEquipaController();
        EspecificarCatalogoController catalogoController = new EspecificarCatalogoController();
        EspecificarColaboradorController colaboradorController = new EspecificarColaboradorController();
        ListarEquipaController controllerList = new ListarEquipaController();
        EspecificarServicoController especificarServicoController = new EspecificarServicoController();

        especificarServicoController.especificarServico("luis","Titulo","Breve","Completa",1,true,false,null,"INCOMPLETO",false,null);

        //QueryMaker q = new QueryMaker();
        //List<Servico> list = q.queryToDB();
        //Servico s =  list.get(0);


        //System.out.println(s.toString() + " #########################################################|||||||||||||||||||||||||||||||");

        Morada morada = new Morada("asaffa", "afsfas");
        Funcao funcao = new Funcao("funcao");

        Colaborador c2 = colaboradorController.especificarColaborador(new NomeCurto("tiago"), new NomeCompleto("tiago marante"),
                new MecanographicNumber("1200627"), new Morada("porto", "valongo"),
                new NrContacto(911196272), null, null);


        controller.especificarEquipa(325L, new Acronimo("TXT"), "ISTO E UM TESTE", c2);

        System.out.println(controller.listarAcronimos("TXT"));
        System.out.println(controllerList.listarEquipa());

        System.out.println("###################");

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
