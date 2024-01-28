package com.simple;

/*
++ == <, <=
-- == >, >=

While 
------
Initialization
while (condition)
{
	statements;
	increment / decrement operator
}
*/

public class WhileDemo
{
	public static void main(String[] args)
	{
		int i=1;
		while(i<=5)
		{
			System.out.println(i);
			i++;
		}
	}
}
