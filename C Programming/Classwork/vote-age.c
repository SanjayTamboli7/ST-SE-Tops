#include <stdio.h>

void main()
 {
 	int IntAge ;
 	printf("\n\t Enter your age : ");
 	scanf("%d", &IntAge);
 	if (IntAge >= 18)
 		{
 			printf("\n\t You are eligible to vote");
		}
	else		
 		{
 			printf("\n\t You are not eligible to vote");
		}

 }