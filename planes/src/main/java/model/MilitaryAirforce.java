package model;

public class MilitaryAirforce {

	private Long id;
	private String name;
	private String country;
	private Integer amount;

	public MilitaryAirforce() {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "name: " + getName() + " country: " + getCountry() + " amount: " + getAmount();
	}

}
