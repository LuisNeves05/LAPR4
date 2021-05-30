package TaskCards;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskCard {
    public static String fourBoxes(int tarefasAEx, int tarefasPend, int tarefasExp)  {
        StringBuilder s = new StringBuilder();
        s.append(cssMethod());

        s.append("<!-- STATISTIC-->\n" +
                "                <div class=\"containerS\">\n" +
                "            <section class=\"statistic statistic2\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-6 col-lg-3\">\n" +
                "                            <div class=\"statistic__item statistic__item--green\">\n" +
                "                                <h2 class=\"number\">" + tarefasAEx + "</h2>\n" +
                "                                <span class=\"desc\">Tarefas a expirar</span>\n" +
                "                                <div class=\"icon\">\n" +
                "                                    <i class=\"zmdi zmdi-account-o\"></i>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-md-6 col-lg-3\">\n" +
                "                            <div class=\"statistic__item statistic__item--orange\">\n" +
                "                                <h2 class=\"number\">" + tarefasAEx + "</h2>\n" +
                "                                <span class=\"desc\">Tarefas pendentes</span>\n" +
                "                                <div class=\"icon\">\n" +
                "                                    <i class=\"zmdi zmdi-shopping-cart\"></i>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-md-6 col-lg-3\">\n" +
                "                            <div class=\"statistic__item statistic__item--blue\">\n" +
                "                                <h2 class=\"number\">1,086</h2>\n" +
                "                                <span class=\"desc\">this week</span>\n" +
                "                                <div class=\"icon\">\n" +
                "                                    <i class=\"zmdi zmdi-calendar-note\"></i>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-md-6 col-lg-3\">\n" +
                "                            <div class=\"statistic__item statistic__item--red\">\n" +
                "                                <h2 class=\"number\">" + tarefasExp+ "</h2>\n" +
                "                                <span class=\"desc\">Tarefas expiradas</span>\n" +
                "                                <div class=\"icon\">\n" +
                "                                    <i class=\"zmdi zmdi-money\"></i>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                    </div>\n" +
                "            </section>\n" +
                "            <!-- END STATISTIC-->");

        return s.toString();
    }

    public static String cssMethod(){
        StringBuilder s = new StringBuilder();

        String content = null;
        try {
            content = Files.readString(Path.of("base.portal/src/main/java/TaskCards/style.txt"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }

        s.append("<style>" + content + "</style>");

        return s.toString();
    }
}
