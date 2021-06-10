package Dashboard2;

public class DashboardThread implements Runnable {


    @Override
    public void run() {

        HttpsServer s = new HttpsServer();
        try {
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
