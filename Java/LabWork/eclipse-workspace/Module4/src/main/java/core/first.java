package core;

public class first {

	public static void main(String[] args) {
		pojo p=new pojo();
		p.setId(1);
		p.setCity("Ahmedabad");
		p.setEmail("java@gmail.com");
		p.setPassword("Teach@43210");
		
		System.out.println(p.getId()+" "+p.getCity()+" "+p.getEmail()+" "+p.getPassword());
	}
}
