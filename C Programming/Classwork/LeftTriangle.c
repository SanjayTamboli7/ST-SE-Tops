#include <stdio.h>

void main()
{
	int i, j, ilength;
	printf("\n\t Enter base length : ");
	scanf("%d", &ilength);
	for(i=1;i<=ilength;i++)
	{
		printf("\n\t");
		for (j=1;j<=i;j++)
		{
			printf("*");
		}
	}
}