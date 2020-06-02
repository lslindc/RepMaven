package dao;

import java.util.List;

import model.Airlines;

public interface IAirlinesDAO {

	Airlines getAirlinesById(Long id);

    List<Airlines> getAirlines();

    void insertAirlines(Airlines entity);

    void deleteAirlines(Airlines entity);

    void updateAirlines(Airlines entity);

	
	
}
