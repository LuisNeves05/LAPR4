package eapli.base.app.common.console.presentation.authz.Protocolo;
import eapli.base.app.common.console.presentation.authz.Server.ServidorMain;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> divideProtocol(String string, int protocolMax) throws Exception {
        int len = string.length();
        List<String> stringApart = new ArrayList<>();

        StringBuilder s = new StringBuilder();

        for(int i = 0; i < string.length(); i++){
            if(i % protocolMax == 0 && s.length() != 0){
                stringApart.add(String.valueOf(s));
                s = new StringBuilder();
            }

            s.append(string.charAt(i));
        }
        stringApart.add(String.valueOf(s));

        for(String elem : stringApart){
            ServidorMain.sendToAll(elem.length(),elem.getBytes(StandardCharsets.UTF_8));
        }

        ServidorMain.sendToAll(1,String.valueOf(0).getBytes(StandardCharsets.UTF_8));


        return stringApart;
    }

    public static String arrayToString(List<String> array){
        StringBuilder sb = new StringBuilder();

        for(String elem : array){
            sb.append(elem);
            sb.append("!");
        }

        return String.valueOf(sb);
    }


    public static String getRandomNumber(int min, int max){
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return String.valueOf(x);
    }
}
