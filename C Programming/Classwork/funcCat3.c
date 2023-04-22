#include<stdio.h>

/*
	Funcation Category 3rd.
	
	-with return-type and with argument.
	
	syntax :
	
			 return-type func-name(argument....)
			{
				return ;
			}


*/

int add(int d,int g)
{
	printf("\nInside UDF A = %d, B = %d",d,g);
	return d+g;
}


void main()
{
	int a=13,b=42,sum;
	sum = add(a,b);
	printf("\nAddition : %d",sum);
	if(sum%2==0)
	{
		printf("\nSum is Even.");
	}
	else
	{
		printf("\nSum is Odd.");
	}
}










