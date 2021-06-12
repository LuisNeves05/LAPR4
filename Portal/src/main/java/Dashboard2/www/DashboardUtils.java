package Dashboard2.www;

import Dashboard2.DashboardThread;
import SSLWorkflow.ClientSSL;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
                "                                <h2 class=\"number\">" + tarefasPend + "</h2>\n" +
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

    public static String bootstrapTest(){
        StringBuilder s = new StringBuilder();

        s.append("<div class=\"containerS\">\n" +
                "<table class=\"table\">\n" +
                "  <thead class=\"thead-dark\">\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">ID</th>\n" +
                "      <th scope=\"col\">Status</th>\n" +
                "      <th scope=\"col\">Last</th>\n" +
                "      <th scope=\"col\">Handle</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">1</th>\n" +
                "      <td>Mark</td>\n" +
                "      <td>Otto</td>\n" +
                "      <td>@mdo</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">2</th>\n" +
                "      <td>Jacob</td>\n" +
                "      <td>Thornton</td>\n" +
                "      <td>@fat</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <th scope=\"row\">3</th>\n" +
                "      <td>Larry</td>\n" +
                "      <td>the Bird</td>\n" +
                "      <td>@twitter</td>\n" +
                "    </tr>\n" +
                "  </tbody>\n" +
                "</table>"+
                "</div>\n");

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
        return Integer.parseInt(data.trim());
    }

    public static boolean available(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }

    public static String getTarefasFromServer(String colab){
        ClientSSL client = new ClientSSL();
        String packBeforeSplit = null;
        try {
            packBeforeSplit = client.getTarPenFromServer(colab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splittedData = packBeforeSplit.split(",");

        return DashboardUtils.fourBoxes(toInt(splittedData[0]),toInt(splittedData[1]),toInt(splittedData[2]));

    }

    public static String getFluxosFromServer(){
        ClientSSL client = new ClientSSL();
        String packBeforeSplit = null;
        try {
            packBeforeSplit = client.getFluxActFromServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //String[] splittedData = packBeforeSplit.split(",");

        return packBeforeSplit;

    }


    public static void openDashboard(int userRole){

        Thread t1 = new Thread(new DashboardThread(userRole));
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            java.awt.Desktop.getDesktop().browse(URI.create("http://localhost:9992/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
