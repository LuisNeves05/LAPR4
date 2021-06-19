package ExecutorServer.Utils;

import eapli.base.formulario.gramatica.ScriptTarefasAutomaticas;
import eapli.base.formularioPreenchido.domain.Resposta;
import org.apache.commons.lang3.StringUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static void tarefasAutomaticasServer(Socket s, DataOutputStream sOut, DataInputStream sIn, String state) throws IOException {
        String stateC = null;
        //WAITING FOR RESPONSE

        String response = sIn.readUTF();
        boolean result = false;

        List<String> responseToClient = new ArrayList<>();


        for(String elems : getNumberOfTarefasAut(response)){
            String[] split = elems.split("!");
            stateC = split[3].trim();

            System.out.println("Debug 1: " + stateC);

            if((intToState(Integer.parseInt(stateC)).equals(state))){
                /**
                 * Variaveis para a componente de LPROG
                 */
                String scriptTar = split[1];
                List<Resposta> respotasDoForm = stringListToStringRespostas(stringsToList(split[0]));
                String email = split[2];

                System.out.println("SCRIPT : " + scriptTar);
                System.out.println("RESPOSTAS : " + respotasDoForm);
                System.out.println("EMAIL : " + email);
                System.out.println("State : " + stateC);

                // TODO executar validacao
                result = ScriptTarefasAutomaticas.executaTarefaAutomatica(scriptTar, respotasDoForm, email);

                responseToClient.add(String.valueOf(result));
            }

        }

        System.out.println("Debug 2: " + stateC);
        if((intToState(Integer.parseInt(stateC)).equals(state))){
            String sendToCli = StringUtils.join(responseToClient, "&");
            System.out.println(sendToCli);
            sOut.writeUTF(sendToCli);
        }

        s = null;
        Thread.currentThread().interrupt();

    }


    public static List<String> stringsToList(String data){

        List<String> toStringList = new LinkedList<>();

        String[] res = data.replace("[", "").replace("]", "").split(",");
        List<String> resList = Arrays.asList(res);

        return resList;
    }


    public static List<Resposta> stringListToStringRespostas(List<String> data){

        List<Resposta> returnList = new ArrayList<>();

        for(String elems : data){
            returnList.add(new Resposta(elems.trim(), "pergunta"));
        }

        return returnList;
    }

    public static List<String> getNumberOfTarefasAut(String response){
        List<String> tarefasList = Arrays.asList(response.split("/"));
        for(String elems : tarefasList){
            System.out.println(elems);
        }
        return tarefasList;
    }


    public static String intToState(int num){
        if(num % 2 == 0){
            return "P";
        }
        else{
            return "I";
        }
    }
}
