package SSLWorkflow;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.fluxoAtividade.service.FluxoAtividadeService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.services.TarefasPendentesService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class Utils {

    public static byte[] convertStrings(String text) {
        return text.getBytes(StandardCharsets.UTF_8);
    }

    public static void writeToServer(DataOutputStream sOut, String text) throws IOException {
        byte[] data = Utils.convertStrings(text.trim());
        sOut.write(data, 0, data.length);
    }

    public static String convertByteArrayToString(byte[] data) {
        return new String(data, StandardCharsets.UTF_8);
    }


    public static byte[] readBytes(DataInputStream sIn) throws IOException {

        int length = sIn.readInt();
        byte[] message = new byte[250];

        if (length > 0) {
            message = new byte[length];
            sIn.readFully(message, 0, message.length); // read the message
        }

        return message;
    }

    public static List<String> divideProtocol(byte[] allPacket, int protocolo) {
        String string = new String(allPacket, StandardCharsets.UTF_8);
        List<String> stringApart = new ArrayList<>();

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (i % protocolo == 0 && s.length() != 0) {
                stringApart.add(String.valueOf(s));
                s = new StringBuilder();
            }

            s.append(string.charAt(i));
        }
        stringApart.add(String.valueOf(s));


        return stringApart;
    }

    public static String putAllTogether(List<String> pack) {
        StringBuilder s = new StringBuilder();

        for (String elem : pack) {
            s.append(elem);
        }

        return s.toString();

    }

    public static void threadInfo() {
        int threadCount = 0;
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for (Thread t : threadSet) {
            if (t.getThreadGroup() == Thread.currentThread().getThreadGroup()) {
                System.out.println("Thread :" + t + ":" + "state:" + t.getState());
                ++threadCount;
            }
        }
        System.out.println("Thread count started by Main thread:" + threadCount);
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

    public static void tarefasPendentesServer(Socket s, DataOutputStream sOut, DataInputStream sIn, TarefasPendentesService service) throws IOException {

        // Read from client
        String colab = sIn.readUTF();
        Colaborador colabServer = colabWithString(colab);

        // Asks DB for the data
        String t = service.dashboardData(colabServer);
        String[] splittedData = t.split(",");

        String returnFromServer = String.format("%s,%s,%s", toInt(splittedData[0]), toInt(splittedData[1]), toInt(splittedData[2]));

        System.out.printf("Sending to Client : %s Thread Active: %s\n", returnFromServer, Thread.getAllStackTraces().size());
        //System.out.println("-------------------");
        //Utils.threadInfo();
        //System.out.println("-------------------");

        // Send To Client
        sOut.writeUTF(returnFromServer);
        s.close();

        s = null;
        Thread.currentThread().interrupt();

        return;
    }

    public static void fluxosAtivosServer(Socket s, DataOutputStream sOut, FluxoAtividadeService service) throws IOException {
        StringBuilder returnResponse = new StringBuilder();

        // Asks DB for the data
        String response = service.dashboardData();

        //String returnFromServer = String.format("%s,%s,%s", toInt(splittedData[0]), toInt(splittedData[1]), toInt(splittedData[2]));
        System.out.printf("Thread Active: %s\n", Thread.getAllStackTraces().size());

        returnResponse.append(response);

        // Send To Client
        //sOut.writeUTF(returnResponse.toString());

        //WORKING
        //sOut.write(response.getBytes(StandardCharsets.UTF_8));

        var x= divideProtocol(response.getBytes(StandardCharsets.UTF_8), 5);

        for(String elems : x){
            System.out.println(elems);
            sOut.write(elems.getBytes(StandardCharsets.UTF_8));
        }

        s.close();

        s = null;
        Thread.currentThread().interrupt();

        return;

    }

}
