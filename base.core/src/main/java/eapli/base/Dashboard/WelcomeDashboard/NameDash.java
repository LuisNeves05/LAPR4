package eapli.base.Dashboard.WelcomeDashboard;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class NameDash {
    public static String nameInDashboard(String colabName){
        StringBuilder s = new StringBuilder();

        s.append("<!-- WELCOME-->\n" +
                "            <section class=\"welcome p-t-10\">\n" +
                "                <div class=\"containerS\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "                            <h1 class=\"title-4\">Bem vindo de volta \n" +
                "                                <span>" + colabName + "!</span>\n" +
                "                            </h1>\n" +
                "                            <hr class=\"line-seprate\">\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </section>\n" +
                "            <!-- END WELCOME-->");

        return s.toString();
    }
}
