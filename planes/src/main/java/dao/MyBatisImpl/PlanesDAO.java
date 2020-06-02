package dao.MyBatisImpl;

import dao.IPlanesDAO;
import model.Planes;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import utils.MyBatisConfigUtil;

public class PlanesDAO implements IPlanesDAO {

	private IPlanesDAO entityDAO;
	private Class<IPlanesDAO> DAOClass = IPlanesDAO.class;

	@Override
	public Planes getPlaneById(Long id) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		Planes entity = entityDAO.getPlaneById(id);
		session.close();
		return entity;
	}

	@Override
	public List<Planes> getPlanes() {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		List<Planes> entities = entityDAO.getPlanes();
		session.close();
		return entities;
	}

	@Override
	public void insertPlane(Planes entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.insertPlane(entity);
		session.commit();
		session.close();
	}

	@Override
	public void deletePlane(Planes entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.deletePlane(entity);
		session.commit();
		session.close();
	}

	@Override
	public void updatePlane(Planes entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.updatePlane(entity);
		session.commit();
		session.close();
	}

}
