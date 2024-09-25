package core;

public class cons {
	 int id;
	 String email;
	 String password;
	 String city;

	public cons(int id, String email, String password, String city) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.city = city;
		System.out.println(id);
		System.out.println(email);
		System.out.println(password);
		System.out.println(city);
		System.out.println("--------------");
	}

	public cons(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		System.out.println(id);
		System.out.println(email);
		System.out.println(password);
	}

	public static void main(String[] args) {
		cons c1=new cons(2, "one@gmail.com", "Teach@43210", "Ahd");
		cons c2=new cons(2, "one@gmail.com", "Teach@43210");
	}
}
