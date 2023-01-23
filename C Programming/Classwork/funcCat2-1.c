#include <stdio.h>

void add(int x, int y)
	{
		printf("\n\t In add function");
		printf("\n\t x = %d, y = %d", x, y);	
	}

void main()
	{
		int a, b;

		printf("\n\t Enter value for a : ");
		scanf("%d", &a);
		printf("\n\t Enter value for b : ");
		scanf("%d", &b);
		printf("\n\t In main function");
		printf("\n\t a = %d, b = %d", a, b);
		printf("\n\t starts add function");
		add(a, b);
		printf("\n\t ends add function");
		
	}