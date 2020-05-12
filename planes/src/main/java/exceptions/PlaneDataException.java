package exceptions;

public class PlaneDataException extends Exception {

	@Override
	public String getMessage() {
		return "Wrong plane data";
	}
}
