#include<stdio.h>

void evenodd()
{
	int n;
	printf("\nEnter No.");
	scanf("%d",&n);
	
	if(n%2==0)
	{
		printf("\nEven No.");
	}
	else
	{
		printf("\nOdd No.");
	}	
}

void MaxofTwo()
{
	int n1=2,n2=4;
	
	if(n1>n2)
	{
		printf("\n%d is Greater",n1);
	}
	else
	{
		printf("\n%d is Greater",n2);
	}
}


void main()
{
	evenodd();
	MaxofTwo();
}








