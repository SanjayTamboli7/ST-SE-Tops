#include<stdio.h>

void main()
{
	int marks[5];
	int i;
	
	for(i=0;i<5;i++)
	{
		printf("Enter Element[%d] : ",i);
		scanf("%d",&marks[i]);
	}
	printf("\n\n");
	for(i=0;i<5;i++)
	{
		printf("Element at Index [%d] = %d\n",i,marks[i]);
	}

}



