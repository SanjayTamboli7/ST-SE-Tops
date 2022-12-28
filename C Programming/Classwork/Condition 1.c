#include <stdio.h>

void main()
 {
 	int a, b;
 	
 	printf("\n\t Enter value for A = ");
 	scanf("%d", &a);
 	printf("\n\t Enter value for B = ");
 	scanf("%d", &b);
 	if (a > 0)
		{
			printf("\n\t%d is positive value", a);
		}
 	else
		{
			printf("\n\t%d is negative value", a);
		} 	
	printf("\n\tControl is out of if block");
 }