package eapli.base.app.common.console.presentation.authz.Server;


import eapli.base.app.common.console.presentation.authz.Protocolo.Utils;

import java.io.DataInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class ThreadCliente extends Thread {
    private Socket myS;
    private DataInputStream sIn;
    private static final Logger LOGGER = Logger.getLogger(ThreadCliente.class.getName() );

    public ThreadCliente(Socket s) {
        myS = s;
    }

    public void run() {
        int nChars;
        byte[] data = new byte[300];
        byte[] dataSER = new byte[300];
        try {
            sIn = new DataInputStream(myS.getInputStream());
            while (true) {
                nChars = sIn.read();
                if (nChars == 0) break; // empty line means client wants to exit
                sIn.read(data, 0, nChars);


                String text = (new String(data, "UTF-8")).split(" ")[1];

                int protocolo = Integer.parseInt(text.trim());

                switch (protocolo) {
                    case 4:
                        String tarefasPendentes = "[123!PENDENTE!POR_APROVAR!tes][123!PENDENTE!POR_APROVAR!tes]" +
                                "[123!PENDENTE!POR_APROVAR!tes][123!PENDENTE!POR_APROVAR!tes]";


                        Utils.divideProtocol(tarefasPendentes, 20);
                        System.out.printf("Server enviou tarefas pendentes: %s  %s\n", tarefasPendentes, tarefasPendentes.length());
                        break;

                    case 5:
                        //TODO CHAMAR CONTROLADOR

                        String fluxoAtivos = "[123!ATIVO][534!INATIVO][3!FODEU][53!TESTE][765!INATIVO][65!ATIVO][5!ATIVO]";
                        Utils.divideProtocol(fluxoAtivos, 20);

                        System.out.printf("Server enviou fluxos Ativos: %s  %s\n", fluxoAtivos, fluxoAtivos.length());

                        break;
                    default:
                        String defaultMessage = "404 NOT FOUND";
                        System.out.println(defaultMessage);

                        Utils.divideProtocol(defaultMessage, 30);
                        break;
                }

                //Server.TcpChatSrv.sendToAll(nChars,data);
                //Server.TcpChatSrv.
            }
            // the client wants to exit
            ServidorMain.remCli(myS);
        } catch (Exception ex) {
            try {
                ServidorMain.removeC(myS);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LOGGER.log( Level.WARNING, "Server registerd an unsual Exit!");
        }
    }
}