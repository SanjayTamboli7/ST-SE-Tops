#include<iostream>
using namespace std;

/*
	Method Overloading : 
		
		It should have the following rules.
		
		- Different Parameters		
		- Same Name as Function Name
		- Different return types.
		
		syntax:
		
				<return-type> function_name(arguments)
				{
					//piece of code
				}
				
		e.g 	void sample()
				{
					//
				}
				
				int sample(int a)
				{
					return ;
				}
		


*/


class MO
{
	public:
		
		void add()
		{
			int a,b;
			cout<<"\nEnter A , B: ";
			cin>>a>>b;
			cout<<"\nAddition : "<<(a+b);			
		}
		
		void add(int a,int b)
		{
			cout<<"\nAddition From Main() : "<<(a+b);
		}
		
		int add(int x,int y, int z)
		{
			return x+y+z;
		}
};

int main()
{
	MO obj;
	obj.add();
	obj.add(5,4);
	cout<<"\nAdd : "<<obj.add(6,3,2);
	return 0;
}







