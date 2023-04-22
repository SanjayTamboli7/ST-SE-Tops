#include<stdio.h>
/*

	Array : It is a name at Memory location,which stores 
	        values of same data type in a contigous memory.
	    
	syntax :  <data-type>  array-name[size];
	
			e.g int marks[5];
	
	Array index starts from 0.
	

*/



void main()
{
	int arr1[5]={15,75,78,14,36};
	int i;
	/*
	printf("%d\t",arr1[0]);
	printf("%d\t",arr1[1]);
	printf("%d\t",arr1[2]);
	printf("%d\t",arr1[3]);
	printf("%d\t",arr1[4]);
	*/
	
	for(i=0;i<5;i++)
	{
		printf("%d\t",arr1[i]);
	}
	
	
	
	
	
}









