package com.oops;

/* Create a class named 'Print Number' to print various numbers of different data types by 
   creating different methods with the same name 'printn' having a parameter for each data type.  */

class PrintNumber {
	
	void printn(byte btyeNum) {
		System.out.println("Byte = " + btyeNum);
	}
	
	void printn(short smyNum) {
		System.out.println("Short = " +  smyNum);
	}

	void printn(int imyNum) {
		System.out.println("Int = " +  imyNum);
	}
	
	void printn(long lmyNum) {
		System.out.println("long = " +  lmyNum);
	}

	void printn(float fmyNum) {
		System.out.println("float = " +  fmyNum);
	}

	void printn(double dmyNum) {
		System.out.println("double = " +  dmyNum);
	}
}

public class ModlCoreJavaCode20 {
	public static void main(String[] args) {
		
		PrintNumber pnByte = new PrintNumber();
		pnByte.printn((byte)   100);
		pnByte.printn((short) 5000);
		pnByte.printn((int) 100000);
		pnByte.printn((long) 15000000000L);
		pnByte.printn((float) 5.75f);
		pnByte.printn((double) 19.99d);
	}
}
