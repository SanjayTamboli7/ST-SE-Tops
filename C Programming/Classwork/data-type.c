#include <stdio.h>

int age = 58;
char char1 = 'S';
float per = 56.65;
double stock = 2345678901.34567890;
char inst_name[10] = "Tops-Tech";
char mobile[12] = "9825098250";

void main()
 {
	printf("\n\t%d", age);
	printf("\n\t%c", char1);
	printf("\n\t%.2f", per);
	printf("\n\t%lf", stock);
	printf("\n\t%s",inst_name);
	
	printf("\n\t%s", mobile);
 }