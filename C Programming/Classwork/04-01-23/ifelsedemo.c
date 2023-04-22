#include<stdio.h>

void main()
{
	int a=10;
	int b = 20;
	
	printf("\nA = %d, B = %d",a,b);
	
	if(a&&b)
	{
		printf("\nLine 1 is True");
	}
	else
	{
		printf("\nLine 2 is False");
	}
	b=10,a=10;
	if(a||b)
	{
		printf("\nLine 3 is True");
	}
	else
	{
		printf("\nLine 4 is False");
	}
	if(!(a&&b))
	{
		printf("\nLine 5 is True");
	}
	else
	{
		printf("\nLine 6 is False");
	}
	
}