package eapli.base.app.common.console.presentation.authz;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.io.*;
import java.net.*;


class ServicoRHCliente extends Thread {
    private static InetAddress serverIP;
    private static Socket sock;

    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabAtual = colabPorUserName(systemUser.username());
    private final String idColab = colabAtual.identity().toString();

    private DataInputStream sIn;
    private DataOutputStream sOut;

    public void run() {
        byte[] data = new byte[300];
        String ip = "10.8.0.81";

        try {
            serverIP = InetAddress.getByName(ip);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: " + ip);
            System.exit(1);
        }

        //teoricamente, estarme ei a ligar à porta associada à socket da thread servidor
        try {
            sock = new Socket(serverIP, 3895);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }


        try {
            sIn = new DataInputStream(sock.getInputStream());
            sOut = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Connected to server");

        //ESTA A PEDIR TAREFAS PENDENTES
        try {

            while (true) { // read messages from the console and send them to the server

                Thread.sleep(10000);


                sOut.writeInt(4);

                System.out.println("ENVIOU O SINAL PARA O SERVIDOR A DIZER QUE QUER TAREFAS");

                sOut.writeUTF(idColab);

                int tamanho = sIn.read();

                sIn.read(data, 0, tamanho);

                while (data[255] != 0) {

                    sIn.read(data, 0, tamanho);

                    Thread.sleep(5000);

                    String teste = new String(data, 0, tamanho);

                    System.out.println("Recebi isto dentro do while  " + teste);
                }

                String teste = new String(data, 0, tamanho);

                System.out.println("Recebi isto  " + teste);

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public Colaborador colabPorUserName(Username username) {
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }

    public void buildBigString() {

    }
}
