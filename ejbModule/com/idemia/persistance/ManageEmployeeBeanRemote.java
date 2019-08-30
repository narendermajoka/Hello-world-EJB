package com.idemia.persistance;

import javax.ejb.Remote;

@Remote
public interface ManageEmployeeBeanRemote {
	public boolean addEmployee(Employee employee);
}
