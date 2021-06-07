package eapli.base.Dashboard2;

import eapli.base.Dashboard2.www.DashboardUtils;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManual.application.QueriesTarefaController;
import eapli.base.tarefaManual.services.TarefasPendentesService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import static eapli.base.Dashboard2.www.DashboardUtils.*;


/**
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpServerAjaxVoting {
    static private final String BASE_FOLDER = "base.core/src/main/java/eapli/base/Dashboard2/www";
    static private ServerSocket sock;
    static private String PORT;

    public void start() throws Exception {
        Socket cliSock;
        PORT = String.valueOf(9992);

        accessesCounter = 0;
        for (int i = 0; i < candidatesNumber; i++) {
            candidateName[i] = "Candidate " + i;
            candidateVotes[i] = 0;
        }

        try {
            sock = new ServerSocket(Integer.parseInt(PORT));
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }
        while (true) {
            cliSock = sock.accept();
            HttpAjaxVotingRequest req = new HttpAjaxVotingRequest(cliSock, BASE_FOLDER);
            req.run();
            //req.start();
            incAccessesCounter();
        }
    }


    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static final int candidatesNumber = 4;
    private static final String[] candidateName = new String[candidatesNumber];
    private static final int[] candidateVotes = new int[candidatesNumber];
    private static int accessesCounter;

    private static synchronized void incAccessesCounter() {
        accessesCounter++;
    }

    public static synchronized String getVotesStandingInHTML() {
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        UserSession userSession = authorizationService.session().get();
        SystemUser systemUser = userSession.authenticatedUser();


        StringBuilder textHtml = new StringBuilder();

        // NavBard
        textHtml.append(DashboardUtils.navBar());

        // Welcome Dashboard
        textHtml.append(nameInDashboard(String.valueOf(systemUser.username())));

        // Four Cards
        // TODO CONTROLLERS
        /////////////////////////////////////////////////////////////
        ColaboradorRepositorio repoColab = PersistenceContext.repositories().colaboradorRepositorio();
        QueriesTarefaController controller = new QueriesTarefaController();

        AuthorizationService authz = AuthzRegistry.authorizationService();
        Colaborador colab = ((List<Colaborador>) repoColab.colabPorUsername(authz.session().get().authenticatedUser().username())).get(0);

        TarefasPendentesService service = new TarefasPendentesService();
        String t = service.dashboardData(colab);
        String[] splittedData = t.split(",");
        /////////////////////////////////////////////////////////////
        textHtml.append(DashboardUtils.fourBoxes(toInt(splittedData[0]),toInt(splittedData[1]), toInt(splittedData[2])));



        //textHtml.append("<h3>HTTP server accesses counter test: " + accessesCounter + "</h3>");

        doTime(2);
        return String.valueOf(textHtml);
    }

    public static synchronized void castVote(String i) {
        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        UserSession userSession = authorizationService.session().get();
        SystemUser systemUser = userSession.authenticatedUser();

        System.out.println(systemUser.username());


        //TODO CHAMAR CONTROLADORES ???

        int cN;
        try {
            cN = Integer.parseInt(i);
        } catch (NumberFormatException ne) {
            return;
        }
        cN--;
        if (cN >= 0 && cN < candidatesNumber) {
            candidateVotes[cN] += 1;
        }
    }



}
