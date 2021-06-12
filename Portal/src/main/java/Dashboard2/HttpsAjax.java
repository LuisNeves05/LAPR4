package Dashboard2;

import java.io.*;
import java.net.Socket;

/**
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpsAjax extends Thread {
    String baseFolder;
    Socket sock;
    DataInputStream inS;
    DataOutputStream outS;

    public HttpsAjax(Socket s, String f) {
        baseFolder = f;
        sock = s;
    }

    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Thread error on data streams creation");
            Thread.currentThread().interrupt();
        }
        try {
            HttpsMessage request = new HttpsMessage(inS);
            HttpsMessage response = new HttpsMessage();

            if (request.getURI().equals("/votes")) {
                response.setContentFromString(
                        HttpsServer.getVotesStandingInHTML(), "text/html");
                response.setResponseStatus("200 Ok");
            } else {
                String fullname = baseFolder + "/";
                if (request.getURI().equals("/")) fullname = fullname + "index.html";
                else fullname = fullname + request.getURI();
                if (response.setContentFromFile(fullname)) {
                    response.setResponseStatus("200 Ok");
                } else {
                    response.setContentFromString(
                            "<html><body><h1>404 File not found</h1></body></html>",
                            "text/html");
                    response.setResponseStatus("404 Not Found");
                }
            }
            response.send(outS);
        } catch (IOException ex) {
            //ex.printStackTrace();
            System.out.println("Thread error when reading request");
            Thread.currentThread().interrupt();
        }
        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
            Thread.currentThread().interrupt();
        }
        Thread.currentThread().interrupt();
    }
}

