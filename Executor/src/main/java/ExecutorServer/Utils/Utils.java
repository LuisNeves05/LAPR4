package ExecutorServer.Utils;

import eapli.base.formulario.gramatica.ScriptTarefasAutomaticas;
import eapli.base.formularioPreenchido.domain.Resposta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static void tarefasAutomaticasServer(Socket s, DataOutputStream sOut, DataInputStream sIn, String state) throws IOException {

        //WAITING FOR RESPONSE
        byte[] responseInBytes = sIn.readAllBytes();

        String response = new String((responseInBytes), StandardCharsets.UTF_8);
        System.out.println("Executor : " + response);

        String[] split = response.split("!");

        /**
         * Variaveis para a componente de LPROG
         */
        String scriptTar = split[1];
        List<Resposta> respotasDoForm = stringListToStringRespostas(stringsToList(split[0]));
        String email = split[2];

        // TODO executar validacao
        boolean result = ScriptTarefasAutomaticas.executaTarefaAutomatica(scriptTar, respotasDoForm, email);


        sOut.writeUTF(Boolean.toString(result));
        s = null;
        Thread.currentThread().interrupt();

    }


    public static List<String> stringsToList(String data){

        List<String> toStringList = new LinkedList<>();

        String[] res = data.split(",");
        List<String> resList = Arrays.asList(res);

        return resList;
    }


    public static List<Resposta> stringListToStringRespostas(List<String> data){

        List<Resposta> returnList = new ArrayList<>();

        for(String elems : data){
            returnList.add(new Resposta(elems, "pergunta"));
        }

        return returnList;
    }
}
