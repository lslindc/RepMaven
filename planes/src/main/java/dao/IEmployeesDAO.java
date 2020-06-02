package dao;

import java.util.List;

import model.Employees;

public interface IEmployeesDAO {

	Employees getEmployeesById(Long id);

	List<Employees> getEmployees();

	void insertEmployees(Employees entity);

	void deleteEmployees(Employees entity);

	void updateEmployees(Employees entity);
}
