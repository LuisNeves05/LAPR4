package Protocolo;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String arrayToString(List<String> array) {
        StringBuilder sb = new StringBuilder();

        for (String elem : array) {
            sb.append(elem);
            sb.append("!");
        }

        return String.valueOf(sb);
    }


    public static String getRandomNumber(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return String.valueOf(x);
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

}
