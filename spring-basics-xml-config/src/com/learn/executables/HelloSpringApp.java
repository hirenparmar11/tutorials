package com.learn.executables;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.basic.spring.hello.HelloWorld;

public class HelloSpringApp {
	public static void main(String[] args) {
	      ApplicationContext context = 
	             new ClassPathXmlApplicationContext("beans.xml");
	      
	      //String useBean = "helloWorld";
	      String useBean = "helloWorldProto";

	      HelloWorld helloOne = (HelloWorld) context.getBean(useBean);
	      helloOne.setMessage("Not the default message");
	      System.out.println(helloOne.getMessage());
	      
	      HelloWorld helloTwo = (HelloWorld) context.getBean(useBean);
	      System.out.println(helloTwo.getMessage());
	      
	      //unable to prove prototype scope, but it basically creates another reference, 
	      //while default(singleton), it repeats using same bean
	   }
}