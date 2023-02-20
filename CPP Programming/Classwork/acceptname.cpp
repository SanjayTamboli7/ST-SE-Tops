#include<iostream>

using namespace std;


class Name{
	public:
		string name;
		void getName(string n)
		{			
			name = n;
		}
		
		void putName()
		{
			cout<<"\nYour Name is : "<<name;	
		}		
};

int main()
{
	Name n; // Object Creation.
	string name;
	cout<<"\nEnter Name : ";
	getline(cin,name);
	n.getName(name);
	n.putName();
	
	return 0;
}






