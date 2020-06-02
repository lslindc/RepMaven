package dao;

import java.util.List;

import model.Manufacturer;

public interface IManufacturerDAO {

	Manufacturer getManufacturerById(Long id);

    List<Manufacturer> getManufacturer();

    void insertManufacturer(Manufacturer entity);

    void deleteManufacturer(Manufacturer entity);

    void updateManufacturer(Manufacturer entity);
	
}
