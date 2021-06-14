package Dashboard2;

public class DashboardThread implements Runnable {
    private int role;

    public DashboardThread(int role) {
        this.role = role;
    }

    @Override
    public void run() {
        HttpsServer s = new HttpsServer(role);
        try {
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
