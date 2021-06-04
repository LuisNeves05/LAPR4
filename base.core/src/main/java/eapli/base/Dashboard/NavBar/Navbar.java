package eapli.base.Dashboard.NavBar;

public class Navbar {
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
}
