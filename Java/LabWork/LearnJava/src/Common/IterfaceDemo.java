package Common;

//Interface
interface Creature {
	public void CreatureSound(); // interface method (does not have a body)
	public void RestToSleep(); // interface method (does not have a body)
}

//Pig "implements" the Animal interface
class Pig implements Creature {
	public void CreatureSound() {
		// The body of animalSound() is provided here
		System.out.println("The pig says: wee wee");
	}

	public void RestToSleep() {
		// The body of sleep() is provided here
		System.out.println("Zzz");
	}
}

public class IterfaceDemo {
	public static void main(String[] args) {
		Pig myPig = new Pig(); // Create a Pig object
		myPig.CreatureSound();
		myPig.RestToSleep();
	}
}
