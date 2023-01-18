#include <stdio.h>

void main()
	{
		int i, j, matrix1[3][3], matrix2[3][3];
		
		printf("\n\t  \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 Enter values for Matrix 1 \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\n");
		for(i=0;i<3;i++)
			{
				for(j=0;j<3;j++)
					{
						printf("\t Enter value for [%d][%d] : ", i, j);
						scanf("%d", &matrix1[i][j]);
					}
			}
		printf("\n\t  \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 Enter values for Matrix 2 \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\n");
		for(i=0;i<3;i++)
			{
				for(j=0;j<3;j++)
					{
						printf("\t Enter value for [%d][%d] : ", i, j);
						scanf("%d", &matrix2[i][j]);
					}
			}
		printf("\n\t  \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 Print values for Matrix 1 \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\n");
		for(i=0;i<3;i++)
			{
				printf("\n");
				for(j=0;j<3;j++)
					{
						printf("\t%d", matrix1[i][j]);
					}
			}
		printf("\n\t  \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 Print values for Matrix 1 \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\n");
		for(i=0;i<3;i++)
			{
				printf("\n");
				for(j=0;j<3;j++)
					{
						printf("\t%d", matrix2[i][j]);
					}
			}
		printf("\n\t  \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 Print Addition of Matrixs \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\n");
		for(i=0;i<3;i++)
			{
				printf("\n");
				for(j=0;j<3;j++)
					{
						printf("\t%d", (matrix1[i][j])+matrix2[i][j]);
					}
			}
	}