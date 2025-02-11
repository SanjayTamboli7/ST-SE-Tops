package Common;

interface FirstInterface {
	public void myMethod(); // interface method
}

interface SecondInterface {
	public void myOtherMethod(); // interface method
}

class DemoClass implements FirstInterface, SecondInterface {
	public void myMethod() {
		System.out.println("Some text..");
	}

	public void myOtherMethod() {
		System.out.println("Some other text...");
	}
}

public class OneClassManyInterfaces {
	public static void main(String[] args) {
		DemoClass myObj = new DemoClass();
		myObj.myMethod();
		myObj.myOtherMethod();
	}
}
