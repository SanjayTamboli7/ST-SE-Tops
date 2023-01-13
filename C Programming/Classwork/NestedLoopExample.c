#include <stdio.h>

void main()
{
	int i, j, si, sj;
	printf("\n\t Enter value to start table : ");
	scanf("%d", &si);
	printf("\n\t Enter value to end table : ");
	scanf("%d", &sj);
	for(i=si;i<=sj;i++)
	{
		for(j=1;j<=10;j++)
		{
			 printf("\n\t %d X %d = %d", i, j, (i*j));
		}
		printf("\n\t=========");
	}
}