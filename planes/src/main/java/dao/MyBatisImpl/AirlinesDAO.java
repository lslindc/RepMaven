package dao.MyBatisImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.IAirlinesDAO;
import model.Airlines;
import utils.MyBatisConfigUtil;

public class AirlinesDAO implements IAirlinesDAO {

	private IAirlinesDAO entityDAO;
	private Class<IAirlinesDAO> DAOClass = IAirlinesDAO.class;

	@Override
	public Airlines getAirlinesById(Long id) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		Airlines entity = entityDAO.getAirlinesById(id);
		session.close();
		return entity;
	}

	@Override
	public List<Airlines> getAirlines() {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		List<Airlines> entities = entityDAO.getAirlines();
		session.close();
		return entities;
	}

	@Override
	public void insertAirlines(Airlines entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.insertAirlines(entity);
		session.commit();
		session.close();
	}

	@Override
	public void deleteAirlines(Airlines entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.deleteAirlines(entity);
		session.commit();
		session.close();

	}

	@Override
	public void updateAirlines(Airlines entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.updateAirlines(entity);
		session.commit();
		session.close();

	}

}
