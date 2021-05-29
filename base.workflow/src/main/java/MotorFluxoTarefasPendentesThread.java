import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Thread para lidar com os diversos pedidos de tarefas pendentes por parte do cliente
 */
public class MotorFluxoTarefasPendentesThread extends Thread{

    private Socket myS;
    private DataInputStream sIn;
    private ServerSocket server = null;

    public MotorFluxoTarefasPendentesThread(Socket s) {
        myS=s;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[255];
        try {

            sIn = new DataInputStream(myS.getInputStream());
            while(true) {

                myS = server.accept();
                System.out.println("Chegou um novo pedido ao motor fluxo servidor!!");
                //TODO CRIAR MAIS UMA CLASSE THREAD PARA LIDAR COM OS MAMBOS

                nChars=sIn.read();
                if(sIn.read() == 5){

                }
                if(nChars==0) break; // empty line means client wants to exit
                sIn.read(data,0,nChars);
                //TcpChatSrv.sendToAll(nChars,data);
            }
            // the client wants to exit
            //TcpChatSrv.remCli(myS);
        }
        catch(Exception ex) { System.out.println("Error"); }
    }

}
