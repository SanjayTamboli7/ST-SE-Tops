#include<stdio.h>

void main()
{
	int arr1[3],arr2[3];
	int i;
	
	printf("\nEnter Array 1: \n\n");
	for(i=0;i<3;i++)
	{
		printf("Enter Element [%d] : ",i);
		scanf("%d",&arr1[i]);
	}
	
	printf("\nEnter Array 2: \n\n");
	for(i=0;i<3;i++)
	{
		printf("Enter Element [%d] : ",i);
		scanf("%d",&arr2[i]);
	}
	
	printf("\nArray 1: \n\n");
	for(i=0;i<3;i++)
	{
		printf("Element at Index [%d] = %d\n",i,arr1[i]);
	}
	
	printf("\nArray 2: \n\n");
	for(i=0;i<3;i++)
	{
		printf("Element at Index [%d] = %d\n",i,arr2[i]);
	}
	
	printf("\nAddition of Array1 and Array 2 : \n\n");
	for(i=0;i<3;i++)
	{
		printf("\nAddition[%d] : %d",i,(arr1[i]+arr2[i]));
	}
	
	
	
	
	
	
}