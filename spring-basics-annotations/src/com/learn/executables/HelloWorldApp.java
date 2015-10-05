package com.learn.executables;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.basic.spring.config.HelloWorldConfig;
import com.learn.basic.spring.hello.HelloWorld;

public class HelloWorldApp {

	public static void main(String[] args) {
	      ApplicationContext ctx = 
	      new AnnotationConfigApplicationContext(HelloWorldConfig.class);
	   
	      HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

	      helloWorld.setMessage("Hello World!");
	      System.out.println(helloWorld.getMessage());
	   }
}
