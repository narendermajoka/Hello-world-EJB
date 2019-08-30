package com.idemia;

import javax.ejb.Stateless;

@Stateless
public class HelloWorld implements HelloWorldRemote {

	public HelloWorld() {
	}

	public String sayHello() {
		return "Hello World!";
	}

}
