package Common;

class Animal { // Superclass (parent)
	public void animalSound() {
		System.out.println("The animal makes a sound1");
	}
}

class Dog extends Animal { // Subclass (child)
	public void animalSound() {
		super.animalSound(); // Call the superclass method
		System.out.println("The dog says: bow1 wow1");
	}
}

public class SuperDemo {
	public static void main(String args[]) {
		Animal myDog = new Dog(); // Create a Dog object	
		myDog.animalSound(); // Call the method on the Dog object
	}
}
