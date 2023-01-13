#include <stdio.h>

void main()
{
	int i, j, ilength, spacectr;
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
	spacectr = (ilength-1)/2 ;
	for(i=1;i<=ilength;i++)
	{
		if (i%2!=0)
			{
				printf("\n\t");
				for (j=1;j<=((ilength-i)/2);j++)
				{
					printf(" ");
				}	
				for (j=1;j<=i;j++)
				{
					printf("*");
				}
				if (spacectr % 2 != 0)  
				{
					spacectr--;
				}
			}

	}
}