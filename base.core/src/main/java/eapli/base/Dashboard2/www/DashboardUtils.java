package eapli.base.Dashboard2.www;

import java.util.Random;

public class DashboardUtils {

    public static String nameInDashboard(String colabName){
        StringBuilder s = new StringBuilder();

        s.append("<section class=\"welcome p-t-10\">\n" +
                "                <div class=\"containerS\">\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-md-12\">\n" +
                "                            <h1 class=\"title-4\">Bem vindo de volta \n" +
                "                                <span>" + colabName + "</span>\n" +
                "                            </h1>\n" +
                "                            <hr class=\"line-seprate\">\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </section>");

        return s.toString();
    }

    public static String navBar(){
        StringBuilder s = new StringBuilder();

        s.append("<nav class=\"navbar navbar-dark bg-dark\">\n" +
                "  <a class=\"navbar-brand\" href=\"#\">\n" +
                //"    <img src=\"/docs/4.0/assets/brand/bootstrap-solid.svg\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n" +
                "Dashboard\n" +
                "  </a>\n" +
                "</nav>"
        );

        return s.toString();
    }


    public static String fourBoxes(int tarefasAEx, int tarefasPend, int tarefasExp)  {
        StringBuilder s = new StringBuilder();


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
                "                                <h2 class=\"number\">0</h2>\n" +
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

    public static int randInt(int min, int max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        //
        // In particular, do NOT do 'Random rand = new Random()' here or you
        // will get not very good / not very random results.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static void doTime(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int toInt(String data){
        return Integer.parseInt(data);
    }
}
