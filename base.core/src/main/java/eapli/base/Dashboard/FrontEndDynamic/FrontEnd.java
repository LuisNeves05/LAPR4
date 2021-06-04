package eapli.base.Dashboard.FrontEndDynamic;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static eapli.base.Dashboard.Bootstrap.BootstrapCDN.bootstrapCDN;
import static eapli.base.Dashboard.Html.HtmlBodyOpen.htmlBodyOpener;
import static eapli.base.Dashboard.Html.HtmlOpen.htmlStarter;
import static eapli.base.Dashboard.NavBar.Navbar.navBar;
import static eapli.base.Dashboard.TaskByUrgency.TaskUrgency.taskByUrgencyList;
import static eapli.base.Dashboard.TaskCards.TaskCard.fourBoxes;
import static eapli.base.Dashboard.WelcomeDashboard.NameDash.nameInDashboard;

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

        //TODO Get current username from eapli framework
        stringBuilder.append(nameInDashboard("Tiago"));

        //TODO call controllers
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
