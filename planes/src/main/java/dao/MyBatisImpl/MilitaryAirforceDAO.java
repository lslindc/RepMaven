package dao.MyBatisImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.IMilitaryAirforceDAO;
import model.MilitaryAirforce;
import utils.MyBatisConfigUtil;

public class MilitaryAirforceDAO implements IMilitaryAirforceDAO {

	private IMilitaryAirforceDAO entityDAO;
	private Class<IMilitaryAirforceDAO> DAOClass = IMilitaryAirforceDAO.class;

	@Override
	public MilitaryAirforce getMilitaryAirforceById(Long id) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		MilitaryAirforce entity = entityDAO.getMilitaryAirforceById(id);
		session.close();
		return entity;
	}

	@Override
	public List<MilitaryAirforce> getMilitaryAirforce() {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		List<MilitaryAirforce> entities = entityDAO.getMilitaryAirforce();
		session.close();
		return entities;
	}

	@Override
	public void insertMilitaryAirforce(MilitaryAirforce entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.insertMilitaryAirforce(entity);
		session.commit();
		session.close();

	}

	@Override
	public void deleteMilitaryAirforce(MilitaryAirforce entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.deleteMilitaryAirforce(entity);
		session.commit();
		session.close();

	}

	@Override
	public void updateMilitaryAirforce(MilitaryAirforce entity) {
		SqlSession session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
		entityDAO = session.getMapper(DAOClass);
		entityDAO.updateMilitaryAirforce(entity);
		session.commit();
		session.close();

	}

}
