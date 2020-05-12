package planes;

public interface IPlanes {

	default public void prepareForFlight(String name) {
		System.out.println("Your plane " + name + " added");
	}
}
