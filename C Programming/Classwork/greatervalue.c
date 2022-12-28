#include <stdio.h>

void main()
 {
 	int a, b;
 	
 	printf("\n\t Enter value for A = ");
 	scanf("%d", &a);
 	printf("\n\t Enter value for B = ");
 	scanf("%d", &b);
 	if (a > b)
		{
			printf("\n\t%d is greater than b", a);
		}
 	else
		{
			printf("\n\t%d is greater than a", b);
		} 	
	printf("\n\tControl is out of if block");
 }