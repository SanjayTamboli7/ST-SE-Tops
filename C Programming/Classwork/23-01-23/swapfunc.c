#include<stdio.h>

void Swap(int n1,int n2)
{
	int t;
	t = n1;
	n1 = n2;
	n2 = t;
	printf("\nIn Swap A = %d, B = %d",n1,n2);
}

void main()
{
	int a=45,b=54;
	printf("\nIn Main A = %d, B = %d",a,b);
	printf("\nStart Function");
	Swap(a,b);
	printf("\nStop Function");
}







