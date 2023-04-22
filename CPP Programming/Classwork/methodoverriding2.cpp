#include<iostream>
using namespace std;
/*
	Method Overriding : 
	
	- Same return type.
	- Same function name.
	- Same Arguments.
	
	Method Signature should be same.

*/



class A{
	public:		
		void show()
		{
			cout<<"\nShow from A";
		}		
};

class B  : public A{
	public:		
	void show()
	{
		A::show();
		cout<<"\nShow from B";
	}
};

class C : public B{
	public:
		void show()
		{
			B::show();
			cout<<"\nShow from C";
		}
};
	

int main()
{
	/*
	A obj1;
	obj1.show();
	
	B obj2;
	obj2.show();
	*/
	C obj;
	obj.show();	
	return 0;
}
















