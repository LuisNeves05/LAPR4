package ExecutorServer.Utils;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefaAutomatica.service.TarefaAutomaticaService;
import eapli.base.tarefaManualExecucao.services.TarefasPendentesService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

public class Utils {

    //public static void tarefasAutomaticasServer(Socket s, DataOutputStream sOut, DataInputStream sIn, String state) throws IOException {
    public static void tarefasAutomaticasServer(String state) throws IOException {

        // Asks DB for the data
        TarefaAutomaticaService tarefaAutServ = new TarefaAutomaticaService();
        tarefaAutServ.buscarTarefasAutomaticas(state);

        // TODO executar validacao

        // String t = service.dashboardData(colabServer);
        // String[] splittedData = t.split(",");

        //String returnFromServer = String.format("%s,%s,%s", toInt(splittedData[0]), toInt(splittedData[1]), toInt(splittedData[2]));

        //System.out.printf("Sending to Client : %s Thread Active: %s\n", returnFromServer, Thread.getAllStackTraces().size());
        //System.out.println("-------------------");
        //Utils.threadInfo();
        //System.out.println("-------------------");

        // Send To Client
        //sOut.writeUTF("Tarefa Automatica executada com sucesso");
        //s.close();

        //s = null;
        //Thread.currentThread().interrupt();

    }
}
