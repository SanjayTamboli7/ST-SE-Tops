#include<iostream>
using namespace std;

/*
	It is used for common memory management;
*/

class staticDemo
{
	public:
		static int objCount=0;
	
	staticDemo()
	{
		cout<<"\nDefault Constructor Called.";
		objCount++; // objCount = objCount+1
	}
		
};

//int staticDemo::objCount=0;

int main()
{
	staticDemo sd1,sd2,sd3;
	cout<<"\n\nObject Count : "<<sd1.objCount;	
	return 0;
}










