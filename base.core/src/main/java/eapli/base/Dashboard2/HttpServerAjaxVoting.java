package eapli.base.Dashboard2;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



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
        StringBuilder textHtml = new StringBuilder();
        textHtml.append("<hr><ul>");



        /*for (int i = 0; i < candidatesNumber; i++) {
            textHtml.append("<li>" +
                    "<button type=button voteFor(" + (i + 1) + ")>Vote for " + candidateName[i] + "</button> " +
                    " - " +
                    candidateVotes[i] + " votes </li>");
        }

         */
        /////////////////////////////////////////////////////////////////////////////////

        textHtml.append("<h3>Tarefas a Expirar " + Math.random() + "</h3>");
        textHtml.append("<h3>Tarefas a Pendentes " + Math.random() + "</h3>");
        textHtml.append("<h3>Tarefas a Expiradas " + Math.random() + "</h3>");
        //textHtml.append("<h3>Tarefas a expirar "    + candidateVotes[0] + "</h3>");


        AuthorizationService authorizationService = AuthzRegistry.authorizationService();
        UserSession userSession = authorizationService.session().get();
        SystemUser systemUser = userSession.authenticatedUser();

        System.out.println(systemUser.username());


        ////////////////////////////////////////////////////////////////////////////////


        textHtml.append("</ul><hr><p>HTTP server accesses counter test: " + accessesCounter + "</p><hr>");


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

    private static void doTime(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
