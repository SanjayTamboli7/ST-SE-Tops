#include<stdio.h>

/*
	Conditional Statements : They perform some condition according to
	 						 the requirement of the client/user.
	 						 
	1) Simple if:
	2) if/else
	3) nested if/else
	4) ladder if/else
	
	
	1) Simple if : 
	
			syntax : if(0)
					 {
					 	//statement
					 }
					 
			condition : evaluates to True 1 or False. 0

*/


void main()
{
	int a,b;
	printf("\nEnter A : ");
	scanf("%d",&a);
	printf("\nEnter B : ");	
	scanf("%d",&b);
	printf("A = %d B = %d",a,b);
	
	if(a>0)
	{
		printf("\n%d is positive value",a);
	}
	else
	{
		printf("\n%d is negative value",a);
	}
	
	printf("\nOutside If block");
	
}










