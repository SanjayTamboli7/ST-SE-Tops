#include <stdio.h>

/* Program using functions (subroutine) */ 

/* mul function declaration */

int mul(int a, int b);

/* main program starts */

void main()
{
	int a, b, c;
	a = 5;
	b = 10;
	c = mul(a, b);
	
	printf("\n Multiplication of %d and %d = %d", a, b, c);
}

/* main program ends */

/* mul function defination */

int mul(int x, int y)
{
	int p;
	
	p = x * y;
	return(p);
}

