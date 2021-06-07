package Dashboard2;

public class DashboardThread implements Runnable {


    @Override
    public void run() {
        //java.util.logging.Logger.getLogger("o.h.orm.connections.pooling").setLevel(Level.SEVERE);

        HttpServerAjaxVoting s = new HttpServerAjaxVoting();
        try {
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
