package com.learn.executables;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.learn.intermediate.jpa.Customer;

public class CustomerMainApp {

	public static void main(String[] args) {
	    EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("customerpu");
	    EntityManager em = entityManagerFactory.createEntityManager();
	    EntityTransaction userTransaction = em.getTransaction();
	    
	    userTransaction.begin();
	    Customer customer = new Customer();
	    customer.setFirstName("Charles");
	    customer.setLastName("Dickens");
	    customer.setCustType("RETAIL");
	    customer.setStreet("10 Downing Street");
	    customer.setAppt("1");
	    customer.setCity("NewYork");
	    customer.setZipCode("12345");
	    em.persist(customer);
	    userTransaction.commit();
	    em.close();
	    entityManagerFactory.close();
	}
}
