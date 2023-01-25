#include <stdio.h>

int add(int n1, int n2)
	{
		return(n1+n2);
	}

int substract(int n1, int n2)
	{
		return(n1-n2);
	}

int multiply(int n1, int n2)
	{
		return(n1*n2);
	}

int division(int n1, int n2)
	{
		return(n1/n2);
	}

void main()
	{
		int num1, num2, choice=0;
		
		printf("\n\t Enter value for Num1 : ");
		scanf("%d", &num1);
		printf("\n\t Enter value for Num2 : ");
		scanf("%d", &num2);
		while(choice!=9)
		{
		printf("\n\t  Menu \n");
		printf("\n\t  1. Addition       ");
		printf("\n\t  2. Subtraction    ");
		printf("\n\t  3. Multiplication ");
		printf("\n\t  4. Division       ");
		printf("\n\t  9. Exit           ");	
		printf("\n\n\t  Your choice : ");
		scanf("%d", &choice);
		switch(choice)
			{
				case 1:
					printf("\n\t Addition is %d", add(num1, num2));
					break ;
				case 2:
					printf("\n\t Subtraction is %d", substract(num1, num2));
					break ;
				case 3:
					printf("\n\t Multiplication is %d", multiply(num1, num2));
					break ;
				case 4:
					printf("\n\t Division is %.2f", (float)(division(num1, num2)));
					break ;
				case 9:
					printf("\n\t Exit");
					break ;
				default :
				 	printf("\n\t Invalid choice");
					break ;
			}
		}		 
	}