package dao;

import java.util.List;

import model.MilitaryAirforce;

public interface IMilitaryAirforceDAO {

	MilitaryAirforce getMilitaryAirforceById(Long id);

	List<MilitaryAirforce> getMilitaryAirforce();

	void insertMilitaryAirforce(MilitaryAirforce entity);

	void deleteMilitaryAirforce(MilitaryAirforce entity);

	void updateMilitaryAirforce(MilitaryAirforce entity);
}
