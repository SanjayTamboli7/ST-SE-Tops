#include <stdio.h>


void revstr() 
{
    char c;								
    scanf("%c", &c);													//accepting the input from user		
    if (c != '\n') 														//condition for further opertaion if c is char and not a new line then it will proceed further 
	{
        revstr();														//calling the function in itself (recursion)
        printf("%c", c);												//printing the output one by one letter as we have used the char data type 
    }																	//it will work with only one char at the time
}


void main() 
{
   	printf("Enter a sentence: ");										//showing msg for user to input the string	
    revstr();															//calling the function
    
}
