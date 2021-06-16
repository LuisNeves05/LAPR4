package eapli.base.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
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

    public static boolean validaResposta(String resposta, String expReg) {
        Pattern pattern = Pattern.compile(expReg);
        Matcher matcher = pattern.matcher(resposta);

        return matcher.find();
    }

    public static String readFromProperties(String atributo){
        InputStream input = null;
        try {
            input = new FileInputStream("base.core/src/main/resources/ecafeteria.sample.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties prop = new Properties();
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(atributo);
    }

}
