package eapli.base.Utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpMethods {

    public static String arrayToString(List<String> array){
        StringBuilder sb = new StringBuilder();

        for(String elem : array){
            sb.append(elem);
            sb.append("!");
        }

        return String.valueOf(sb);
    }

    public static boolean validaResposta(final String resposta, final String regex) {

        //todo fazer expressao para todos os tipos de dados

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(resposta);

        return matcher.find();
    }

}
