package eapli.base.app.common.console.presentation.authz.Client;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


class TcpChatCliConn implements Runnable {
    private Socket s;
    private DataInputStream sIn;

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[250];
        String frase;

        try {
            while (true) {
                sIn = new DataInputStream(s.getInputStream());
                nChars = sIn.read();

                sIn.read(data, 0, nChars);
                frase = new String(data, 0, nChars);

                if(frase.length() > 0){
                    String t = String.valueOf(frase.charAt(frase.length()-1));

                    System.out.printf("Received : %s \n", frase);
                    if (t.equals(String.valueOf(0))) {
                        break;
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        }

    }
}