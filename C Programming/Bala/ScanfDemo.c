#include <stdio.h>

void main()
	{
		int number;
		
		printf("\n\t Enter An Integer Number :");
		scanf("%d", &number);
		if(number<=100)
				{
					printf("\n\tYou entered number less than 101");
				}
			else
				{
					printf("\n\tYou entered number greater than 100");
				}
	}