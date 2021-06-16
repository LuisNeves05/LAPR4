package ExecutorServer;

import eapli.base.fluxoAtividade.service.FluxoAtividadeService;
import eapli.base.tarefaManualExecucao.services.TarefasPendentesService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

class ServerExecutorSSLThread implements Runnable {
    private Socket s;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    static TarefasPendentesService serviceTarefas = new TarefasPendentesService();
    static FluxoAtividadeService serviceFluxo = new FluxoAtividadeService();

    public ServerExecutorSSLThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {
        InetAddress clientIP;

        clientIP = s.getInetAddress();
        System.out.println("New request incomming from " + clientIP.getHostAddress());

        try {
            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());


            String received = sIn.readUTF();
            int protocolo = Integer.parseInt(received.trim());

            switch (protocolo) {
                case 1:
                    // TODO chamar controlador para executar tarefa automatica
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Protocolo Nao Definido!");
                    break;

            }

            return;

        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            try {
                s.close();
                s = null;
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }


}