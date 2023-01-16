#include <stdio.h>

void main()
{
	int i, num, factorial=1;
	printf("\n\t Enter the number : ");
	scanf("%d", &num);
	printf("\n\t 1");
	for(i=1;i<=num;i++)
		{
			if (i>1) printf(" X %d", i);
			factorial = factorial * i;
		}
		printf(" = %d", factorial);
}