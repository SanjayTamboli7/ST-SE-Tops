#include <stdio.h>

void main()
	{
		char name[20];
		int  i=0, ln=0;

		printf("\n\t Enter name : ");
		gets(name);
		printf("\n\t Name is %s", name);
		
		while(1)
			{
				if(name[i]!='\0')
					{
						i++;
						ln++;
					}
				else
					{
						break;
					}
			}
		printf("\n\t Input length = %d", ln);
	}