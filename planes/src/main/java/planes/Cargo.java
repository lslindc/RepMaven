package planes;

import org.apache.log4j.Logger;

public class Cargo extends Planes implements IPlanes {

	private static final Logger LOGGER = Logger.getLogger(Cargo.class);
	private int capacity;

	public Cargo() {}
	
	public Cargo(int speed, String name) {
		super(speed, name);
	}

	public void setCapacity(int value) {
		this.capacity = value;
	}

	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		LOGGER.info("Capacity: " + capacity);
	}

	@Override
	public void prepareForFlight() {

		LOGGER.info("Cargo was loaded!");

		this.isReadyForFlight = true;
	}
}
