package eapli.base.app.common.console.presentation.authz;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefaManual.application.QueriesTarefaController;

import java.awt.geom.QuadCurve2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Thread para lidar com os diversos pedidos de tarefas pendentes por parte do cliente
 */
public class MotorFluxoTarefasPendentesThread extends Thread{

    private Socket myS;
    private DataInputStream sIn;
    private DataOutputStream cOut;
    private final QueriesTarefaController queryTarefaController = new QueriesTarefaController();

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

        try {

            System.out.println("Chegou um novo pedido ao motor fluxo de tarefas pendentes servidor!!");

            while(true) {

                Thread.sleep(10000);

                //Lê num mecanografico do colaborador que esta a fazer o pedido
                String idColaborador = sIn.readUTF();

                Colaborador colab = queryTarefaController.colabPorID(idColaborador);

                String aux = queryTarefaController.tarefasManuaisAprovDTO(colab);
                List<String> stringList = divideProtocol(aux, 200);

                for(String a: stringList) {
                    byte[] data = a.getBytes(StandardCharsets.UTF_8);

                    if(stringList.size()>1){
                        data[255] = 1;
                    }else{
                        data[255] = 0;
                    }
                    cOut.write(data.length);
                    cOut.flush();
                    cOut.write(data,0,data.length);
                    cOut.flush();
                    stringList.remove(a);
                }
            }
        }
        catch(Exception ex) {
            System.out.println("ERRO NAS TAREFAS PENDENTES THREAD");
            ex.printStackTrace(); }
    }

    public static List<String> divideProtocol(String string, int protocolMax){
        List<String> stringApart = new ArrayList<>();

        StringBuilder s = new StringBuilder();

        for(int i = 0; i < string.length(); i++){
            if(i % protocolMax == 0 && s.length() != 0){
                stringApart.add(String.valueOf(s));
                s = new StringBuilder();
            }
            s.append(string.charAt(i));
        }

        stringApart.add(String.valueOf(s));
        return stringApart;
    }
}