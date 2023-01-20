#include <stdio.h>

void f1()
	{
		f2();
		printf("\n\t Function 1 called.");
	}

void f2()
	{
		printf("\n\t Function 2 called.");
	}

void main()
	{
		printf("\n\t Before calling Function 1");
		f1();
		printf("\n\t Before calling Function 2");
		f2();
		printf("\n\t After calling Function 2");
	}