#include <stdio.h>

void main()
{
    int x, y;

	printf("\n\t Enter x = ");
	scanf("%d", &x);
	printf("\n\t Enter y = ");
	scanf("%d", &y);

    printf("\n\t Before Swapping: x = %d, y = %d", x, y);

    x = x + y; 
    y = x - y; 
    x = x - y; 

    printf("\n\t After Swapping: x = %d, y = %d", x, y);
 }