#include <stdio.h>
#include <string.h>

void main()
	{
		char iname[20], oname[20];

		printf("\n\t Enter name : ");
		gets(iname);
		strcpy(oname, iname);
		strrev(oname);
		printf("\n\t iname = %s, oname = %s", iname, oname);
		if(strcmp(iname, oname)==0)
			printf("\n\tstring is palindrome");
		else
			printf("\n\tstring is not palindrome");
	}