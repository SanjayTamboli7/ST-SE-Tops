#include <stdio.h>

void f1()
	{
		printf("\n Function 1 called");
	}

void f2()
	{
		printf("\n Funtion 2 called");
	}

void main()
	{
		printf("\nBefore calling function 1");
		f1();
		printf("\nBefore calling function 2");
		f2();
		printf("\nAfter calling function 1");
	}