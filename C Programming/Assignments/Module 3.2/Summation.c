#include <stdio.h>
#include <string.h>

void main()
	{
		char strnum[5];
		int i, inum[5], slen, summation=0;
		
		while(1)		
			{
				printf("\n\t Enter number (5 digit): ");
				gets(strnum);
				printf("\n\t %s", strnum);
				slen = strlen(strnum);
				printf("\n\t %d", slen);
				if(slen<=5) break;
			}
		
		for(i=0;i<=slen-1;i++)
			{
				inum[i] = strnum[i]-'0';
			 	printf("\n\t %c %d", strnum[i], inum[i]); 
				summation = summation + inum[i];
			}
		printf("\n\t Summation : %d", summation);
	}