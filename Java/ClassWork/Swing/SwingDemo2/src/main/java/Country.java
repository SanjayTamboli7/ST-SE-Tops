/**
 * A model class represents a country.
 * @author www.codejava.net
 *
 */
public class Country {
	private String name;

	public Country(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
	
}
