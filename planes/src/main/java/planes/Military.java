package planes;

import org.apache.log4j.Logger;

public class Military extends Planes {

	private static final Logger LOGGER = Logger.getLogger(Military.class);
	int seats;

	public Military(int speed, String name) {
		super(speed, name);
	}

	public void setSeats(int value) {
		this.seats = value;
	}

	public int getSeats() {
		return this.seats;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		LOGGER.debug("Number of seats: " + seats);
	}

	@Override
	public void prepareForFlight() {

		LOGGER.debug("Tanks are fully refueled!");

		this.isReadyForFlight = true;
	}
}
