#include <stdio.h>

void swap(int x, int y)
	{
		int t ;
		t = x ;
		x = y ;
		y = t ;
		printf("\n\t In swap x = %d, y = %d", x, y);
		
	}

void main()
	{
		int a, b;
		printf("\n\t Enter value a : ");
		scanf("%d", &a);
		printf("\n\t Enter value b : ");
		scanf("%d", &b);
		printf("\n\t In Main a = %d, b = %d", a, b);
		printf("\n\t Starts swap");
		swap(a, b);
		printf("\n\t Stops swap");		
	}