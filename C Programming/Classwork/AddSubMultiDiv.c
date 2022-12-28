#include <stdio.h>

void main()
 {
 	int Num1 = 50;
 	int Num2 = 10;
 	
 	printf("\n\t Num1 = %d", Num1);
 	printf("\n\t Num2 = %d", Num2);
 	printf("\n\t Addition       = %d",   (Num1 + Num2));
 	printf("\n\t Substraction   = %d",   (Num1 - Num2)); 
 	printf("\n\t Multiplication = %d",   (Num1 * Num2));
 	printf("\n\t Divsion        = %.2f", float(Num1 / Num2));
 	return 0;
 }