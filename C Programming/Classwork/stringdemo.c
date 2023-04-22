#include<stdio.h>
#include<string.h>

/*
	String : It is a collection of characters.
	
	String Declaration in C.
		
		char name[size];
		
	- string terminates with \0.
*/


void main()
{
	/*
	char name[20];
	printf("Enter Name : ");
	//scanf("%s",&name);
	gets(name);
	printf("Name : %s",name);
	*/
	
	char str1[10]="Tops";
	char str2[10]="Tech";
	char str3[20];
	char str4[10] = "zoo";
	char str5[10]= "zoo";
	
	printf("\nString Length : %d",strlen(str1));
	printf("\nString Concatenation : %s",strcat(str1,str2));
	printf("\nString Reverse : %s",strrev(str2));
	//str3 = str2;
	strcpy(str3,str2);
	printf("\nString Copy : %s",str3);
	printf("\nString in UpperCase : %s",strupr(str1));
	printf("\nString in UpperCase : %s",strlwr(str3));
	
	/*
		strcmp : it returns 1 if s1 > s2 , returns -1 if s1<s2 , returns 0 if s1==s2
	*/
	
	printf("\nString Comparison : %d",strcmp(str4,str5));
	
	
	
}





