package com.learn.executables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.learn.intermediate.jpa.Invoice;

public class InvoiceMainApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-testpu");
		EntityManager entityManager = emf.createEntityManager();
		Invoice invoice = entityManager.find(Invoice.class, 1);
		System.out.println("Order for invoice 1 : " + invoice.getOrder());
		entityManager.close();
		emf.close();
	}
}
