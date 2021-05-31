package eapli.base.app.common.console.presentation.authz.Server;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class TcpChatSrv {
    private static HashMap<Socket, DataOutputStream> cliList = new HashMap<>();
    private static ServerSocket sock;
    private static String myIp = "192.168.1.8";

    /*
    static {
        try {
            myIp = InetAddress.getLocalHost()
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

     */


    public void startServer() throws Exception {
        InetAddress serverIp = InetAddress.getByName(myIp);
        try {
            sock = new ServerSocket(4444, 0, serverIp);
        } catch (IOException ex) {
            System.out.println("Local port number not available.");
            System.out.println(ex);
            System.exit(1);
        }
        while (true) {
            Socket s = sock.accept(); // wait for a new client connection request
            addCli(s);
            System.out.printf("NOVO CLIENTE in port %s\n", s.getPort());
            Thread cli = new TcpChatSrvClient(s);
            cli.start();
        }
    }

    public static synchronized void sendToAll(int len, byte[] data) throws Exception {
        for (DataOutputStream cOut : cliList.values()) {
            cOut.write(len);
            cOut.write(data, 0, len);
        }
    }

    public static synchronized void addCli(Socket s) throws Exception {
        cliList.put(s, new DataOutputStream(s.getOutputStream()));
    }

    public static synchronized void remCli(Socket s) throws Exception {
        cliList.get(s).write(0);
        cliList.remove(s);
        s.close();
    }

    public static synchronized void removeC(Socket s) throws Exception {
        //cliList.get(s).write(0);
        cliList.remove(s);
        s.close();
    }
}


