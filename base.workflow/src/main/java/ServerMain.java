import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Main class, vai conter duas threads, uma para o motor de fluxos ser servidor do Portal e ServiçosRH e outra para ser cliente do executor de tarefas
 */
public class ServerMain {

    static InetAddress serverIP;
    static Socket sockCli, sockServ;
    static ServerSocket socket;

    public static void main(String args[]) throws Exception {

        if(args.length!=1) {
            System.out.println(
                    "Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1); }

        try { serverIP = InetAddress.getByName(args[0]); }
        catch(UnknownHostException ex) {
            System.out.println("Invalid server: " + args[0]);
            System.exit(1); }

        try { socket = new ServerSocket(3698); }
        catch(IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1); }

        socket.setSoTimeout(100);

        /*
          Threads criadas no inicio para permitir que motor de fluxos seja servidor e cliente
         */
        MotorFluxoClienteThread motorClienteThread = new MotorFluxoClienteThread(sockCli);
        motorClienteThread.start();
        sockServ = socket.accept();
        MotorFluxoServidorThread motorFluxoServidorThread = new MotorFluxoServidorThread(sockServ);
        motorFluxoServidorThread.start();


        while(true) { // read messages from the console and send them to the server
            Thread.sleep(7000);
        }

    }
}