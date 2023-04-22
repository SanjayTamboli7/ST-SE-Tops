#include<stdio.h>

/*
	2) Function with no-return type and with arguments
	
	syntax : 
	
				return-type func_name(arguments.....)
				{
					//piece of code.
				}

*/

void add(int x,int y)
{
	printf("\nInside UDF X = %d, Y = %d",x,y);
	printf("\nAddition : %d",(x+y));
}

void main()
{	
	int a=10,b=20;
	printf("\nInside Main A = %d, B = %d",a,b);
	printf("\nStart Function");
	add(a,b);
	printf("\nStop Function");	
}






