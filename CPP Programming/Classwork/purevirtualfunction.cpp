#include<iostream>
using namespace std;

/*
	Abstraction : 
	
	The internal implementation is hidden, and only the required things are visible.
	
	-Pure virtual function
		
		Only the method body is declared, it will not have the body
		
		e.g 	virtual void show();
		
		Its implementation will be given in that class, which it is inheriting it.
	
	

*/

class FanDemo
{
		public:
			
			virtual void OnButton();	// Pure Virtual Function
			void light()
			{
				cout<<"\nLight is ON.";	
			}			
};

class Start : public FanDemo{
	public:
		
		void AC()
		{
			cout<<"\nAC started.";
		}
		
		void OnButton()
		{
			cout<<"\nFan is Rotating.";
		}
};

int main()
{
	Start raj;
	raj.AC();
	raj.light();
	raj.OnButton();
	return 0;
}









