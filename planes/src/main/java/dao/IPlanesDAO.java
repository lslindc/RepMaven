package dao;

import java.util.List;

import model.Planes;

public interface IPlanesDAO {

	 Planes getPlaneById(Long id);

	    List<Planes> getPlanes();

	    void insertPlane(Planes entity);

	    void updatePlane(Planes entity);

	    void deletePlane(Planes entity);
	
	
	
}
