package MainServer;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

import static FrontEndDynamic.FrontEnd.dataNeedsToRefresh;
import static ScriptRefresh.Refresh.refreshScript;

public class DataOutput {
    public static void sendData(HttpExchange exchange) throws IOException, InterruptedException {

        StringBuilder stringBuilder = new StringBuilder();

        /**
         * Função responsável por dinamicamente dar output à informação
         */
        stringBuilder.append(dataNeedsToRefresh(5));

        /**
         * Função responsável por script de JQUERY responsável por dar refresh
         */
        stringBuilder.append(refreshScript());
        exchange.sendResponseHeaders(200, stringBuilder.toString().length());

        OutputStream os = exchange.getResponseBody();
        os.write(stringBuilder.toString().getBytes());
        os.close();
    }

}
