package br.com.paulocollares.simple_http_server.pages;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Esta classe é responsável por gerenciar as requisições http feitas no
 * contexto /
 *
 * @author Paulo Collares
 */
public class Root implements HttpHandler {

    @Override
    public void handle(HttpExchange he) throws IOException {
        StringBuilder out = new StringBuilder();

        out.append("<html>");
        out.append("<head>");
        out.append("<title>Ola mundo").append("</title>");
        out.append("</head>");
        out.append("<body>");
        out.append("Olá mundo");
        out.append("</body>");
        out.append("</html>");

        String saida = out.toString();

        he.sendResponseHeaders(200, saida.length());

        try (OutputStream os = he.getResponseBody()) {
            os.write(saida.getBytes("ISO-8859-1"));
        }
    }

}
