#include <stdio.h>

void main()
{
	int i, num[10];
	int evenctr = 0, oddctr = 0, evensum = 0, oddsum = 0;
	
	for(i=0;i<=9;i++)
		{
			printf("\tEnter num[%d] : ", i+1);
			scanf("%d", &num[i]);
			if(num[i]%2==0) 
				{
					evenctr++;
					evensum = evensum + num[i];
				}
			else 
				{
					oddctr++;
					oddsum = oddsum + num[i];
				}
		}
		printf("\n\t Even counter = %d", evenctr);
		printf("\n\t     Even sum = %d", evensum);
		printf("\n\t  Odd counter = %d", oddctr);
		printf("\n\t      Odd sum = %d", oddsum);
}