package eapli.base.app.common.console.presentation.authz.SSLWorkflow;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

/**
 * @author asc@isep.ipp.pt
 */

public class TcpCliSumTLS {

    static final String BASEFOLDER = "base.workflow/src/main/java/eapli/base/app/common/console/presentation/authz/SSLWorkflow/SSLCert/";
    static final int SERVER_PORT = 6565;
    static final String KEYSTORE_PASS = "forgotten";

    static InetAddress serverIP;
    static SSLSocket sock;


    public void getTarPenFromServer(String colabName) {

        preparingSSLClient();


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = null;
        try {
            sOut = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //DataInputStream sIn = new DataInputStream(sock.getInputStream());


        String frase;
        frase = "4";
        try {
            sOut.writeUTF(frase);
            sOut.writeUTF(colabName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFluxActFromServer(){

        preparingSSLClient();


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = null;
        try {
            sOut = new DataOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //DataInputStream sIn = new DataInputStream(sock.getInputStream());


        String frase = "5";
        try {
            sOut.writeUTF(frase);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void preparingSSLClient() {
        String serverIp = "labs-ssh4";
        String clientSSL = "client1_J";


        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", BASEFOLDER + clientSSL + ".jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", BASEFOLDER + clientSSL + ".jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName(serverIp);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + serverIp);
            System.exit(1);
        }


        try {
            sock = (SSLSocket) sf.createSocket(serverIP, SERVER_PORT);
        } catch (IOException ex) {
            System.out.println("Failed to connect to: " + serverIp + ":" + SERVER_PORT);
            System.out.println("Application aborted.");
            System.exit(1);
        }

        System.out.println("Connected to: " + serverIp + ":" + SERVER_PORT);

        try {
            sock.startHandshake();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




