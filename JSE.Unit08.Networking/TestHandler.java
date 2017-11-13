/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techmatter.lab8;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 *
 * @author PA
 */
public class TestHandler implements HttpHandler{

    @Override
    public void handle(HttpExchange he) throws IOException {
        String message = "<html><h2>This is the response</h2></html>";
        he.sendResponseHeaders(200, message.length());
        OutputStream os = he.getResponseBody();
        try{
            os = he.getResponseBody();
            os.write(message.getBytes());
        }finally{
            os.close();
        }
    }
}
class HttpServerExample{
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
                server.createContext("/test", new TestHandler());
                server.setExecutor(Executors.newFixedThreadPool(5));
                server.start();
        
    }
}