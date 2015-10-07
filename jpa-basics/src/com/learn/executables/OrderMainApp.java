package com.learn.executables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.learn.intermediate.jpa.Order;

public class OrderMainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-testpu");
		EntityManager em = emf.createEntityManager();
		Order order = em.find(Order.class, 111);
	    System.out.println("Invoice details for order 111 : " + order.getInvoice());
	    em.close();
	    emf.close();
	}
}
