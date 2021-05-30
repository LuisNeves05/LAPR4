package MainServer;

import MultisystemConsole.RunScript;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import static MainServer.DataOutput.sendData;

public class Server {

    public static void serverStart(int port) throws IOException {
        int PORT = port;
        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpContext hc = httpServer.createContext("/");
        httpServer.setExecutor(Executors.newCachedThreadPool());

        //TODO substitui o print por abrir no cmd/linux
        //String s = System.getProperty("os.name");
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
