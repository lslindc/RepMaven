package planes;

import org.apache.log4j.Logger;
import menu.Menu;

public abstract class Planes implements IPlanes {

	private static final Logger LOGGER = Logger.getLogger(Menu.class);
	private int speed = 0;
	private String name = "default";
	public static String planecolor = "white";
	boolean isReadyForFlight;

	private static int planesCreated = 0;

	public Planes(int speed, String name) {
		planesCreated++;
		this.speed = speed;
		this.name = name;
	}

	public void printInfo() {
		LOGGER.debug("Name: " + name);
		LOGGER.debug("Speed: " + speed + " km/h");

		Planes.getplaneColor();
	}

	public static void getplaneColor() {

		LOGGER.debug("Plane color: " + planecolor);
		return;
	}

	public void prepareForFlight() {
	}

	public String getName() {
		return this.name;
	}

	public static int getPlanesCreated() {
		return planesCreated;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
