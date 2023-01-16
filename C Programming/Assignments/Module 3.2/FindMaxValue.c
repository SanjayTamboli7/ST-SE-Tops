#include <stdio.h>

void main()
{
	int i, num1, maxval=0;
	printf("\n\t Enter the maximum number : ");
	scanf("%d", &num1);
	int num2[num1];
	printf("\n\tCreated an array of size %d\n", sizeof(num2) / sizeof(num2[0]));
	for(i=0;i<num1;i++)
		{
			printf("\t Enter Num2[%d] : ", i);
			scanf("%d", &num2[i]);
			if (maxval<num2[i]) maxval = num2[i];
		}
	printf("\n\t Maximum value is %d", maxval);
}