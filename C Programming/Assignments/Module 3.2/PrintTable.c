#include <stdio.h>

void main()
{
	int i, j, num;
	printf("\n\t Enter the number : ");
	scanf("%d", &num);
	for(i=1;i<=num;i++)
		{
			for(j=1;j<=10;j++)	
				{
					printf("\n\t %d X %d = %d", i, j, (i*j));					
				}
			printf("\n\t ================");
		}
}