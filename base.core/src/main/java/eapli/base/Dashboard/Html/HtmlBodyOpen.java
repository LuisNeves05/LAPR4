package eapli.base.Dashboard.Html;

public class HtmlBodyOpen {

    public static String htmlBodyOpener() throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();

        /**
         * Body da página start
         */
        stringBuilder.append("<body>\n");

        return stringBuilder.toString();
    }
}
