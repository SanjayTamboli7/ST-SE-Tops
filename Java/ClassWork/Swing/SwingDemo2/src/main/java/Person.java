/**
 * A model class that represents a person.
 * @author www.codejava.net
 *
 */
public class Person {
	private String name;
	private Country country;
	private String job;
	
	public Person(String name, Country country, String job) {
		this.name = name;
		this.country = country;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
		
}
