#include<iostream>
using namespace std;

/*
	Access specifiers : It is use for the visibility of the class members.
	
	In C++, there are 3 access specifiers
	
	1) public. : it is accessible within or outside the class.	
	
	2) private. : it is accessible only within the class.
	
	3) protected. : it is accessible within the class and to the class which is inheriting it.
	
	- In C++, By default the members inside the class are private


*/

class Sample
{
	public:
		int a;	
		
		void getA(int x)
		{
			a = x;
		}
		
		void putA()
		{
			cout<<"\nA = "<<a;
		}
};


int main()
{
	Sample h1; 
	//cout<<h1.a;
	h1.getA(50);
	h1.putA();	
	return 0;
}










