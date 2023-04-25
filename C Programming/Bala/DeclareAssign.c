#include <stdio.h>

void main()
{
	/* Declarations */
	float 		x, p;
	double 		y, q;
	unsigned 	k;
	
	/* Declarations & Assignments */
	int m = 54321;
	long int n = 1234567890;
	
	/* Assignments */
	x = 1.234567890000;
	y = 9.87654321;
	k = 54321;
	p = q = 1.0;
	
	/* Printing */
	printf("\n\tm = %d", m);
	printf("\n\tn = %ld", n);
	printf("\n\tx = %.12lf", x);
	printf("\n\tx = %f", x);
	printf("\n\ty = %.12lf", y);
	printf("\n\ty = %lf", y);
	printf("\n\tk = %u p = %f q = %.12lf", k, p, q);
}