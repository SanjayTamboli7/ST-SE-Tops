#include <stdio.h>

void main()
	{
		int i, j, num;
		while(1)
			{
				printf("\n\t Enter Maximum Rows (26) : ");
				scanf("%d", &num);
				if (num<=26) break;
			}
			
		for(i=1;i<=num;i++)s
			{	
				int val = 65;
				printf("\n\t");
				for(j=1;j<=i;j++)
					{
						printf("%c", val);
						if (val==90) break;
						val++;
					}
			}
	}