package Dashboard2;

public class DashboardThread implements Runnable {


    @Override
    public void run() {
        //java.util.logging.Logger.getLogger("o.h.orm.connections.pooling").setLevel(Level.SEVERE);

        HttpsServer s = new HttpsServer();
        try {
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
