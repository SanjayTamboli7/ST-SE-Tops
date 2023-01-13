#include <stdio.h>

void main()
{
	int arr1[5], arr2[5], i;
	
	printf("\n\t Accept arr1 ");
	for(i=0;i<5;i++)
	{
		printf("\n\tEnter arr1[%d] : ", i);
		scanf("%d", &arr1[i]);
	}

	printf("\n\t Accept arr2 ");
	for(i=0;i<5;i++)
	{
		printf("\n\tEnter arr2[%d] : ", i);
		scanf("%d", &arr2[i]);
	}

	printf("\n\t Accept arr1 ");
	for(i=0;i<5;i++)
	{
		printf("\n\tarr1[%d] = %d", i, arr1[i]);
	}

	printf("\n\t Accept arr2 ");
	for(i=0;i<5;i++)
	{
		printf("\n\tarr1[%d] = %d", i, arr2[i]);
	}

	printf("\n\t Addition of arr1 and arr2 ");
	for(i=0;i<5;i++)
	{
		printf("\n\tarr1[%d] = %d", i, (arr1[i]+arr2[i]));
	}
}