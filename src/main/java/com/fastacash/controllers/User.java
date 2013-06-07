package com.fastacash.controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.Proxy;

import model.Customer;

public class User extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2611595890053422070L;

	@PersistenceUnit(unitName = "enchilada") 
    private EntityManagerFactory emf;
	
	@PersistenceContext(unitName = "enchilada") 
    private EntityManager em;	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		List<Customer> cl = getCustomers();
		for (int i = 0; i < cl.size(); i++) {
			Customer c = cl.get(i);
			resp.getWriter().print("Hello from " + c.getFirstname() + " " + c.getLastname() + "<br>");
		}
	}
	
	public List<Customer> getCustomers()
	{													      
		EntityManagerFactory emf_ = javax.persistence.Persistence.createEntityManagerFactory("enchilada");
		EntityManager em = emf_.createEntityManager();
		TypedQuery<Customer> query = em.createNamedQuery("getAll", Customer.class);
		List<Customer> results = query.getResultList();
		return results;
	}
}
