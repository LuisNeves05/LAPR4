package SSLWorkflow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static byte[] convertStrings(String text){
        return text.getBytes(StandardCharsets.UTF_8);
    }

    public static void writeToServer(DataOutputStream sOut, String text) throws IOException {
        byte[] data = Utils.convertStrings(text.trim());
        sOut.write(data, 0, data.length);
    }

    public static String convertByteArrayToString(byte[] data){
        return new String(data, StandardCharsets.UTF_8);
    }


    public static byte[] readBytes(DataInputStream sIn) throws IOException {

        int length = sIn.readInt();
        byte[] message = new byte[250];

        if(length > 0) {
            message = new byte[length];
            sIn.readFully(message, 0, message.length); // read the message
        }

        return message;
    }

    public static List<String> divideProtocol(byte[] allPacket, int protocolo){
        String string = new String(allPacket, StandardCharsets.UTF_8);
        List<String> stringApart = new ArrayList<>();

        StringBuilder s = new StringBuilder();

        for(int i = 0; i < string.length(); i++){
            if(i % protocolo == 0 && s.length() != 0){
                stringApart.add(String.valueOf(s));
                s = new StringBuilder();
            }

            s.append(string.charAt(i));
        }
        stringApart.add(String.valueOf(s));



        return stringApart;
    }

    public static String putAllTogether(List<String> pack){
        StringBuilder s = new StringBuilder();

        for(String elem : pack){
            s.append(elem);
        }

        return s.toString();

    }

}
