package eapli.base.Dashboard.ScriptRefresh;

public class Refresh {
    public static String refreshScript(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("" +
                "<script src=\"http://code.jquery.com/jquery-latest.js\">" +
                "</script>");
        stringBuilder.append("" +
                "<script>" +
                "\n" +
                "    $(document).ready(function(){\n" +
                "\t\t $(\"#div_refresh\").load(\"\");\n" +
                "        setInterval(function() {\n" +
                "            $(\"#div_refresh\").load(\"\");\n" +
                "        }, 1000000);\n" +
                "    });\n" +
                " ");
        stringBuilder.append("</script>");

        return stringBuilder.toString();
    }
}
