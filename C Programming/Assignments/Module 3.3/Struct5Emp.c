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
		struct employee emp[5];
		int i;	

		for(i=0;i<5;i++)
			{
				printf("\n\t Enter employee No. : ");
				scanf("%d", &emp[i].empno);
				fflush(stdin);
				printf("\t Enter employee Name : ");
				gets(emp[i].empname);
				fflush(stdin);
				printf("\t Enter employee Address : ");
				gets(emp[i].empaddress);
				printf("\t Enter employee Age: ");
				scanf("%d", &emp[i].age);
			}
		for(i=0;i<5;i++)
			{
				printf("\n\t Employee No. : %d", emp[i].empno);
				printf("\n\t Employee Name : %s", emp[i].empname);
				printf("\n\t Employee Address : %s", emp[i].empaddress);
				printf("\n\t Employee Age: %d", emp[i].age);
			}
	}