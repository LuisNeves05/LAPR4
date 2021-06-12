package SSLWorkflow;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

/**
 * @author asc@isep.ipp.pt
 */

public class ClientSSL {

    static final String BASEFOLDER = "base.workflow/src/main/java/SSLWorkflow/SSLCert/";
    static final int SERVER_PORT = 6565;
    static final String KEYSTORE_PASS = "forgotten";

    static InetAddress serverIP;
    static SSLSocket sock;


    public String getTarPenFromServer(String colabName) throws IOException {

        preparingSSLClient();


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        DataInputStream sIn = new DataInputStream(sock.getInputStream());


        String protocol =  "4";
        sOut.writeUTF(protocol);
        sOut.writeUTF(colabName);

        //WAITING FOR RESPONSE
        String response = sIn.readUTF();

        //TODO IF CONSTANT
        //System.out.println("Client Response from server: " + response);
        //sock.close();
        return response;
    }

    public String getFluxActFromServer() throws IOException {

        preparingSSLClient();


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream  sOut = new DataOutputStream(sock.getOutputStream());
        DataInputStream sIn = new DataInputStream(sock.getInputStream());


        String protocol = "5";
        sOut.writeUTF(protocol);

        //WAITING FOR RESPONSE
        String response = sIn.readUTF();

        return response;
    }

    private static void preparingSSLClient() {
        String serverIp = "10.8.0.83";
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
        //TODO IF CONSTANT
        //System.out.println("Connected to: " + serverIp + ":" + SERVER_PORT);

        try {
            sock.startHandshake();
        } catch (SSLException e){
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            //e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}



