#include <stdio.h>

void main()
{

	// Variable declaration 
	
	int IntYear;
	
	// Prompting user and accepting value
	
	printf("\n\t Enter year (4 digit) : ");
	scanf("%d", &IntYear);
	
	// Find out whether year is leap year or not.
	
	if ((IntYear % 4)==0)
		{
			printf("\n\t %d is a leap year", IntYear);
		}
	else
		{
			printf("\n\t %d is a non-leap year", IntYear);
		}
}