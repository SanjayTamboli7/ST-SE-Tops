#include<stdio.h>
/*
	ladder if/else:
	
	syntax :
				if(condition)
				{
					statement;
				}
				else if(condition)
				{
					statement;
				}
				else if(condition)
				{
					statement;
				}
				else if(condition)
				{
					statement;
				}
				else
				{
					statement;
				}

*/



void main()
{
	int rollno,s1,s2,s3,total;
	char name[20];
	float per;
	
	printf("\nEnter Roll.No : ");
	scanf("%d",&rollno);
	fflush(stdin);
	printf("Enter Name : ");
	//scanf("%s",&name);
	gets(name);
	printf("Enter Physics Marks : ");
	scanf("%d",&s1);
	printf("Enter Chemistry Marks : ");
	scanf("%d",&s2);
	printf("Enter Maths Marks : ");
	scanf("%d",&s3);
	
	printf("\nRoll No. %d",rollno);
	printf("\nName :  %s",name);
	total = s1+s2+s3;
	per = (float)total/3;
	printf("\nTotal : %d",total);
	printf("\nPercentage : %.2f",per);
	printf("\nClass : ");
	
	if(per>=75)
	{
		printf("Distinction");
	}
	else if(per>=60)
	{
		printf("First Class");
	}
	else if(per>=50)
	{
		printf("Second Class");
	}
	else if(per>=40)
	{
		printf("Pass Class");
	}
	else
	{
		printf("Fail!!");
	}
	
	
	
	
	
}














