#include <stdio.h>

void main()
{
	int i, num, num1 = 1, num2 = 1, num3;
	printf("\n\t Enter the number : ");
	scanf("%d", &num);
	printf("\n\t 1, 1 ");
	for(i=2;i<=num;i++)
		{
			num3 = num1 + num2;
			printf(", %d", num3);
			num1 = num2;
			num2 = num3;
		}
}