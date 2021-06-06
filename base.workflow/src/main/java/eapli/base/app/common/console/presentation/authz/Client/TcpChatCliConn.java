package eapli.base.app.common.console.presentation.authz.Client;

import java.io.*;
import java.net.*;


class TcpChatCliConn implements Runnable {
    private Socket s;
    private DataInputStream sIn;
    private StringBuilder dataBuilder = new StringBuilder();

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

                    dataBuilder.append(frase);

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

    public String getDataBuilder() {
        return String.valueOf(dataBuilder).substring(0, dataBuilder.length()-1);
    }
}