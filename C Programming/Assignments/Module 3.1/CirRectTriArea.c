#include<stdio.h>
/*

This program finds area of rectangle, triangle, circle.

*/
void main()
{
	// Declare variables 
	
	int length, width, base, height, radius;

	// Accept legngth & width
	printf("\n\t Enter Length of rectangle (CMS) : ");
	scanf("%d", &length);	
	printf("\n\t  Enter Width of rectangle (CMS) : ");
	scanf("%d", &width);	
	// Accept base & Height
	printf("\n\t    Enter Base of triangle (CMS) : ");
	scanf("%d", &base);	
	printf("\n\t  Enter Heigth of triangle (CMS) : ");
	scanf("%d", &height);	
	// Accept radius
	printf("\n\t          Radius of circle (CMS) : ");
	scanf("%d", &radius);	
	printf("\n\t         Area of rectangle (CMS) : %d", length * width);
	printf("\n\t          Area of triangle (CMS) : %.2f", (float)(0.5 * base * height));
	printf("\n\t            Area of circle (CMS) : %.2f", (float)(3.14 * radius * radius));
}