package com.learn.executables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.learn.intermediate.jpa.Product;

public class ProductMainApp {
	
	public static void main(String[] args) {
	
		//was getting error
		//org.apache.openjpa.persistence.ArgumentException: 
		//No metadata was found for type . ''The class is not enhanced
		//resolved it by adding Entity to persistence.xml
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-testpu");
		EntityManager em = emf.createEntityManager();
		Product product = em.find(Product.class, 2000);
		System.out.println("Order details for product   : " + product.getOrderList());
		em.close();
		emf.close();
	}
}
