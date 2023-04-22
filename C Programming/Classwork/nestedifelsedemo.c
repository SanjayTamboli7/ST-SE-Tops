#include<stdio.h>
/*

Nested if/else:

	syntax : 
				if(condition)
				{
					if(condition)
					{
						statement
					}
					else
					{
						statement
					}
				}
				else
				{
					if(condition)
					{
						statement
					}
					else
					{	
						statement
					}
				}
	
	

*/



void main()
{
	int a,b,c;
	printf("\nEnter A : ");
	scanf("%d",&a);
	printf("\nEnter B : ");
	scanf("%d",&b);
	printf("\nEnter C : ");
	scanf("%d",&c);
	
	printf("\nA = %d,B = %d,C = %d",a,b,c);
	
	if(a>b)
	{
		if(a>c)
		{
			printf("\nA is Greater.");
		}
		else
		{
			printf("\nC is Greater");
		}
	}
	else
	{
		if(b>c)
		{
			printf("\nB is Greater");
		}
		else
		{
			printf("\nC is Greater");
		}
		
	}
	
}




