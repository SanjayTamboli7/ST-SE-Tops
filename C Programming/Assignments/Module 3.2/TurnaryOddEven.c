#include <stdio.h>

void main()
{
	int inum1;
	printf("\n\t Enter Number 1 : ");
	scanf("%d", &inum1);
	(inum1 % 2== 0)?printf("\n\t %d is even", inum1):printf("\n\t %d is odd", inum1);
}