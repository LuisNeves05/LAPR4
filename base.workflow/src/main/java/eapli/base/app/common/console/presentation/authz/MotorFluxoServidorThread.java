package eapli.base.app.common.console.presentation.authz;

import eapli.base.app.common.console.presentation.authz.MotorFluxoTarefasPendentesThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.net.ServerSocket;


/**
 * Thread para lidar com os pedidos por parte da aplicação cliente
 */
class MotorFluxoServidorThread extends Thread {
    private Socket myS;
    private DataInputStream sIn;
    private ServerSocket serverSocket;

    public MotorFluxoServidorThread(Socket s) {
        myS = s;
    }
    boolean flag = true;

    public void run() {
        int nChars;
        System.out.println("ENtrou dentro do fluxo servidor!!!!!");
        //String MENSAGEM_ERRO = "POR FAVOR INTRODUZA UM CÓDIGO VÁLIDO!";
        try {

            sIn = new DataInputStream(myS.getInputStream());
            System.out.println("Chegou um novo pedido ao motor de fluxos servidor!");
            //Pedido do cliente

            nChars = sIn.readInt();

            while (true) {
                Thread.sleep(10000);

                if(nChars == Protocolo.PEDE_TAREFAS_PENDENTES && flag){
                    MotorFluxoTarefasPendentesThread motorFluxoTarefasPendentesThread = new MotorFluxoTarefasPendentesThread(myS);
                    motorFluxoTarefasPendentesThread.start();

                }else if(nChars == Protocolo.PEDE_ESTADO_FLUXO_ATIVIDADES && flag){

                    MotorFluxosAtivosThread motorFluxosAtivosThread = new MotorFluxosAtivosThread(myS);
                    motorFluxosAtivosThread.start();
                }
                flag = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("\nMotorFluxoServidorThread");
        }
    }

    private void motorFluxoAtivos() {

    }


    public static synchronized void enviar(int len, byte[] data, DataOutputStream cOut) throws Exception {
        int tamanho;

        if (len > 250) {
            for (int j = 0; j < len; j += 250) {
                byte[] auxData = preencherAuxData(data, j);
                tamanho = auxData.length;
                cOut.write(tamanho);
                cOut.write(auxData, 0, tamanho);
            }
        } else {
            tamanho = data.length;
            cOut.write(tamanho);
            cOut.write(data, 0, len);
        }

    }

    private static byte[] preencherAuxData(byte[] array, int j) {
        byte[] aux = new byte[250];
        System.arraycopy(array, j, aux, j, j + 250 - j);

        return aux;
    }


    public static String arrayToString(List<String> array){
        StringBuilder sb = new StringBuilder();

        for(String elem : array){
            sb.append(elem);
            sb.append("!");
        }

        return String.valueOf(sb);
    }

    private static HashMap<Socket,DataOutputStream> cliList = new HashMap<>();

    public static synchronized void sendToAll(int len, byte[] data) throws Exception {
        for(DataOutputStream cOut: cliList.values()) {
            cOut.write(len);
            cOut.write(data,0,len);
        }
    }
    //TODO metodos para ir a bd buscar o que +e preciso
}