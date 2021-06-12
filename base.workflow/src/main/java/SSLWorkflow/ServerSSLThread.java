package SSLWorkflow;

import eapli.base.tarefaManualExecucao.services.TarefasPendentesService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import static SSLWorkflow.Utils.tarefasPendentesServer;

class ServerSSLThread implements Runnable {
    private Socket s;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    static TarefasPendentesService service = new TarefasPendentesService();

    public ServerSSLThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {
        InetAddress clientIP;

        clientIP = s.getInetAddress();
        System.out.println("New request incomming from " + clientIP.getHostAddress());

        try {
            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());


            //TODO DIVISAO DE BITES
            String received = sIn.readUTF();
            int protocolo = Integer.parseInt(received.trim());

            switch (protocolo) {
                case 4:
                    tarefasPendentesServer(s, sOut, sIn, service);
                    break;

                case 5:
                    System.out.println("Enviar Fluxos");
                    Thread.currentThread().interrupt();
                    break;

                default:
                    System.out.println("Protocolo Nao Definido!");
                    break;

            }

            Thread.currentThread().interrupt();
            return;

        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            try {
                s.close();
                s = null;
            } catch (IOException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }


}