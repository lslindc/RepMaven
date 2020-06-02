package dao.MyBatisImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.IManufacturerDAO;
import model.Manufacturer;
import utils.MyBatisConfigUtil;

public class ManufacturerDAO implements IManufacturerDAO {

	private IManufacturerDAO entityDAO;
	private Class<IManufacturerDAO> DAOClass = IManufacturerDAO.class;

	@Override
	public Manufacturer getManufacturerById(Long id) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		Manufacturer entity = entityDAO.getManufacturerById(id);
		session.close();
		return entity;
	}

	@Override
	public List<Manufacturer> getManufacturer() {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		List<Manufacturer> entities = entityDAO.getManufacturer();
		session.close();
		return entities;
	}

	@Override
	public void insertManufacturer(Manufacturer entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.insertManufacturer(entity);
		session.commit();
		session.close();

	}

	@Override
	public void deleteManufacturer(Manufacturer entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.deleteManufacturer(entity);
		session.commit();
		session.close();
	}

	@Override
	public void updateManufacturer(Manufacturer entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.updateManufacturer(entity);
		session.commit();
		session.close();
	}

}
