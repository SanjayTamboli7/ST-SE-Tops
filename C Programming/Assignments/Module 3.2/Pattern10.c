#include <stdio.h>

void main()
	{
		int i, j, num;
		printf("\n\t Enter Maximum Rows : ");
		scanf("%d", &num);
		
		for(i=1;i<=num;i++)
			{			
				char ch1 = '1', ch0='0', lastch='1';
				printf("\n\t");
				for(j=1;j<=i;j++)
					{
						printf("%c", lastch);
						if(lastch=='1') lastch='0';
						else lastch='1';
					}
			}
	}