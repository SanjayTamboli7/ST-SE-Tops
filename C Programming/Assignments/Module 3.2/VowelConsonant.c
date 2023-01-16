#include <stdio.h>   
#include <ctype.h>

void main() 
{
	char ch, chs[10];

//	printf("\n\t Enter any characters : ");
//	scanf("%s", &chs);
//	printf("\n\t %s", chs);

	printf("\n\t Enter any character : ");
	scanf("%c", &ch);
	ch = toupper(ch);
	switch(ch)
	{
		case 'A':
			printf("\n\t Vowel");
			break;
		case 'E':
			printf("\n\t Vowel");
			break;
		case 'I':
			printf("\n\t Vowel");
			break;
		case 'O':
			printf("\n\t Vowel");
			break;
		case 'U':
			printf("\n\t Vowel");
			break;
		default:
			printf("\n\t Consonant");
			break;
	}
}