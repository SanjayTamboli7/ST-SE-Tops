#include<stdio.h>

void main()
{
	int age;
	char name[10];
	float salary;
	
	printf("\n\n\t\t\xB2\xB2\xB2\xB2\xB2\xB2 Accept Personal Details \xB2\xB2\xB2\xB2\xB2");
	printf("\n\n\t\tEnter your Name : ");
	scanf("%s",&name);
	fflush(stdin);
	printf("\t\tEnter your Age : ");
	scanf("%d",&age);
	printf("\t\tEnter your Salary : ");
	scanf("%f",&salary);
	printf("\n\n\t\t\xB2\xB2\xB2\xB2\xB2\xB2 Show Personal Details \xB2\xB2\xB2\xB2\xB2");
	printf("\n\t\t Name : %s",name);
	printf("\n\t\t Age : %d",age);
	printf("\n\t\t Salary : %.2f",salary);
	
	
	
	
	
}