#include <stdio.h>

void main()
	{
		int i, j, matrix1[3][3];
		
		for(i=0;i<3;i++)
			{
				for(j=0;j<3;j++)
					{
						printf("Enter element at [%d][%d] : ", i, j);
						scanf("%d", &matrix1[i][j]);
					}
			}
		for(i=0;i<3;i++)
			{	
				printf("\n");
				for(j=0;j<3;j++)
					{
						printf("You entered element at [%d][%d] : %d", i, j, matrix1[i][j]);
						printf("\t");
					}
			}
	}