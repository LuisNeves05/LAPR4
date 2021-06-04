package eapli.base.Dashboard.MainServer;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import eapli.base.Dashboard.MultisystemConsole.RunScript;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import static eapli.base.Dashboard.MainServer.DataOutput.sendData;


public class Server extends Thread{


    @Override
    public void run() {
        try {
            serverStart(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverStart(int port) throws IOException {
        int PORT = port;
        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpContext hc = httpServer.createContext("/");
        httpServer.setExecutor(Executors.newCachedThreadPool());

        System.out.println("Opening connecting in:");
        System.out.println("http://localhost:" + PORT);



        hc.setHandler(new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                try {
                    sendData(exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        RunScript.runScript();
        httpServer.start();
    }
}
