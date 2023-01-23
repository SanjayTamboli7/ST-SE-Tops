#include <stdio.h>

int add(int x, int y)
	{
		return (x+y);		
	}

void main()
	{
		int a, b, sum;
		printf("\n\t Enter value a : ");
		scanf("%d", &a);
		printf("\n\t Enter value b : ");
		scanf("%d", &b);
		printf("\n\t In Main a = %d, b = %d", a, b);
		printf("\n\t Starts swap");
		sum = add(a, b);
		printf("\n\t Stops swap");		
		printf("\n\t Sum = %d", sum);
		printf("\n\t Sum is ");
		if (sum%2==0)
			{
				printf("Even.");
			}
		else
			{
				printf("Odd.");
			}
	
	}