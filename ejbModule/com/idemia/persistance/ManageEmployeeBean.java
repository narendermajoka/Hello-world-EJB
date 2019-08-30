package com.idemia.persistance;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ManageEmployeeBean implements ManageEmployeeBeanRemote {

	@PersistenceContext(unitName = "EmpMgmtPU")
	private EntityManager entityManager;

	public ManageEmployeeBean() {
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean addEmployee(Employee employee) {
		entityManager.persist(employee);
		return true;
	}

}
