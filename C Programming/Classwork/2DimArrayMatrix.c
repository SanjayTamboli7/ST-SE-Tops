#include <stdio.h>


void main()
	{
		int i, j, matrix1[3][3];
		printf("\n\t  \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 Enter values for 2 dim array \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\n");
		for(i=0;i<3;i++)
			{
				printf("\n");
				for(j=0;j<3;j++)
					{
						printf("\t  Enter at [%d][%d] : ", i, j);
						scanf("%d", &matrix1[i][j]);
					}
			}
		printf("\n\t\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2  Values display for 2 dim array \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\n");
		for(i=0;i<3;i++)
			{
				printf("\n");
				for(j=0;j<3;j++)
					{
						printf("\t\t%d", matrix1[i][j]);
					}
			}
		printf("\n");
	}

