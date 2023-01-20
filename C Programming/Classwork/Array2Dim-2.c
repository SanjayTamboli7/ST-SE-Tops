#include <stdio.h>

void main()
	{
		int i, j, arr1[3][2] = {{10, 20}, {30, 40}, {50, 60}};
		
//		printf("\n\t %d", arr1[0][0]);
//		printf("\t   %d", arr1[0][1]);
//
//		printf("\n\t %d", arr1[1][0]);
//		printf("\t   %d", arr1[1][1]);
//
//		printf("\n\t %d", arr1[2][0]);
//		printf("\t   %d", arr1[2][1]);
		for(i=0;i<3;i++)
			{
				printf("\n");
				for(j=0;j<2;j++)
					{
						printf("\%d\t", arr1[i][j]);
					}
			}
	}