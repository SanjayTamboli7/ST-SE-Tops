#include<stdio.h>

void main()
{
	int a,b,choice;
	printf("\n\n\t\t\xB2\xB2\xB2\xB2\xB2\xB2 Choice Calculator  \xB2\xB2\xB2\xB2\xB2\xB2\xB2\xB2");
	printf("\n\n\t\tEnter A : ");
	scanf("%d",&a);
	printf("\t\tEnter B : ");
	scanf("%d",&b);
	printf("\n\t\tA = %d, B = %d",a,b);
	printf("\n\t\t=================================");
	printf("\n\t\tPress 1. for Addition");
	printf("\n\t\tPress 2. for Subtraction");
	printf("\n\t\tPress 3. for Multiplication");
	printf("\n\t\tPress 4. for Division");
	printf("\n\t\t=================================\n");
	printf("\n\t\tEnter your choice ? ");	
	scanf("%d",&choice);
	
	if(choice==1)
	{
		printf("\n\t\tAddition : %d",(a+b));
	}
	else if(choice==2)
	{
		printf("\n\t\tSubtraction : %d",(a-b));
	}
	else if(choice==3)
	{
		printf("\n\t\tMultiplication : %d",(a*b));
	}
	else if(choice==4)
	{
		printf("\n\t\tDivision : %.2f",((float)a/b));
	}
	else
	{
		printf("\n\t\tInvalid Choice");
	}
	
	
}