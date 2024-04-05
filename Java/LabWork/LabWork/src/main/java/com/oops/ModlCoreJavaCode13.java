package com.oops;

/* W.A.J.P to get the character at the given index within the String. Original String = Tops Technologies! 
   The character at position 0 is T, The character at position 10 is o */

public class ModlCoreJavaCode13 {
	public static void main(String[] args) {
		String strName = "Tops Technologies!";
		int strLength = strName.length();
		System.out.println(strName);
		for (int ctr = 0; ctr < strLength; ctr++) {
			System.out.println("Character position [ " + ctr + " ] = " + strName.charAt(ctr));
		}
	}
}
