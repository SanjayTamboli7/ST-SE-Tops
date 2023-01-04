#include<stdio.h>
/*

This program finds simple interest.

Simple Interest = (P x T x R)/100 
Where, 
P is the principal amount 
T is the time and 
R is the rate
*/
void main()

{
	// Variable declaration 
	
	int Principalamt;
	int Period; 
	int Rate;

	printf("\n\t Principal Amount : ");
	scanf("%d", &Principalamt);
	printf("\n\t     Time (Month) : ");
	scanf("%d", &Period);
	printf("\n\tRate (Percentage) : ");
	scanf("%d", &Rate);
	printf("\n\n\t  Interest       : %.2f", (float)(Principalamt * Period * Rate) / 100);
}