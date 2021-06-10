package Dashboard2;

import Dashboard2.www.DashboardUtils;
import SSLWorkflow.ClientSSL;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import static Dashboard2.www.DashboardUtils.*;


/**
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpsServer {
    static private final String BASE_FOLDER = "Portal/src/main/java/Dashboard2/www";
    static private ServerSocket sock;
    static private String PORT;
    static ColaboradorRepositorio repoColab = PersistenceContext.repositories().colaboradorRepositorio();
    static AuthorizationService authz = AuthzRegistry.authorizationService();
    static Colaborador colab = ((List<Colaborador>) repoColab.colabPorUsername(authz.session().get().authenticatedUser().username())).get(0);


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
            HttpsAjax req = new HttpsAjax(cliSock, BASE_FOLDER);
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
        textHtml.append(DashboardUtils.getTarefasFromServer(colab.nomeToString()));

        doTime(4);
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
