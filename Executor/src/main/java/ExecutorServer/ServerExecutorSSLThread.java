package ExecutorServer;

import eapli.base.fluxoAtividade.service.FluxoAtividadeService;
import eapli.base.tarefaAutomatica.service.TarefaAutomaticaService;
import eapli.base.tarefaManualExecucao.services.AssignarTarefaAlgoritmoService;
import eapli.base.tarefaManualExecucao.services.TarefasPendentesService;
import javassist.bytecode.stackmap.TypeData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ExecutorServer.Utils.Utils.tarefasAutomaticasServer;

class ServerExecutorSSLThread implements Runnable {
    private String state;
    private Socket s;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    private static final Logger LOGGER = Logger.getLogger( TypeData.ClassName.class.getName() );

    public ServerExecutorSSLThread(Socket cli_s, String state) {
        s = cli_s;
        this.state = state;
    }

    public void run() {
        InetAddress clientIP;

        clientIP = s.getInetAddress();

        try {
            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());


            String received = sIn.readUTF();
            int protocolo = Integer.parseInt(received.trim());

            switch (protocolo) {
                case 7:
                    LOGGER.log(Level.INFO, "Protocol {0} Requested", protocolo);
                    tarefasAutomaticasServer(this.state);
                    break;


                default:
                    LOGGER.log(Level.WARNING, "Protocol Nao Defenido", protocolo);
                    System.out.println("Protocol Nao Defenido");
                    break;

            }

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