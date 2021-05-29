import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class ServicoRHCliente {

    static InetAddress serverIP;
    static Socket sock;


    public static void main(String args[]) throws Exception {
        String nick, frase;
        byte[] data = new byte[250];

        if (args.length != 1) {
            System.out.println(
                    "Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: " + args[0]);
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 4678);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

        System.out.println("Connected to server");

        // start a thread to read incoming messages from the server
        //Thread serverConn = new Thread(new TcpChatCliConn(sock));

        while (true) { // read messages from the console and send them to the server
            System.out.println("Ola, este é o servidor principal!\n\n");
            System.out.println("Introduz 4 e espera pelo melhor: \n");

            frase=in.readLine();

            if(frase.compareTo("4")==0)
            {
                //envia sinal 4, que pede tarefa
                sOut.write(4); break;
            }



            //frase="(" + nick + ") " + frase;
            //data = frase.getBytes();
            //sOutCli.write((byte)frase.length());
            //sOut.write(data,0,(byte)frase.length());
        }

        sock.close();
    }
}

