#include <stdio.h>

int findmaxinarray(int arnumf[10])
	{
		int i, maxnum=0;

		for(i=0;i<10;i++)
			{
				if(maxnum<arnumf[i])
					{
						maxnum = arnumf[i];
					}
			}
		return maxnum;
	}

void main()
	{
		int i, maxnum, arnum[10];
		
		for(i=0;i<10;i++)
			{
				printf("\n\t Enter value for arnum[%d] : ", i);
				scanf("%d", &arnum[i]);
			}
			
	}