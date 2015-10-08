package com.learn.executables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.learn.intermediate.jpa.Product;

public class ProductMainClass {
	
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-testpu");
		EntityManager em = emf.createEntityManager();
		Product product = em.find(Product.class, 2000);
		System.out.println("Order details for product   : " + product.getOrderList());
		em.close();
		emf.close();
	}
}
