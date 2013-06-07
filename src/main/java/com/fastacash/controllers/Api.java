package com.fastacash.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Api extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -373937384341365589L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("Hello from Api!\n");
    }
}
