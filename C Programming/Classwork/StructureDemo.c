#include <stdio.h>

struct student 
	{
		int id;
		char name[30];
		float per;
	};

void main()
	{
		struct student stud;
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
	}