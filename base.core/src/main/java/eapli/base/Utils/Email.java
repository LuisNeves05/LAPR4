package eapli.base.Utils;

import java.io.FileWriter;
import java.io.IOException;

public class Email {

    public static void sendEmail(String to, String text) {
        try {
            FileWriter myWriter = new FileWriter("base.core/src/main/java/eapli/base/formulario/gramatica/emailsTXT/"+to+".txt");
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
