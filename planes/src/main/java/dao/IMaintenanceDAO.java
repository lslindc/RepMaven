package dao;

import java.util.List;

import model.Maintenance;

public interface IMaintenanceDAO {

	Maintenance getMaintenanceById(Long id);

	List<Maintenance> getMaintenance();

	void insertMaintenance(Maintenance entity);

	void deleteMaintenance(Maintenance entity);

	void updateMaintenance(Maintenance entity);

}
