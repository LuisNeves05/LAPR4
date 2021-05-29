import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Thread para lidar com os pedidos por parte da aplicação cliente
 */
class MotorFluxoServidorThread extends Thread {
    private Socket myS;
    private DataInputStream sIn;
    private DataOutputStream cOut;


    public MotorFluxoServidorThread(Socket s) {
        myS = s;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[255];
        try {

            sIn = new DataInputStream(myS.getInputStream());
            cOut = new DataOutputStream(myS.getOutputStream());
            while (true) {

                System.out.println("Chegou um novo pedido! ao motor servidor ");
                //TODO instanciar thread para lidar com os pedidos do lado do cliente

                //Teoricamente, este será o codigo que o cliente envia para sabermos o que ele quer
                nChars = sIn.read();

                String MENSAGEM_ERRO = "POR FAVOR INTRODUZA UM CÓDIGO VÁLIDO!";
                data = MENSAGEM_ERRO.getBytes(StandardCharsets.UTF_8);

                //Mediante o codigo, fazemos coisas diferentes
                switch (nChars) {
                    case 4:
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                        ObjectOutputStream oos = new ObjectOutputStream(buffer);

                        oos.close();

                        byte[] rawData = buffer.toByteArray();
                        System.out.println(rawData.length + " TAMANHO DO ARRAY DO OBJETO");


                        ByteBuffer buf = ByteBuffer.allocate(512);
                        buf.order(ByteOrder.LITTLE_ENDIAN);
                        buf.put((byte) 0);
                        buf.put((byte) 2);
                        buf.putShort((short) 2);
                        buf.putShort((short) rawData.length);
                        buf.put(rawData);

                        buf.put((byte) 0);

                        //diz ao cliente o tamanho do packet que está prestes a receber.
                        //acho que o tcp faz isto automaticamente mas devido ao protocolo temos de fazer assim

                        cOut.write(rawData.length);

                        //envia o que cliente pediu
                        enviar(rawData.length, rawData, cOut);

                        //pede tarefa

                        break;
                    case 5:
                        System.out.println("Enviar para o cliente");
                        List<String> newAr = Arrays.asList(new String[]{"tes", "tes1", "tes2","tes", "tes1", "tes2","tes", "tes1", "tes2","tes", "tes1", "tes5"});

                        var t = arrayToString(newAr);

                        System.out.printf("%s   %s\n",t, t.length());
                       // TcpChatSrv.sendToAll(t.length(),t.getBytes(StandardCharsets.UTF_8));

                        List<String> newAr2 = new ArrayList<>();
                        newAr2.add("boas");
                        newAr2.add("pessoal");

                        System.out.println(newAr2);

                        t = arrayToString(newAr2);
                        //TcpChatSrv.sendToAll(t.length(),t.getBytes(StandardCharsets.UTF_8));


                        break;
                    default:
                        //mensagem de erro caso o que cliente introduziu nao faça sentido
                        cOut.write(MENSAGEM_ERRO.getBytes(StandardCharsets.UTF_8));
                }

            }

        } catch (Exception ex) {

            System.out.println(ex);
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