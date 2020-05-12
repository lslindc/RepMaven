package exceptions;

public class EmptyHangarException extends Exception {

	@Override
	public String getMessage() {
		return "Hangar is empty!";
	}

}
