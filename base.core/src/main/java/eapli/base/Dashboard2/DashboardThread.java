package eapli.base.Dashboard2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;

public class DashboardThread implements Runnable {


    @Override
    public void run() {
        //java.util.logging.Logger.getLogger("o.h.orm.connections.pooling").setLevel(Level.SEVERE);

        System.out.println("Threads: " + Thread.currentThread());
        HttpServerAjaxVoting s = new HttpServerAjaxVoting();
        try {
            System.out.println("starting");
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
