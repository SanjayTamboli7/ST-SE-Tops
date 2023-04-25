/* Program using cosine function */

#include <stdio.h>
#include <math.h>

#define PI 3.1416
#define MAX 180

void main()
{
	int 	angle;
	float 	x, y;
	angle = 0;
	
	printf("\n\tAngle\tCos(Angle)");
	
	while(angle <= MAX)
		{
			x = (PI/MAX)*angle;
			y = cos(x);
			printf("\n\t%15d\t%13.4f", angle, y);
			angle = angle + 10;
		}
}