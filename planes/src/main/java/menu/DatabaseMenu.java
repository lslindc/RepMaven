package menu;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import dao.MyBatisImpl.PlanesDAO;
import model.Planes;

public class DatabaseMenu {

	private final static Logger LOGGER = Logger.getLogger(DatabaseMenu.class);

	Scanner scanner = new Scanner(System.in);

	public void getPlanes() {

		PlanesDAO planesDB = new PlanesDAO();
		List<Planes> planes = planesDB.getPlanes();
		for (Planes p : planes) {
			LOGGER.info("Name: " + p.getName() + " " + "Model: " + p.getModel() + " " + "Type: " + p.getType() + " "
					+ "Crew :" + p.getCrew() + " " + "Speed: " + p.getSpeed() + " " + "Id: " + p.getId());
		}
	}

	public void getPlanesById() {

		LOGGER.info("Enter id of a Plane: ");
		Long id = scanner.nextLong();
		Planes plane = new PlanesDAO().getPlaneById(id);
		LOGGER.info(plane.getName());
	}

	public void deletePlane() {

		LOGGER.info("Choose id of a Plane to delete: ");
		Long id = scanner.nextLong();
		Planes plane = new PlanesDAO().getPlaneById(id);
		new PlanesDAO().deletePlane(plane);
		LOGGER.info("Deleted successfully!");

	}

}
