package menu;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

import hangar.Hangar;
import planes.*;
import exceptions.EmptyHangarException;
import exceptions.PlaneDataException;
import utils.*;
import db.*;

public class Menu {

	Hangar hangar = new Hangar();
	private static final Logger LOGGER = Logger.getLogger(Menu.class);

	public void ShowMenu() throws Exception {

		boolean exit = false;

		do {
			try {
				System.out.println("Please select action from menu");
				System.out.println("Menu:");
				System.out.println("1 - Add new plane");
				System.out.println("2 - Remove plane");
				System.out.println("3 - Show info of planes");
				System.out.println("4 - Print info about Planes");
				System.out.println("5 - IO Writer/Reader");
				System.out.println("6 - Work with DB");
				System.out.println("7 - Exit");

				Scanner in = new Scanner(System.in);
				if (in.hasNextInt()) {

					int action = in.nextInt();
					switch (action) {

					case 1:
						addPlane();
						break;
					case 2:
						removePlane();
						break;
					case 3:
						infoPlanes();
						break;
					case 4:
						printInfo();
						break;
					case 5:
						workWithIO();
						break;
					case 6:
						workWithDB();
						break;
					case 7:
						exit = true;
						LOGGER.info("Bye!");
						break;
					default:
						LOGGER.info("Default case exception. Please choose number from 1 to 5");
						break;
					}
				} else {
					LOGGER.info("Sorry, you must enter digit");
				}
			} catch (InputMismatchException e) {
				LOGGER.info("Element doesnt exist. Choose number from 1 to 5");
			} catch (PlaneDataException e) {
				LOGGER.error(e.getMessage());
			} catch (EmptyHangarException e) {
				LOGGER.error(e.getMessage());
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			} finally {

				LOGGER.info("=====================");
				LOGGER.info("Finally block reached");
				LOGGER.info("=====================");

			}
		} while (!exit);

	}

	private void addPlane() throws PlaneDataException {
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		try {

			System.out.println("What type of plane you want to add? ");
			System.out.println("|1 - Cargo| |2 - Passenger| |3 - Military| |4 - Exit|");
			int choosePlane = in.nextInt();

			String name;
			int speed;

			switch (choosePlane) {

			case 1:
				LOGGER.info("Type name of a plane: ");
				name = in.next();

				LOGGER.info("Type maximum speed of a plane: ");
				speed = in.nextInt();

				Cargo cargoPlane = new Cargo(speed, name);
				hangar.addPlane(cargoPlane);
				hangar.addCargo(cargoPlane);
				cargoPlane.prepareForFlight(name);

				break;
			case 2:
				LOGGER.info("Type name of a plane: ");
				name = in.next();
				LOGGER.info("Type maximum speed of a plane: ");
				speed = in.nextInt();
				LOGGER.info("Type number of passengers: ");
				int passengers = in.nextInt();

				Passenger passengerPlane = new Passenger(speed, name);
				passengerPlane.setPassengers(passengers);
				hangar.addPlane(passengerPlane);
				hangar.addPassenger(passengerPlane);
				passengerPlane.prepareForFlight(name);

				break;
			case 3:
				LOGGER.info("Type name of a plane: ");
				name = in.next();
				LOGGER.info("Type maximum speed of a plane: ");
				speed = in.nextInt();
				LOGGER.info("Type number of seats: ");
				int seats = in.nextInt();

				Military militaryPlane = new Military(speed, name);
				militaryPlane.setSeats(seats);
				hangar.addPlane(militaryPlane);

				hangar.setMilitaryPlane(militaryPlane);
				militaryPlane.prepareForFlight(name);

				break;
			case 4:
				exit = true;
				break;

			default:
				LOGGER.info("Wrong value");
				break;
			}

		} catch (InputMismatchException e) {
			LOGGER.error(e.getMessage());
			throw new PlaneDataException();
		}
	}

	private void removePlane() {
		try {
			Scanner in = new Scanner(System.in);

			LOGGER.info("=====================");
			LOGGER.info("Enter number of the Plane that you want to delete");
			int index = in.nextInt();
			hangar.removePlane(index - 1);
			LOGGER.info("Successfully deleted");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	private void infoPlanes() throws EmptyHangarException {
		LOGGER.info("=====================");
		LOGGER.info("Info of planes: ");
		LOGGER.info("");
		List<Planes> planes = hangar.getListPlanes();

		if (planes.isEmpty()) {
			throw new EmptyHangarException();
		} else {
			LOGGER.info("List of planes: ");
			for (Planes p : planes) {
				p.printInfo();
				System.out.println();
			}
			LOGGER.info("Total planes created: " + Planes.getPlanesCreated());
		}
	}

	private void printInfo() {
		Hangar.printInfo(hangar.getListPlanes());
	}

	private void workWithIO() {
		boolean exit = false;
		do {
			try {
				Scanner in = new Scanner(System.in);

				System.out.println("What do you want to do? ");
				System.out
						.println("|1 - Write to file| |2 - Read from file| |3 - Write property| |4 - Read Property| ");
				System.out.println(
						"|5 - Convert to String| |6 - Save json to file| |7 - Convert from String| |8 - Read json from file| |9 - Exit|");
				int IOOperation = in.nextInt();

				Planes plane;
				String planeString;

				switch (IOOperation) {

				case 1:
					IOWriterReader wf = new IOWriterReader();
					wf.writeToFile("Write to the file. Homework from Lesson11, topic IOFiles");
					LOGGER.info("Done");
					break;
				case 2:
					IOWriterReader rf = new IOWriterReader();
					rf.readFromFile();
					break;
				case 3:
					IOPropWriterReader fr = new IOPropWriterReader();
					fr.setValueToProperties("path", "C:\\Users\\Serg\\Desktop\\my.properties"); // use key and value!
					LOGGER.debug("Done");
					break;
				case 4:
					String path = IOPropWriterReader.getValueFromProperties("path"); // use key
					LOGGER.debug("Path to properties: " + path);
					break;
				case 5:
					plane = new Cargo(10, "test1");
					planeString = WorkWithJson.convertJavaToJsonStr(plane);
					LOGGER.info("Converted json plane:");
					LOGGER.info(planeString);
					break;
				case 6:
					plane = new Cargo(10, "test2");
					WorkWithJson.convertJavaToJsonFile(plane, "C:\\Users\\Serg\\Desktop\\plane.txt");
					LOGGER.info("Saved converted plane in file");
					break;
				case 7:
					String planeJson = "{\"name\":\"test3\",\"capacity\":15}";
					plane = WorkWithJson.convertJsonStrToPlanePOJO(planeJson);
					LOGGER.info("Converted POJO plane:");
					LOGGER.info(plane);
				case 8:
					plane = WorkWithJson.convertJsonFileToPlanePOJO("C:\\Users\\Serg\\Desktop\\plane.txt");
					LOGGER.info("Converted POJO plane from file:");
					LOGGER.info(plane);
					break;
				case 9:
					exit = true;
					LOGGER.info("You are on the main menu now!");
					break;
				default:
					LOGGER.debug("Wrong value. Please choose from 1 to 5");
					break;
				}

			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		} while (!exit);
	}

	private void workWithDB() {
		boolean exit = false;
		do {
			try {
				Scanner in = new Scanner(System.in);

				System.out.println("What do you want to do? ");
				System.out.println("|1 - Get info from DB| |2 - Write info to DB| |3 - Exit|");
				int DBOperation = in.nextInt();

				switch (DBOperation) {

				case 1:
					Query query = new Query();
					query.infoPlanes();
					break;
				case 2:
					List<Planes> planes = hangar.getListPlanes();
					Planes plane = planes.get(0);

					Query query1 = new Query();
					query1.addToDB(plane.getName(), plane.getSpeed());
					break;
				case 3:
					exit = true;
					LOGGER.info("You are on the main menu now!");
					break;
				default:
					LOGGER.info("Wrong value. Please choose 1 or 2");
					break;
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		} while (!exit);
	}

}
