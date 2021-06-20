package ExecutorServer;

import com.google.common.collect.Lists;
import eapli.base.Utils.ObterCurrentColabController;
import eapli.base.Utils.SortValues;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

import static ExecutorServer.Utils.ReadFile.getAvailableIps;


public class ClientExecutorSSL {
    static final String BASEFOLDER = "Executor/src/main/java/ExecutorServer/SSLCert/";
    static final int SERVER_PORT = 6665;
    static final String KEYSTORE_PASS = "forgotten";
    List<String> listaIpsAvailable = getAvailableIps();

    static InetAddress serverIP;
    static SSLSocket sock;

    public void executarTarefaAutomatica() throws IOException {
        TarefaAutomaticaRepositorio repoT = PersistenceContext.repositories().tarefaAutomaticaRepositorio();
        TicketRepositorio repoTick = PersistenceContext.repositories().ticketRepositorio();


        StringBuilder sendToServer = new StringBuilder();

        for (String ips : listaIpsAvailable) {
            Set<TarefaAutomatica> tarefasIteration = new LinkedHashSet<>();
            preparingSSLClient(ips);


            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
            DataInputStream sIn = new DataInputStream(sock.getInputStream());


            String protocol = "7";
            sOut.writeUTF(protocol);


            List<TarefaAutomatica> tar = Lists.newArrayList(repoT.tarefasAutomaticasPendentes());

            for (TarefaAutomatica elems : tar) {
                for (FormularioPreenchido form : elems.ticketDaTarefa().formulariosPreenchidosDoTicket()) {
                    Map<Resposta, Integer> respotasDoForm = SortValues.sortByMaxPeriodTime(form.respostasDoFormulario());
                    String scriptTar = elems.scriptExecucao();
                    String email = elems.ticketDaTarefa().colabQueRequisita().systemUserDoColab().email().toString();


                    // TODO DIVISAO DE BYTES
                    String stringFormat = respotasDoForm.keySet().toString().trim() + "!" +
                            scriptTar.trim() + "!" +
                            email.trim() + "!" +
                            elems.identity() + "/";
                    sendToServer.append(stringFormat);
                    tarefasIteration.add(elems);

                }
            }

            //System.out.println("DEBUG: " + sendToServer.toString());
            sOut.writeUTF(sendToServer.toString());


            String result = sIn.readUTF();

            if(!result.equals("0")){
                List<String> myList = new ArrayList<>(Arrays.asList(result.split("&")));
                //System.out.println("DEBUG1 : " + myList);

                for (TarefaAutomatica elems : tarefasIteration) {
                    int conter = 0;
                    //System.out.println("DEBUG2 : " + myList.get(conter));
                    if (myList.get(conter).contains("tru")) {
                        elems.ticketDaTarefa().completarTicket();
                        elems.ticketDaTarefa().definirFinalTicket();
                        repoTick.save(elems.ticketDaTarefa());
                    }
                }


                if(result.contains("True")){
                    System.out.println("Tarefa Automatica Concluida com Sucesso");
                }
                //System.out.println(result);
                //System.out.println("RESPONSE: " + result);
            }

        }

    }


    public String verificarCarga() throws IOException {

        for (String elems : listaIpsAvailable) {
            preparingSSLClient(elems);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
            DataInputStream sIn = new DataInputStream(sock.getInputStream());


            String protocol = "8";
            sOut.writeUTF(protocol);

            //WAITING FOR RESPONSE
            String response = sIn.readUTF();

            if (response.contains("0")) {
                //TODO send tarefa Automatica
                System.out.println("tes");
                break;
            }

            if (response.contains("1")) {
                System.out.println("NEXT");
            }

        }

        return "response";
    }

    private static void preparingSSLClient(String executorIp) {
        //String serverIp = "10.8.0.83";
        String serverIp = executorIp;
        String clientSSL = "client1_J";


        // Trust these certificates provided by servers
        System.setProperty("javax.net.ssl.trustStore", BASEFOLDER + clientSSL + ".jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", BASEFOLDER + clientSSL + ".jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName(serverIp);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + serverIp);
            System.exit(1);
        }


        try {
            sock = (SSLSocket) sf.createSocket(serverIP, SERVER_PORT);
        } catch (IOException ex) {
            System.out.println("Failed to connect to: " + serverIp + ":" + SERVER_PORT);
            System.out.println("Application aborted.");
            System.exit(1);
        }


        try {
            sock.startHandshake();
        } catch (SSLException e) {
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            Thread.currentThread().interrupt();
        }
    }


}



