/* Innvestment Problem */

#define PERIOD 10
#define PRINCIPAL 5000.00
#define IntRate 0.11

/* Main Program Begins */

#include <stdio.h>
//#include <conio.h>

void main()
 {
		
	int year;
	float amount, value, inrate;

	/* Assignment statement */ 
	
	amount = PRINCIPAL;
	inrate = IntRate;
	year = 0;
	
	/* Computation statement */ 
	/* While loop starts */
	printf("\n|  Year\t|  Amount|");
	printf("\n|______\t|________|");
	while (year <= PERIOD)
		{
			printf("\n|%2d\t|%8.2f|", year, amount);
			value = amount + ( inrate * amount );
			year++;
			amount = value;
		}
	printf("\n|______\t|________|");
	/* While loop ends */
	/* Program ends */
 }