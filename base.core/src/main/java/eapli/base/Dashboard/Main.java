package eapli.base.Dashboard;


import eapli.base.Dashboard.MainServer.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Server dashboard = new Server();
        dashboard.serverStart(8080);
    }

}


