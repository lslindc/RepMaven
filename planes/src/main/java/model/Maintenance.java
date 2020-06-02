package model;

public class Maintenance {

	private Long id;
	private String company;
	private String specialization;

	public Maintenance() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "company: " + getCompany() + " specialization: " + getSpecialization();
	}

}
