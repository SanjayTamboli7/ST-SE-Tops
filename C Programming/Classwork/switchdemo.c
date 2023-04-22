#include<stdio.h>

/*
switch(input)
{
	case char: statement
			  break;
	case char: statement
			  break;
	case char: statement
			  break;
	case char: statement
			  break;
	case char: statement
			  break;
	default : statement;
			  break;
	
}
*/

void main()
{
	int a,b,choice;
	printf("Enter A : ");
	scanf("%d",&a);
	printf("Enter B : ");
	scanf("%d",&b);
	printf("\nA = %d, B = %d",a,b);
	printf("\n\nPress 1.Add\nPress 2.Subtract\nPress 3.Multiply\nPress 4.Division");
	printf("\nEnter your choice ?");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:printf("\nAddition : %d",(a+b));
			   break;
		case 2:printf("\nSubtract : %d",(a-b));
			   break;
		case 3:printf("\nMultiply : %d",(a*b));
			   break;
		case 4:printf("\nDivision : %.2f",((float)a/b));
			   break;
		default:printf("\nInvalid Choice");
		       break;
	}
	
	
	
}








