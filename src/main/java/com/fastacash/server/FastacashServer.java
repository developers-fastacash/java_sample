package com.fastacash.server;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import com.fastacash.controllers.Api;
import com.fastacash.controllers.User;

public class FastacashServer {

    public static void main(String[] args) throws Exception {
    	BasicConfigurator.configure();
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        Api api = new Api();
        context.addServlet(new ServletHolder(api), "/api");
        context.addServlet(new ServletHolder(new User()), "/user");
        server.start();
        server.join();
    }
}
