#include<stdio.h>

/*
	union : It is similar like structure, which is use to store multiple values
	        of multiple types.
	        
	        syntax : 
	        
	        	union union-name
	        	{
	        		//data-members
	        	};
	        	
	 - It accepts the value at once and after display at once.
	 -Union size will be the highest size of its data-member.
*/

union Student
{
	int sid;
	char name[20];
	float per;	
};

void main()
{
	union Student s1;
	
	printf("\nEnter Student Id : ");
	scanf("%d",&s1.sid);
	printf("Student Id : %d",s1.sid);
	printf("\n\nEnter Student Name : ");
	scanf("%s",&s1.name);
	printf("Student Name : %s",s1.name);
	printf("\n\nEnter Percentage : ");
	scanf("%f",&s1.per);
	printf("Student Percentage : %.2f",s1.per);

	
	printf("\nSize of Union is %d Bytes",sizeof(s1));

}









