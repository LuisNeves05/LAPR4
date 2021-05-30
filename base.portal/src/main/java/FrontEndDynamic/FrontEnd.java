package FrontEndDynamic;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static Bootstrap.BootstrapCDN.bootstrapCDN;
import static Html.HtmlBodyOpen.htmlBodyOpener;
import static Html.HtmlOpen.htmlStarter;
import static NavBar.Navbar.navBar;
import static TaskByUrgency.TaskUrgency.taskByUrgencyList;
import static TaskCards.TaskCard.fourBoxes;
import static WelcomeDashboard.NameDash.nameInDashboard;

public class FrontEnd {
    public static String dataNeedsToRefresh(int seconds) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(htmlStarter());
        stringBuilder.append(htmlBodyOpener());


        /**
         * Div que precisa de dar refresh
         */
        stringBuilder.append("<div id = 'div_refresh'> ");
        stringBuilder.append(navBar());

        stringBuilder.append(nameInDashboard("Tiago"));
        stringBuilder.append(fourBoxes(randNum(), randNum(), randNum()));
        stringBuilder.append(taskByUrgencyList());


        stringBuilder.append("<div class='containerS'><h1>");
        stringBuilder.append(LocalTime.now());
        stringBuilder.append("</h1>");
        stringBuilder.append("</div></div>");



        stringBuilder.append("</body>\n");
        stringBuilder.append(bootstrapCDN());
        stringBuilder.append("</html>\n");


        TimeUnit.SECONDS.sleep(seconds);
        return stringBuilder.toString();
    }

    public static int randNum(){
        int randomNum = ThreadLocalRandom.current().nextInt(0, 20 + 1);
        return randomNum;
    }
}
