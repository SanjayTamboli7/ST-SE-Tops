#include <stdio.h>
#include <string.h>

// find reverse of string using recursion.

void reversestr(char *str, int index, int n)
	{
		if(index == n)   			   // return if we reached at last index or at the end of the string
		    {
		        return;
		    }
		char temp = str[index]; 	  // storing each character starting from index 0 in function call stack;
    	reversestr(str, index+1, n); // calling recursive function by increasing index everytime
    	printf("%c", temp);          // printing each stored character while recurring back
	}

void main()
	{
		char name[20], length;
		
		printf("\n\t Enter Name : ");
		gets(name);
		length = strlen(name);
		reversestr(name, 0, length);
	}
