package eapli.base.app.common.console.presentation.authz.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class TcpChatCli {
    static InetAddress serverIP;
    static Socket sock;
    private static String name = "CLIENTE";
    private final String ip = "192.168.1.8";


    public void startClient(int protocoloNum) throws Exception {


        String nick, frase;
        byte[] data;

        try { serverIP = InetAddress.getByName(ip); }
        catch(UnknownHostException ex) {
            System.out.println("Invalid server: " + ip);
            System.exit(1); }

        try { sock = new Socket(serverIP, 4444); }
        catch(IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1); }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        System.out.println("Connected to server");
        nick = name;

        // start a thread to read incoming messages from the server
        Thread serverConn = new Thread(new TcpChatCliConn(sock));
        serverConn.start();


        frase = String.valueOf(protocoloNum);
        frase="(" + nick + ") " + frase;
        data = frase.getBytes();
        sOut.write(data,0,frase.getBytes(StandardCharsets.UTF_8).length);
        sOut.write(0);

        //System.out.println("cona");

        serverConn.join();
        sock.close();
    }
}

