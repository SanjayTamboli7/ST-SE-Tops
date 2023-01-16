#include <stdio.h>

void main()
	{
		int i, j, num, val = 65;
		while(1)
			{
				printf("\n\t Enter Maximum Rows (7) : ");
				scanf("%d", &num);
				if (num<=7) break;
			}
			
		for(i=1;i<=num;i++)
			{			
				printf("\n\t");
				for(j=1;j<=i;j++)
					{
						printf("%c", val);
						if (val==90) break;
						val++;
					}
			}
	}