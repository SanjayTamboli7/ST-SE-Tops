#include <stdio.h>

/*

Display This Information using printf 
1. Your Name 
2. Your Birth date
3. Your Age 
4. Your Address

*/

char name[20] = "Sanjay R Tamboli";
char dob[20]  = "11-Dec-1964";
int  age      = 58;
char add[30]  = "Motera, Sabarmati, Ahmedabad";

void main()
 {
 	printf("\n\tYour       Name : %s", name);
	printf("\n\tYour Birth date : %s", dob);
	printf("\n\tYour        Age : %d", age);
	printf("\n\tYour    Address : %s", add);
 }