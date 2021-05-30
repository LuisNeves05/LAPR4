package eapli.base.app.common.console.presentation.authz;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Main class, vai conter duas threads, uma para o motor de fluxos ser servidor do Portal e ServiçosRH e outra para ser cliente do executor de tarefas
 */
public class ServerMain extends Thread{

    static InetAddress serverIP;
    static Socket sockCli, sockServ;
    static ServerSocket socket;

    public void run(){

        String ip = "127.0.0.1";

        try { serverIP = InetAddress.getByName(ip); }
        catch(UnknownHostException ex) {
            System.out.println("Invalid server: " + ip);
            System.exit(1); }

        try { socket = new ServerSocket(3698); }
        catch(IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1); }

        //socket.setSoTimeout(100);

        /*
          Threads criadas no inicio para permitir que motor de fluxos seja servidor e cliente
         */
        MotorFluxoClienteThread motorClienteThread = new MotorFluxoClienteThread(sockCli);
        motorClienteThread.start();
        try {
            sockServ = socket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MotorFluxoServidorThread motorFluxoServidorThread = new MotorFluxoServidorThread(sockServ);
        motorFluxoServidorThread.start();


        while(true) { // read messages from the console and send them to the server
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void teste(){
        System.out.println("teste");
    }
}