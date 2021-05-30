package eapli.base.app.common.console.presentation.authz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Thread para lidar com os diversos pedidos de tarefas pendentes por parte do cliente
 */
public class MotorFluxoTarefasPendentesThread extends Thread{

    private Socket myS;
    private DataInputStream sIn;
    private DataOutputStream cOut;
    private String idColaborador;

    private String listaTarefasPendentes = "Ticket id!Cenas id!cenas;Ticketid 2!outras cenas!;";
    //TODO CONTROLLER DE TAREFAS PENDENTES

    public MotorFluxoTarefasPendentesThread(Socket s) {
        myS=s;
    }

    public void run() {

        try {
            sIn = new DataInputStream(myS.getInputStream());
            cOut = new DataOutputStream(myS.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("ERRO NOS INPUTS OUTPUTS");
            e.printStackTrace();
        }

        byte[] data;
        try {


            System.out.println("Chegou um novo pedido ao motor fluxo de tarefas pendentes servidor!!");

            while(true) {

                Thread.sleep(10000);

                System.out.println("A ESPERA DO ID DO COLABORADOR");
                idColaborador = sIn.readUTF();
                System.out.println("OLA DEPOIS DO COLAB");

                //TODO CHAMAR CONTROLLER PARA MANDAR AS CENAS
                System.out.println("Chegou o id " +idColaborador);
                data = listaTarefasPendentes.getBytes(StandardCharsets.UTF_8);

                //envia o tamanho do que tem para enviar
                //TODO dividir por 255 por causa da cena do tamanho max
                cOut.write(data.length);
                cOut.flush();

                cOut.write(data,0,data.length);
                cOut.flush();

            }
        }
        catch(Exception ex) {
            System.out.println("ERRO NAS TAREFAS PENDENTES THREAD");
            ex.printStackTrace(); }
    }
}