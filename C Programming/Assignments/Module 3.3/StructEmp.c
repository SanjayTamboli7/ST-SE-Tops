#include <stdio.h>

/*
Write a program of structure employee that provides the following
information -print and display empno, empname, address and age
*/

struct employee
	{
		int empno, age;
		char empname[20];
		char empaddress[30];			
	};

void main()
	{
		struct employee emp;
		
		printf("\n\t Enter employee No. : ");
		scanf("%d", &emp.empno);
		fflush(stdin);
		printf("\t Enter employee Name : ");
		gets(emp.empname);
		fflush(stdin);
		printf("\t Enter employee Address : ");
		gets(emp.empaddress);
		printf("\t Enter employee Age: ");
		scanf("%d", &emp.age);

		printf("\n\t Employee No. : %d", emp.empno);
		printf("\n\t Employee Name : %s", emp.empname);
		printf("\n\t Employee Address : %s", emp.empaddress);
		printf("\n\t Employee Age: %d", emp.age);

	}