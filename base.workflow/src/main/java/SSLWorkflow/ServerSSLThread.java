package SSLWorkflow;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.services.TarefasPendentesService;

import javax.net.ssl.SSLProtocolException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

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
                    String colab = sIn.readUTF();


                    Colaborador colabServer = colabWithString(colab);

                    String t = service.dashboardData(colabServer);
                    String[] splittedData = t.split(",");

                    String returnFromServer = String.format("%s,%s,%s", toInt(splittedData[0]), toInt(splittedData[1]), toInt(splittedData[2]));

                    System.out.printf("Sending to Client : %s Thread Active: %s\n", returnFromServer, Thread.activeCount());
                    sOut.writeUTF(returnFromServer);
                    break;

                case 5:
                    System.out.println("Enviar Fluxos");
                    break;

                default:
                    System.out.println("Protocolo Nao Definido!");
                    break;

            }
            //s.close();
            //Thread.currentThread().interrupt();

        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            try {
                s.close();
            } catch (IOException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public static Colaborador colabWithString(String user) {
        ColaboradorRepositorio repoColab = PersistenceContext.repositories().colaboradorRepositorio();
        Iterable<Colaborador> tds = repoColab.findAll();

        for (Colaborador elem : tds) {
            if (elem.nomeToString().contains(user)) {
                return elem;
            }
        }

        return null;
    }
}