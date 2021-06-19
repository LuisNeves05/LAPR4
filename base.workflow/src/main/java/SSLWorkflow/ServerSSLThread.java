package SSLWorkflow;

import ExecutorServer.ClientExecutorSSL;
import eapli.base.fluxoAtividade.service.FluxoAtividadeService;
import eapli.base.tarefaManualExecucao.services.AssignarTarefaAlgoritmoService;
import eapli.base.tarefaManualExecucao.services.TarefasPendentesService;
import javassist.bytecode.stackmap.TypeData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static SSLWorkflow.Utils.*;

class ServerSSLThread implements Runnable {
    private Socket s;
    private DataOutputStream sOut;
    private DataInputStream sIn;
    static TarefasPendentesService serviceTarefas = new TarefasPendentesService();
    static FluxoAtividadeService serviceFluxo = new FluxoAtividadeService();
    static AssignarTarefaAlgoritmoService serviceAlg = new AssignarTarefaAlgoritmoService();
    private static final Logger LOGGER = Logger.getLogger( TypeData.ClassName.class.getName() );

    public ServerSSLThread(Socket cli_s) {
        s = cli_s;
    }

    public void run() {
        InetAddress clientIP;

        clientIP = s.getInetAddress();
        //System.out.println("New request incomming from " + clientIP.getHostAddress());


        try {
            ClientExecutorSSL executorSSL = new ClientExecutorSSL();
            executorSSL.executarTarefaAutomatica();
        } catch (IOException | NoSuchElementException e ) {
            //e.printStackTrace();
        }

        try {
            sOut = new DataOutputStream(s.getOutputStream());
            sIn = new DataInputStream(s.getInputStream());


            String received = sIn.readUTF();
            int protocolo = Integer.parseInt(received.trim());

            switch (protocolo) {
                case 4:
                    LOGGER.log(Level.INFO, "Protocol {0} Requested", protocolo);
                    tarefasPendentesServer(s, sOut, sIn, serviceTarefas);
                    break;

                case 5:
                    LOGGER.log(Level.INFO, "Protocol {0} Requested", protocolo);
                    fluxosAtivosServer(s, sOut, serviceFluxo);
                    break;

                case 6:
                    LOGGER.log(Level.INFO, "Protocol {0} Requested", protocolo);
                    atribuicaoAutomaticaAlg(s, sOut, serviceAlg);
                    break;

                default:
                    LOGGER.log(Level.WARNING, "Protocol Nao Defenido", protocolo);
                    System.out.println("Protocol Nao Defenido");
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