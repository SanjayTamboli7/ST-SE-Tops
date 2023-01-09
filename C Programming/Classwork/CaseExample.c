#include <stdio.h>

void main()
{
	int a, b, choice;
	printf("\n\t Enter a : ");
	scanf("%d", &a);
	printf("\n\t Enter b : ");
	scanf("%d", &b);
	printf("\n\t a = %d	b = %d", a,  b);
	printf("\n\t Enter 1 to add");
	printf("\n\t Enter 2 to subtract");
	printf("\n\t Enter 3 to multiply");
	printf("\n\t Enter 4 to divison");
	printf("\n\t Enter your choice :");
	scanf("%d", &choice);
	switch(choice)
	{
		case 1: 
			printf("Addition = %d", (a+b));
			break;
		case 2:
			printf("Subtraction = %d", (a-b));
			break;
		case 3:
			printf("Multiplication = %d", (a*b));
			break;
		case 4:
			printf("Divison = %.2f", (float)a/b);
			break;
		default:
			printf("\n\t Invalid choice...");
			break;
	}	
}