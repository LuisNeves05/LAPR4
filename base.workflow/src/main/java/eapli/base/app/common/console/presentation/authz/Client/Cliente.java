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

public class Cliente {
    static InetAddress serverIP;
    static Socket sock;
    private static String name = "CLIENTE";
    private final String ip = "192.168.1.3";


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
        TcpChatCliConn newCon = new TcpChatCliConn(sock);
        Thread serverConn = new Thread(newCon);
        serverConn.start();


        frase = String.valueOf(protocoloNum);
        frase="(" + nick + ") " + frase;
        data = frase.getBytes();
        sOut.write(data,0,frase.getBytes(StandardCharsets.UTF_8).length);
        sOut.write(0);

        serverConn.join();
        System.out.println("RETURNED : " + newCon.getDataBuilder());
        sock.close();
    }
}

