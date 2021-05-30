import java.io.*;
import java.net.*;


class ServicoRHCliente {
    private static InetAddress serverIP;
    private static Socket sock;

    /*private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final UserSession userSession = authorizationService.session().get();
    private final SystemUser systemUser = userSession.authenticatedUser();
    private final Colaborador colabAtual =colabPorUserName(systemUser.username());*/

    public static void main(String args[]) throws Exception {
        String nick, frase;
        byte[] data = new byte[300];

        if(args.length!=1) {
            System.out.println(
                    "Server IPv4/IPv6 address or DNS name is required as argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        }
        catch(UnknownHostException ex) {
            System.out.println("Invalid server: " + args[0]);
            System.exit(1);
        }

        //teoricamente, estarme ei a ligar à porta associada à socket da thread servidor
        try { sock = new Socket(serverIP, 3698); }
        catch(IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1); }


        DataInputStream sIn = new DataInputStream(sock.getInputStream());
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        System.out.println("Connected to server");

        //ESTA A PEDIR TAREFAS PENDENTES


        while(true) { // read messages from the console and send them to the server

            sOut.writeInt(4);
            sOut.flush();
            System.out.println("ENVIOU O SINAL PARA O SERVIDOR A DIZER QUE QUER TAREFAS");

            sOut.writeUTF("Ola mano");
            sOut.flush();

            int tamanho = sIn.read();
            System.out.println("\nRECEBEU O TAMANHO DA STRING " + tamanho);

            sIn.read(data,0,tamanho);

            String teste = new String(data,0,tamanho);

            System.out.println("Recebi isto  " + teste);

        }

    }

   /* public Colaborador colabPorUserName(Username username){
        return colaboradorRepositorio.colabPorUsername(username).iterator().next();
    }*/
}
