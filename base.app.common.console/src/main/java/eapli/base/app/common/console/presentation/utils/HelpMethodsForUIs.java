package eapli.base.app.common.console.presentation.utils;

import SSLWorkflow.ClientSSL;
import eapli.base.tarefaManualExecucao.services.AssignarTarefaAlgoritmoService;

import java.io.IOException;

import static eapli.base.Utils.HelpMethods.readFromProperties;

public class HelpMethodsForUIs {

    public static void sendToServer(){
        /**
         * Algoritmo de atribuicao automatica
         */

        final AssignarTarefaAlgoritmoService assignarTarefaAlgoritmo = new AssignarTarefaAlgoritmoService();
        String par = readFromProperties("systemUse");

        if (par.contains("local")) {
            assignarTarefaAlgoritmo.assignarTarefasAoColabAutomaticamente();
        }
        if (par.contains("server")) {
            ClientSSL askServer = new ClientSSL();
            try {
                askServer.gestaoDeCargaAquandoAtribuidoTarefasAlg();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
