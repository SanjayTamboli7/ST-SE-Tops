#include<stdio.h>

/*
	Structure : It is used to store Multiple elements of
			    Multiple types.
			    
	syntax : 	struct structure-name
				{
					//data members;
				};

*/

struct Employee
{
	int eid;
	char name[20];
	float salary;
};


void main()
{	
	struct Employee e1;
	printf("\nEnter Employee Id : ");
	scanf("%d",&e1.eid);
	printf("Enter Name : ");
	scanf("%s",&e1.name);
	printf("Enter Salary : ");
	scanf("%f",&e1.salary);
	
	printf("\nEmployee Id : %d",e1.eid);
	printf("\nEmployee Name : %s",e1.name);
	printf("\nEmployee Salary : %.2f",e1.salary);
	
	printf("\nSize of Structure is %d Bytes",sizeof(e1));
	
}







