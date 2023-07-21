#include<stdio.h>
/*
1) Function with no return-type and with no argument
	
		e.g: 
		
				void f1()
				{
					// piece of code.
				}
				
				
				A Function which calls itself is called a recursive function.
				
*/	

// Function Creation
void f1()
{
	f2();
	printf("\nFunction1 Called.");
}

void f2()
{

	printf("\nFunction2 Called.");
}

void main()
{
	printf("\nStart Function.");
	f1();  //Function Utilization.
	f2();
	printf("\nEnd Function.");
}









