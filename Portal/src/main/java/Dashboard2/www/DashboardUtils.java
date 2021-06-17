package Dashboard2.www;

import Dashboard2.DashboardThread;
import SSLWorkflow.ClientSSL;
import eapli.base.Utils.HelpMethods;
import eapli.base.fluxoAtividade.dto.FluxoAtividadeDTO;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DashboardUtils {

    public static String nameInDashboard(String colabName) {
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

    public static String navBar() {
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


    public static String fourBoxes(int tarefasAEx, int tarefasPend, int tarefasExp) {
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
                "                                <span class=\"desc\">Esta semana</span>\n" +
                "                                <div class=\"icon\">\n" +
                "                                    <i class=\"zmdi zmdi-calendar-note\"></i>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-md-6 col-lg-3\">\n" +
                "                            <div class=\"statistic__item statistic__item--red\">\n" +
                "                                <h2 class=\"number\">" + tarefasExp + "</h2>\n" +
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

    public static String bootstrapTest() {
        StringBuilder s = new StringBuilder();

        s.append("<div class=\"containerS\">\n" +
                "\t\t\t<div class=\"row justify-content-center\">\n" +
                "\t\t\t\t<div class=\"col-md-6 text-center mb-5\">\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"row\">\n" +
                "\t\t\t\t<div class=\"col-md-12\">\n" +
                "\t\t\t\t\t<div class=\"table\">\n" +
                "\t\t\t\t\t\t<table class=\"table table-striped\">\n" +
                "\t\t\t\t\t\t  <thead>\n" +
                "\t\t\t\t\t\t    <tr>\n" +
                "\t\t\t\t\t\t      <th>ID</th>\n" +
                "\t\t\t\t\t\t      <th>Aprovado Por</th>\n" +
                "\t\t\t\t\t\t      <th>Tipo Tarefa</th>\n" +
                "\t\t\t\t\t\t      <th>Status</th>\n" +
                "\t\t\t\t\t\t    </tr>\n" +
                "\t\t\t\t\t\t  </thead>\n" +
                "\t\t\t\t\t\t  <tbody>\n" +
                "\t\t\t\t\t\t    <tr>\n" +
                "\t\t\t\t\t\t      <th scope=\"row\">1001</th>\n" +
                "\t\t\t\t\t\t      <td>$3000</td>\n" +
                "\t\t\t\t\t\t      <td>$1200</td>\n" +
                "\t\t\t\t\t\t      <td><a href=\"#\" class=\"btn btn-success\">Progress</a></td>\n" +
                "\t\t\t\t\t\t    </tr>\n" +
                "\t\t\t\t\t\t    <tr>\n" +
                "\t\t\t\t\t\t      <th scope=\"row\">1001</th>\n" +
                "\t\t\t\t\t\t      <td>$3000</td>\n" +
                "\t\t\t\t\t\t      <td>$1200</td>\n" +
                "\t\t\t\t\t\t      <td><a href=\"#\" class=\"btn btn-success\">Progress</a></td>\n" +
                "\t\t\t\t\t\t    </tr>\n" +
                "\t\t\t\t\t\t  </tbody>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t</section>" +
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

    public static int toInt(String data) {
        return Integer.parseInt(data.trim());
    }

    public static boolean available(int port) {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }

    public static String getTarefasFromServer(String colab) {
        ClientSSL client = new ClientSSL();
        String packBeforeSplit = null;
        try {
            packBeforeSplit = client.getTarPenFromServer(colab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splittedData = packBeforeSplit.split(",");

        return DashboardUtils.fourBoxes(toInt(splittedData[0]), toInt(splittedData[1]), toInt(splittedData[2]));

    }

    public static String getFluxosFromServer() {
        ClientSSL client = new ClientSSL();
        String packBeforeSplit = null;
        try {
            packBeforeSplit = client.getFluxActFromServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<FluxoAtividadeDTO> fluxosDTOList = new ArrayList<>();

        String[] numberFluxos = packBeforeSplit.split(";");

        for (int i = 0; i < numberFluxos.length; i++) {
            var x = numberFluxos[i].split("!");

            String id = x[0];
            String status = x[1];
            String aprovadoPor = x[2].replace("[", "").replace("]", "");
            String tipoTarefa = x[3];

            fluxosDTOList.add(new FluxoAtividadeDTO(id, status, aprovadoPor, tipoTarefa));
        }

        try {
            return DashboardUtils.tableColours(fluxosDTOList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static String tableColours(List<FluxoAtividadeDTO> fluxoList) throws IOException {




        List<FluxoAtividadeDTO> fluxosDTOList = fluxoList;

        StringBuilder s = new StringBuilder();

        s.append("<div class=\"containerS\">\n" +
                "\t\t\t<div class=\"row justify-content-center\">\n" +
                "\t\t\t\t<div class=\"col-md-6 text-center mb-5\">\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"row\">\n" +
                "\t\t\t\t<div class=\"col-md-12\">\n" +
                "\t\t\t\t\t<div class=\"table\">\n" +
                "\t\t\t\t\t\t<table class=\"table table-striped\">\n" +
                "\t\t\t\t\t\t  <thead>\n" +
                "\t\t\t\t\t\t    <tr>\n" +
                "\t\t\t\t\t\t      <th>ID</th>\n" +
                "\t\t\t\t\t\t      <th>Aprovado Por</th>\n" +
                "\t\t\t\t\t\t      <th>Tipo Tarefa</th>\n" +
                "\t\t\t\t\t\t      <th>Status</th>\n" +
                "\t\t\t\t\t\t    </tr>\n" +
                "\t\t\t\t\t\t  </thead>\n" +
                "\t\t\t\t\t\t  <tbody>\n");

        for(FluxoAtividadeDTO elems : fluxosDTOList){

            //Beging Of Table
            s.append( "</tr>\n");

            s.append("<th scope=\"row\">" + elems.id + "</th>\n" +
                    "<td>" + elems.estaApr + "</td>\n" +
                    "<td>" + elems.estaRes + "</td>\n");

            if(elems.estado.equals("INATIVO")){
                s.append("<td><a href=\"#\" class=\"btn btn-warning\">INATIVO</a></td>\n");
            }

            if(elems.estado.equals("ATIVO")){
                s.append("<td><a href=\"#\" class=\"btn btn-success\">ATIVO</a></td>\n");
            }

            //End Of Table
            s.append( "</tr>\n");

        }

        return s.toString();

    }


    public static void openDashboard(int userRole) {

        if(HelpMethods.readFromProperties("systemUse").contains("server")){

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


}
