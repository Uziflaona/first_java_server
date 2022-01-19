package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.FirstServlet;
import templater.PageGenerator;

import javax.servlet.http.HttpServletRequest;

public class Main {
    public static void main (String[] args) throws Exception {
        FirstServlet firstServlet = new FirstServlet();

        Server server = new Server(8080);
        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);

        ServletHolder servletHolder = new ServletHolder(firstServlet);
        context.addServlet(servletHolder, "/authform");

        server.setHandler(context);

        server.start();
        server.join();
    }
}
