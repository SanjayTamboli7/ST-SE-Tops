#include<iostream>
using namespace std;
/*
	Scope Resolution Operator.
	
	::  -> It is use to acces the memebers of the class through outside.

*/


class Demo{
	public:		
		void func();	
		int add(int a,int b)
		{
			return a+b;
		}
		
		void evenOdd(int a);
		
};

void Demo::func()
{
	cout<<"\nFunction Implemented outside the class.";
}

void Demo::evenOdd(int a)
{
	if(a%2==0)
	{
		cout<<"\nIt is Even.";
	}
	else
	{
		cout<<"\nIt is Odd.";
	}
}


int main()
{
	Demo obj;
	obj.func();
	cout<<"\nAddition : "<<obj.add(5,2);
	int n;
	cout<<"\nEnter Number : ";
	cin>>n;
	obj.evenOdd(n);
	return 0;
}