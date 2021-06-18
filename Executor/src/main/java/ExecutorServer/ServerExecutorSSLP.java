package ExecutorServer;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.Socket;

public class ServerExecutorSSLP {

    static final String BASEFOLDER = "Executor/src/main/java/ExecutorServer/SSLCert/";
    static final int SERVER_PORT = 6665;
    static final String TRUSTED_STORE = BASEFOLDER + "server_J.jks";
    static final String KEYSTORE_PASS = "forgotten";


    public void startServer() throws IOException {
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

        // Se for Preciso Sockets senao Chamar controller dentro do ciclo While, com um
        // Determinado Timer

        while (true) {
            cliSock = sock.accept();
            new Thread(new ServerExecutorSSLThread(cliSock, "P")).start();
        }
    }
}



