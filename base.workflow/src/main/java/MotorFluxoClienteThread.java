import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class MotorFluxoClienteThread extends Thread {
    private Socket s;
    private DataInputStream sIn;

    public MotorFluxoClienteThread(Socket tcp_s) { s=tcp_s;}

    public void run() {
        int nChars;
        byte[] data = new byte[255];
        String frase;
        //TODO CENAS DE EXECUÇAO AUTO
        try {
            sIn = new DataInputStream(s.getInputStream());
            while(true) {
                nChars=sIn.read();
                if(nChars==0) break;
                sIn.read(data,0,nChars);
                frase = new String(data, 0, nChars);
                System.out.println(frase);
            }
        }
        catch(IOException ex) { System.out.println("Client disconnected."); }
    }
}