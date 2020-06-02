package model;

public class Employees {

	private Long id;
	private String name;
	private int age;
	private int flightexperience;

	public Employees() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFlightexperience() {
		return flightexperience;
	}

	public void setFlightexperience(int flightexperience) {
		this.flightexperience = flightexperience;
	}

	@Override
	public String toString() {
		return "name: " + getName() + " age: " + getAge() + " flightexperience: " + getFlightexperience();
	}

}
