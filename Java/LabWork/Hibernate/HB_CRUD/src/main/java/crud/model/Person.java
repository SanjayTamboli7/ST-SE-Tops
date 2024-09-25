package crud.model;

@SuppressWarnings("serial")
public class Person implements java.io.Serializable {

	/* id, first_name, last_name, age, profession` */

	private Integer id;
    private String first_name;
    private String last_name;
    private String age;
    private String profession;
    
    public Person() {

    }

    public Person(String first_name, String last_name, String age, String profession) {

       this.first_name = first_name;
       this.last_name = last_name;
       this.age = age;
       this.profession = profession;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}

}