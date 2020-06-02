package dao.MyBatisImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.IMaintenanceDAO;
import model.Maintenance;
import utils.MyBatisConfigUtil;

public class MaintenanceDAO implements IMaintenanceDAO {

	private IMaintenanceDAO entityDAO;
	private Class<IMaintenanceDAO> DAOClass = IMaintenanceDAO.class;

	@Override
	public Maintenance getMaintenanceById(Long id) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		Maintenance entity = entityDAO.getMaintenanceById(id);
		session.close();
		return entity;
	}

	@Override
	public List<Maintenance> getMaintenance() {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		List<Maintenance> entities = entityDAO.getMaintenance();
		session.close();
		return entities;
	}

	@Override
	public void insertMaintenance(Maintenance entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.insertMaintenance(entity);
		session.commit();
		session.close();

	}

	@Override
	public void deleteMaintenance(Maintenance entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.deleteMaintenance(entity);
		session.commit();
		session.close();

	}

	@Override
	public void updateMaintenance(Maintenance entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.updateMaintenance(entity);
		session.commit();
		session.close();

	}

}
