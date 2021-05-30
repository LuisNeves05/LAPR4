import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class MotorFluxoClienteThread extends Thread {
    private Socket s;

    public MotorFluxoClienteThread(Socket tcp_s) { s=tcp_s;}

    public void run() {

        try {

            while(true) {
                Thread.sleep(10000);
            }
        }
        catch(InterruptedException ex) { System.out.println("Client disconnected."); }
    }
}