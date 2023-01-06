#include <stdio.h>

void main()
{
	int num1, num2, choice;
	printf("\n\t\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2 Choice Calculator \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2");
	printf("\n\t Enter A :");
	scanf("%d", &num1);
	printf("\n\t Enter B :");
	scanf("%d", &num2);
	printf("\n\t Enter A : %d", num1);
	printf("\n\t Enter B : %d", num2);
	printf("\n\t \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2");
	printf("\n\t Enter 1 for Addition");
	printf("\n\t Enter 2 for Subtraction");
	printf("\n\t Enter 3 for Multiplication");
	printf("\n\t Enter 4 for Divison");
	printf("\n\t \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2");
	printf("\n\t Enter Your Choice : ");
	scanf("%d", &choice);
	if (choice < 0 || choice > 4)
		{
			printf("\n\t Invalid choice");
		}
	else if(choice == 1)
		{
			printf("\n\t Addition : %d", (num1 + num2));
		}
		else if (choice == 2)
			{
				printf("\n\t Subtraction : %d", (num1 - num2));
			}
			else if (choice == 3)
				{
					printf("\n\t Multiplication : %d", (num1 * num2));
				}
				else if (choice == 4)
					{
						printf("\n\t Division : %.2f", (float)(num1 / num2));
					}
}