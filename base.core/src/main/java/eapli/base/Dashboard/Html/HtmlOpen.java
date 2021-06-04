package eapli.base.Dashboard.Html;

public class HtmlOpen {

    public static String htmlStarter() throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Admin Dashboard</title>\n" +
                "</head>\n" +
                "\n");

        return stringBuilder.toString();
    }
}
