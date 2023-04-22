#include<stdio.h>

/*
	In C , there are 32 reserved keywords.


	Datatypes : There are 4 datatypes
	
		int 		4 bytes				%d
		char		1 byte				%c
		float		4 bytes				%f
		double 		8 bytes				%lf
		
		long long	8 bytes				%ld
		string    char ar[size]  		%s 
		
		
	Variables :
					It is a name at memory location, which stores
					value of different types.
					
					Declaration of Variable.
					
						<data-type> <variable-name>;
						
						e.g int number1;
					
					Rules for declaring a Variable.
					
					1) 1st Character should not be a Digit.
					
						e.g int 1number;
						
					2) No blank space in the variable names.
					
						e.g int no 1; 
						
					3) No Special Symbol allowed.except _$
					
						e.g int number@  , char first_name;
					
					4) Variable names are case sensitive.
					
						e.g a is different than A.
						
					because it follows ASCII Rule.
					
					American Standard code for Information Interchange.			
					
	String : It is a collection of characters.
	
	char strname[size]
	
*/

void main()
{
	//printf("Hello Welcome to C Programming");
	int no = 29;
	char ch = 'u';
	float per = 58.78;
	double stock = 7899987789.45454545;
	char name[10]="tops tec";
	char mobile[12] = "9594789787";
		
	printf("%d\n",no);
	printf("%c\n",ch);
	printf("%.2f",per);
	printf("\n%lf",stock);
	printf("%s\n",name);
	printf("%s",mobile);
	
	
	
}










