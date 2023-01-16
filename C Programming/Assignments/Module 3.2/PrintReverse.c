#include <stdio.h>
#include <string.h>

void main()
	{
		char num1[5], num2[5];
		printf("\n\t Enter number : ");
		gets(num1);
		strrev(num1);
		printf("%s", num1);		
	}