#include <stdio.h>

void main()
{
	int marks[5], i;

	for(i=0;i<5;i++)
	{
		printf("\tEnter marks[%d] : ", i);
		scanf("%d", &marks[i]);
	}
	for(i=0;i<5;i++)
	{
		printf("\n\tMarks[%d] = %d", i, marks[i]);
	}
}