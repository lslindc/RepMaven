package planes;

import org.apache.log4j.Logger;

public class Passenger extends Planes {

	private static final Logger LOGGER = Logger.getLogger(Passenger.class);
	private int passengers;

	public Passenger(int speed, String name) {
		super(speed, name);
	}

	public void setPassengers(int value) {
		this.passengers = value;
	}

	public int getPassengers() {
		return this.passengers;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		LOGGER.debug("Passengers: " + passengers);
	}

	@Override
	public void prepareForFlight() {

		LOGGER.debug("Passengers on the board!");

		this.isReadyForFlight = true;
	}
}
