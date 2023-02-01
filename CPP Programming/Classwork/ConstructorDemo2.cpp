#include <iostream>

using namespace std;

class sample 
	{
		
		string name;
		int age;
		
		public:
			sample()
				{
					cout << endl;
					cout << "\n\t Default (without parameter) constructor called.";
				}

			sample(string nm1, int ag1)
				{
					name = nm1;
					age = ag1;
					cout << endl;
					cout << "\n\t Constructor called with parameter .";
				}
			
			void show()
				{
				 	cout << endl;
				 	cout << "Name : " << name;
				 	cout << endl;
				 	cout << "Age : " << age;
				};
	};

int main()
	{
		string name;
		int age;
		
		sample obj1;
		cout << endl;
		cout << "Enter the name : ";
		getline(cin, name);
		cout << "Enter the age : ";
		cin >> age ;
		sample obj2(name, age);
		obj2.show();
		return 0;
	}