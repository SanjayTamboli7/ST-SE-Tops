#include <stdio.h>

struct student 
	{
		int id;
		char name[30];
		float per;
	};

union employee
	{
		int   empid;
		char  empname[20];
		float empsal;
	};
	
void main()
	{
		struct student stud;
		union employee emp;

		printf("\n\t Structre demo");
		printf("\n\t Enter Student id      : ");
		scanf("%d", &stud.id);
		fflush(stdin);
		printf("\n\t Enter Student name    : ");
		gets(stud.name);
		printf("\n\t Enter Student percent : ");
		scanf("%f", &stud.per);

		printf("\n\t Student id      : %d", stud.id);
		printf("\n\t Student name    : %s", stud.name);
		printf("\n\t Student percent : %.2f", stud.per);

		printf("\n\t Union demo");
		printf("\n\t Enter Employee ID : ");
		scanf("%d", &emp.empid);
		fflush(stdin);
		printf("\n\t Employee  ID = %d", emp.empid);
		printf("\n\t Enter Employee Name : ");
		gets(emp.empname);
		printf("\n\t Employee Name : %s", emp.empname);
		printf("\n\t Enter Employee Salary : ");
		scanf("%f", &emp.empsal);
		printf("\n\t Employee Salary : %.2f", emp.empsal);

		
	}