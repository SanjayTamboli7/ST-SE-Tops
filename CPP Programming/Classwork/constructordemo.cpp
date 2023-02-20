#include<iostream>
using namespace std;

/*
	Constructor : It is a special method.
	
		Rules : 
				- Contructor name is same as the class-name,
				- No return-type in Constructor.
				- It is use to initialize the members of the class.
				
		Imp rule: -It is automatically called, when the object of 
					the class is created.
					
		There are 3 types of Contructors.
		
		1) Default Constructor/Parameterless Constructor
		
			syntax:
						class-name()
						{
							//piece of code
						}
			
		
		2) Parameterized Constructor
		
			syntax : 
			
					class-name(parameters......)
					{
						//piece of code
					}
		
		3) Copy Constructor	: Object as an Argument.
		
					class-name(const class-name &obj)
					{
						//piece of code
					}
			
		

*/

class Sample
{
	public:
		Sample()
		{
			cout<<"\nDefault Constructor Called.";			
		}
		
		void show()
		{
			cout<<"\nThis is Show Method";
		}
};


int main()
{
	Sample obj1;  //Object Creation
	obj1.show(); // Function Calling.
	
	return 0;
}



