package eapli.base.Dashboard2;

import eapli.base.Dashboard2.www.DashboardUtils;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            req.start();
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
        //TODO CONTROLLERS
        textHtml.append(DashboardUtils.fourBoxes(randInt(0,10),randInt(0,10),randInt(0,10)));



        /*for (int i = 0; i < candidatesNumber; i++) {
            textHtml.append("<li>" +
                    "<button type=button voteFor(" + (i + 1) + ")>Vote for " + candidateName[i] + "</button> " +
                    " - " +
                    candidateVotes[i] + " votes </li>");
        }

         */

        /////////////////////////////////////////////////////////////////////////////////
        /*
        textHtml.append("<h3>Tarefas a Expirar " + Math.random() + "</h3>");
        textHtml.append("<h3>Tarefas a Pendentes " + Math.random() + "</h3>");
        textHtml.append("<h3>Tarefas a Expiradas " + Math.random() + "</h3>");
        //textHtml.append("<h3>Tarefas a expirar "    + candidateVotes[0] + "</h3>");


         */
        ////////////////////////////////////////////////////////////////////////////////


        textHtml.append("<h3>HTTP server accesses counter test: " + accessesCounter + "</h3>");

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
