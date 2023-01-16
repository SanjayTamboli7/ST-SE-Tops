#include <stdio.h>

void main()
	{
		int i, j, t, rollno[5];
		printf("\n");
		for(i=0;i<5;i++)
			{
				printf("\t Enter value for rollno[%d] : ", i);
				scanf("%d", &rollno[i]);
			}
		printf("\t =================== Before sort ==================");
		for(i=0;i<5;i++)
			{
				printf("\n\t Enter value for rollno[%d] : %d", i, rollno[i]);
			}
		for(i=0;i<5;i++)
			{
				for(j=i+1;j<5;j++)
				if (rollno[i]<rollno[j])
					{
						t = rollno[i];
						rollno[i] = rollno[j];
						rollno[j] = t;
					}
			}
		printf("\n\t =================== Ascentding order ==================");
		for(i=0;i<5;i++)
			{
				printf("\n\t Enter value for rollno[%d] : %d", i, rollno[i]);
			}
		for(i=0;i<5;i++)	
			{
				for(j=i+1;j<5;j++)
					{
						if(rollno[i]>rollno[j])
							{
								t = rollno[i];
								rollno[i]=rollno[j];
								rollno[j]=t;							
							}
					}
			}
		printf("\n\t =================== Descentding order ==================");
		for(i=0;i<5;i++)
			{
				printf("\n\t Enter value for rollno[%d] : %d", i, rollno[i]);
			}
	}
	