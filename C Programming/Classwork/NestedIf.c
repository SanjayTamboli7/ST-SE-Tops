#include <stdio.h>

void main()
{
	int a, b, c;
	
	printf("\n\t Enter value for A : ");
	scanf("%d", &a);
	printf("\n\t Enter value for B : ");
	scanf("%d", &b);
	printf("\n\t Enter value for C : ");
	scanf("%d", &c);
	
	printf("\n\t A = %d, B = %d, C = %d", a, b, c);
	
	if (a > b)
	{
		if (a > c)
		{
			printf("\n\t a is greater");
		}
		else
		{
			printf("\n\t c is greater");
		}
	}
	else
	{
		if (b > c)
		{
			printf("\n\t b is greater");
		}
		else
		{
			printf("\n\t c is greater");
		}
	}
}