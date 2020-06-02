package model;

public class Airlines {

	private Long id;
	private String name;
	private String country;
	private Integer employees;

	public Airlines() {
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "name: " + getName() + " country: " + getCountry() + " employees: " + getEmployees();
	}
	
	
}
