#include <stdio.h>
void swap(int *x, int *y)
	{
		int tmp;
		tmp = *x;
		*x = *y;
		*y = tmp;
	}

void main()
	{
		int a = 5, b = 15;
		
		printf("\n\t Value of A = %d, B = %d", a, b);
		swap(&a, &b);
		printf("\n\t Value of A = %d, B = %d", a, b);
	}