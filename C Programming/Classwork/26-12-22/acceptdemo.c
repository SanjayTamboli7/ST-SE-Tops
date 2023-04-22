#include<stdio.h>

void main()
{
	int num1,num2;
	printf("\nEnter Number 1 : ");
	scanf("%d",&num1);
	printf("\nEnter Number 2 : ");
	scanf("%d",&num2);
		
	printf("Number1 = %d \nNumber2 = %d",num1,num2);
	//printf("\nNumber2 = %d",num2);
	printf("\nAddition : %d",(num1+num2));
	printf("\nSubtraction : %d",(num1-num2));
	printf("\nMultiplication : %d",(num1*num2));
	printf("\nDivision : %.2f",((float)num1/num2));	
}