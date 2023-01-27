#include <stdio.h>

union employee
	{
		int   empid;
		char  empname[20];
		float empsal;
	};

void main()
	{
		union employee emp;
		
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
