package eapli.base.app.common.console.presentation.authz.Server;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class ServidorMain {
    private static HashMap<Socket, DataOutputStream> cliList = new HashMap<>();
    private static ServerSocket sock;
    private static String myIp = "10.8.0.82";

    /*
    static {
        try {
            myIp = InetAddress.getLocalHost()
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

     */


    public void startServer() {
        InetAddress serverIp = null;
        try {
            serverIp = InetAddress.getByName(myIp);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            sock = new ServerSocket(4444, 0, serverIp);
        } catch (IOException ex) {
            System.out.println("Local port number not available.");
            System.out.println(ex);
            System.exit(1);
        }
        while (true) {
            Socket s = null; // wait for a new client connection request
            try {
                s = sock.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                addCli(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.printf("NOVO CLIENTE in port %s\n", s.getPort());
            Thread cli = new ThreadCliente(s);
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


