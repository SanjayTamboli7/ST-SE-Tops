#include <stdio.h>

void main()
{

	// Variable declaration 
	
	int IntDays;
	float IntYears;
	
	// Prompting user and accepting value
	
	printf("\n\t Enter days : ");
	scanf("%d", &IntDays);
	IntYears = (IntDays / 365);
	printf("\n\t %.2f year", IntYears);
	if (IntYears > 1)
	{
		printf("s");
	}
}