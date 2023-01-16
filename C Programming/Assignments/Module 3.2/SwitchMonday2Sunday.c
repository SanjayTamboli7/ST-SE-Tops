#include <stdio.h>   

void main()   
{
	int iWeekDay;
	while(1)
	{
		printf("\n\t Enter Week Day (0-Exit): ");
		scanf("%d", &iWeekDay);
		if(iWeekDay==0) break;
		switch(iWeekDay)
		{
			case 1:
				printf("\n\t Monday");
				break;
			case 2:
				printf("\n\t Tuesday");
				break;
			case 3:
				printf("\n\t Wednesday");
				break;
			case 4:
				printf("\n\t Thursday");
				break;
			case 5:
				printf("\n\t Friday");
				break;
			case 6:
				printf("\n\t Saturday");
				break;
			case 7:
				printf("\n\t Sunday");
				break;
			default:
				printf("\n\t Invalid input");
				break;
				
		}
	}
}
