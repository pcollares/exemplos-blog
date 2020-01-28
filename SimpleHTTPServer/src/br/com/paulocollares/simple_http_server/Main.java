package br.com.paulocollares.simple_http_server;

import br.com.paulocollares.simple_http_server.pages.Root;
import br.com.paulocollares.simple_http_server.pages.Stats;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principal
 *
 * @author Paulo Collares
 */
public class Main {

    public static void main(String[] args) {
        try {
            HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);
            servidor.createContext("/", new Root());
            servidor.createContext("/stats", new Stats());
            servidor.start();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
