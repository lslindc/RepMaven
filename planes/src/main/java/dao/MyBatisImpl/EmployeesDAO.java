package dao.MyBatisImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.IEmployeesDAO;
import model.Employees;
import utils.MyBatisConfigUtil;

public class EmployeesDAO implements IEmployeesDAO {

	private IEmployeesDAO entityDAO;
	private Class<IEmployeesDAO> DAOClass = IEmployeesDAO.class;

	@Override
	public Employees getEmployeesById(Long id) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		Employees entity = entityDAO.getEmployeesById(id);
		session.close();
		return entity;
	}

	@Override
	public List<Employees> getEmployees() {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		List<Employees> entities = entityDAO.getEmployees();
		session.close();
		return entities;
	}

	@Override
	public void insertEmployees(Employees entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.insertEmployees(entity);
		session.commit();
		session.close();

	}

	@Override
	public void deleteEmployees(Employees entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.deleteEmployees(entity);
		session.commit();
		session.close();

	}

	@Override
	public void updateEmployees(Employees entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.updateEmployees(entity);
		session.commit();
		session.close();

	}

}
