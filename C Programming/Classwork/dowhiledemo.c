#include<stdio.h>
/*
	do..while
	
	syntax :   initialization;
				
				do
			   {
			   		statement;
			   		updation;
			   }
			   while(condition);
			   
	- It is called as Exit Controlled Loop.
	-Because the condition is checked atlast.
	-it will execute the do block atleast once even if the 
	 condition is false.
	-Semicolon after while.			   

*/


void main()
{
	int i=10;   //initialization
	
	do
	{
		printf("%d\n",i); //statement
		i--;
	}
	while(i>=1); //condition
	
	
}





