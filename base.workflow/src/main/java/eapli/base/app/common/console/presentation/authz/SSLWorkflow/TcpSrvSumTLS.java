package eapli.base.app.common.console.presentation.authz.SSLWorkflow;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManual.services.TarefasPendentesService;

import java.io.*;
import java.net.*;

import java.net.Socket;

import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class TcpSrvSumTLS {

    static final String BASEFOLDER = "base.workflow/src/main/java/eapli/base/app/common/console/presentation/authz/SSLWorkflow/SSLCert/";
    static final int SERVER_PORT = 6565;
    static final String TRUSTED_STORE = BASEFOLDER + "server_J.jks";
    static final String KEYSTORE_PASS = "forgotten";


    public void startServer(){
        SSLServerSocket sock = null;
        Socket cliSock = null;


        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(SERVER_PORT);
            sock.setNeedClientAuth(true);
            System.out.println("Liguei me");
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + SERVER_PORT);
            System.exit(1);
        }


        while (true) {
			try {
				cliSock = sock.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			new Thread(new TcpSrvSumTLSThread(cliSock)).start();
        }
    }
}


class TcpSrvSumTLSThread implements Runnable {
    private Socket s;
    private DataOutputStream sOut;
    private DataInputStream sIn;

    public TcpSrvSumTLSThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {
        InetAddress clientIP;

        clientIP = s.getInetAddress();
        System.out.println("New client connection from " + clientIP.getHostAddress() +
                ", port number " + s.getPort());
        try {
            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());
            //System.out.printf("%s	%s\n", sOut,  sIn.readUTF());


            //TODO DIVISAO DE BITES
            String received = sIn.readUTF();
            int protocolo = Integer.parseInt(received.trim());
            System.out.println("Cheguei aqui");
            switch (protocolo) {
                case 4:
                    String colab = sIn.readUTF();
                    String frase = "Enviar Tarefas Pendentes para o " + colab;


                    Colaborador colabServer = colabWithString(colab);
                    TarefasPendentesService service = new TarefasPendentesService();
                    String t = service.dashboardData(colabServer);
                    String[] splittedData = t.split(",");

                    String returnFromServer = String.format("%s,%s,%s", toInt(splittedData[0]),toInt(splittedData[1]), toInt(splittedData[2]));
                    System.out.println(returnFromServer);
                    sOut.writeUTF(returnFromServer);
                    break;
                case 5:
                    System.out.println("Enviar Fluxos");
                    break;

            }


            System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
                    " disconnected");

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                s.close();
            } catch (SSLProtocolException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static Colaborador colabWithString (String user){
        ColaboradorRepositorio repoColab = PersistenceContext.repositories().colaboradorRepositorio();
        Iterable<Colaborador> tds = repoColab.findAll();

        for(Colaborador elem : tds){
            if(elem.nomeToString().contains(user)){
                return elem;
            }
        }

        return null;
    }
}



