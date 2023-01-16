#include <stdio.h>

void main()
	{
		int i, j, num, val = 1;
		while(1)
			{
				printf("\n\t Enter Maximum Rows (25) : ");
				scanf("%d", &num);
				if (num<=25) break;
			}
			
		for(i=1;i<=num;i++)
			{			
				printf("\n\t");
				for(j=1;j<=i;j++)
					{
						printf("%d ", val);
						val++;
					}
			}
	}