#include <stdio.h>

void faktorial(int num, int num1, int factorial)
	{
		if(num==num1+1)		
			{
				printf(" = %d", factorial);		
				return;
			}
		else 
			{
				printf(" X %d", num);
				factorial = factorial * num;
				num++;
				faktorial(num, num1, factorial);
			}
	}

void main()
{
	int i, num, factorial=1;
	printf("\n\t Enter the number : ");
	scanf("%d", &num);
	printf("\n\t 1");
	faktorial(1, num, factorial);
}