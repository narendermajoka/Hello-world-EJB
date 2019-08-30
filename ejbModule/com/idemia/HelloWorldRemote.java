package com.idemia;

import javax.ejb.Remote;

@Remote
public interface HelloWorldRemote {
	
	public String sayHello();

}
