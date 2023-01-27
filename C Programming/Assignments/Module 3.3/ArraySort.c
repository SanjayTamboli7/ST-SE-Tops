#include <stdio.h>

void ArraySort(int num[10], char flag)
	{
		int i, j, tn;

		printf("\n\t flag %c", flag);
		if(flag=='A')
			{
				for(i=0;i<10;i++)
					{
						for(j=i+1;j<10;j++)
							{
								if(num[i]>num[j]) 
									{
										tn = num[i];
										num[i]=num[j];
										num[j]=tn;
									}
							}
					}
			}
		if(flag=='D')
			{
				for(i=0;i<10;i++)
					{
						for(j=i+1;j<10;j++)
							{
								if(num[i]<num[j]) 
									{
										tn = num[i];
										num[i]=num[j];
										num[j]=tn;
									}
							}
					}
			}
		for(i=0;i<10;i++)
			{
				printf("\t %d", num[i]);
			}
	}

void main()
	{
		int i, num1[10], num2[10], choice=0;
		printf("\t Enter data for first array\n")		;
		for(i=0;i<10;i++)
			{
				printf("\t Enter value for num1[%d] : ", i);
				scanf("%d", &num1[i]);
			}
		printf("\t Enter data for second array\n")		;
		for(i=0;i<10;i++)
			{
				printf("\t Enter value for num2[%d] : ", i);
				scanf("%d", &num2[i]);
			}		
		do
		{
			printf("\n\t 1. Sort array 1 in ascending");
			printf("\n\t 2. Sort array 1 in descending");
			printf("\n\t 3. Sort array 2 in ascending");
			printf("\n\t 4. Sort array 2 in descending");
			printf("\n\t 9. Exit");
			printf("\n\t Your choice : ");
			scanf("%d", &choice);
			switch(choice)
				{
					case 1:
						printf("\n\t choice is %d", choice);
						ArraySort(num1, 'A');
						break;
					case 2:
						printf("\n\t choice is %d", choice);
						ArraySort(num1, 'D');
						break;
					case 3:
						printf("\n\t choice is %d", choice);
						ArraySort(num2, 'A');
						break;
					case 4:
						printf("\n\t choice is %d", choice);
						ArraySort(num2, 'D');
						break;
					case 9:
						printf("\n\t choice is %d", choice);
						break;
					default:
						printf("\n\t Invalid choice");
						break;						
				}
		} while(choice!=9);
	}