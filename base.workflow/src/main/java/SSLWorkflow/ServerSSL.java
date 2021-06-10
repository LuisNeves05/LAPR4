package SSLWorkflow;

import java.io.*;

import java.net.Socket;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class ServerSSL {

    static final String BASEFOLDER = "base.workflow/src/main/java/SSLWorkflow/SSLCert/";
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
                System.out.println("Thread1: " + Thread.activeCount());
                new Thread(new ServerSSLThread(cliSock)).start();
                System.out.println("Thread2: " + Thread.activeCount());

			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
}



