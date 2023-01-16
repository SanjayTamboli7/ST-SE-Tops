#include <stdio.h>

void main()
{
	int i, j, ilength, starctr=0;
	for(;;)
	{
		printf("\n\t Enter base length : ");
		scanf("%d", &ilength);
		if (ilength % 2 == 0)  
		{	
			printf("\n\t Enter even number");
		}	
		else
		{
			break;
		}	
	}
	for(i=1;i<=ilength;i++)
	{
		if (i%2!=0)
			{
				printf("\n\t");
				for (j=1;j<=i;j++)
				{
					printf("* ");
				}
			}
		starctr++;
	}
	for(i=1;i<=ilength;i++)
	{
		if (i%2!=0)
			{
				printf("\n\t");
				for (j=1;j<=(starctr);j++)
				{
					printf("* ");
				}
			}
		starctr--;
		if (starctr < -2) break;
	}
}
