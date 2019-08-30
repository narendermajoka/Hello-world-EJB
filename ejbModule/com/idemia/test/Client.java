package com.idemia.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.idemia.HelloWorldRemote;
import com.idemia.persistance.Employee;
import com.idemia.persistance.ManageEmployeeBeanRemote;

public class Client {
	private static final String PROVIDER_URL = "jnp://localhost:1099";
	private static final String JNP_INTERFACES = "org.jboss.naming:org.jnp.interfaces";
	private static final String INITIAL_CONTEXT_FACTORY = "org.jnp.interfaces.NamingContextFactory";
	private static Context initialContext;

	public static void main(String[] args) {
		helloWorld("HelloWorld/remote");
		addEmployee("ManageEmployeeBean/remote");
	}

	private static void addEmployee(String lookupString) {
		ManageEmployeeBeanRemote bean = (ManageEmployeeBeanRemote) getBean(lookupString);
		Employee employee = new Employee();
		employee.setFirstName("Narender");
		employee.setLastName("Majoka");
		employee.setEmail("nm@gmail.com");
		bean.addEmployee(employee);
	}

	private static Object getBean(String lookupString) {
		Context context = null;
		Object ob = null;
		try {
			context = getInitialContext();
			ob = context.lookup(lookupString);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ob;
	}

	private static void helloWorld(String lookupString) {
		HelloWorldRemote bean = (HelloWorldRemote) getBean(lookupString);
		System.out.println(bean.sayHello());
	}

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
			prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
			prop.put(Context.PROVIDER_URL, PROVIDER_URL);
			initialContext = new InitialContext(prop);
		}
		return initialContext;
	}
}
