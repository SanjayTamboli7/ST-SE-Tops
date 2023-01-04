#include <stdio.h>

void main()
{
	int a = 5, b = 10;
	
	if (a && b)
	{
		printf("\n\t 1st condition is true");
	}
	else
	{
		printf("\n\t 1st condition is flase");
	}
	if (a || b)
	{
		printf("\n\t 2nd condition is true");
	}
	else
	{
		printf("\n\t 2nd condition is flase");
	}
	b = 0;
	if (!(a && b))
	{
		printf("\n\t 3rd condition is true");
	}
	else
	{
		printf("\n\t 3rd condition is flase");
	}
	b = 10;
	if (!(a || b))
	{
		printf("\n\t 4th condition is true");
	}
	else
	{
		printf("\n\t 4th condition is flase");
	}


}

