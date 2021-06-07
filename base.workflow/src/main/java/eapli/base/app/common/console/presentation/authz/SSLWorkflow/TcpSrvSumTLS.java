package eapli.base.app.common.console.presentation.authz.SSLWorkflow;

import java.io.*;
import java.net.*;

import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

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
                    System.out.println(frase);
                    sOut.writeUTF(frase);
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}



