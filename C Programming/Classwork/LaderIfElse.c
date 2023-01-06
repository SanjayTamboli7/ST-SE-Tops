#include <stdio.h>

void main()
	{
		int Roll_No, Marks_Physics, Marks_Chemistry, Marks_Maths, Total_Marks;
		char Student_Name[20];
		float Percent;
	
		printf("\n\t Roll No.        : ");
		scanf("%d", &Roll_No);
		printf("\n\t Student Name    : ");
		fflush(stdin);
		gets(Student_Name);
		printf("\n\t Physics Marks   : ");
		scanf("%d", &Marks_Physics);
		printf("\n\t Chemistry Marks : ");
		scanf("%d", &Marks_Chemistry);
		printf("\n\t Maths Marks : ");
		scanf("%d", &Marks_Maths);
		printf("\n\tRoll No. : %d", Roll_No);
		printf("\n\tStudent Name : %s", Student_Name);
		printf("\n\t Physics Marks   : %d", Marks_Physics);
		printf("\n\t Physics Marks   : %d", Marks_Chemistry);
		printf("\n\t Physics Marks   : %d", Marks_Maths);
		Total_Marks = Marks_Physics + Marks_Chemistry + Marks_Maths;
		printf("\n\tTotal Marks = %d", Total_Marks);
		Percent = (float)(Marks_Physics + Marks_Chemistry + Marks_Maths)/3;
		printf("\n\t Percentage      : %.2f", Percent);
		
		if (Percent>=75)
			{
				printf("\n\t Distinction");
			}
		else if (Percent>=60)
			{
				printf("\n\t First Class");
			}
			else if (Percent>=50)
				{
					printf("\n\t Second Class");
				}
				else if (Percent>=40)
					{
						printf("\n\t Pass Class");
					}
					else
						{
							printf("\n\t Fail...");
						}
						
						
				
	}