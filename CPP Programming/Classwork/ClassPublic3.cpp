#include <iostream>

using namespace std;

class sample
	{
		public:

			string name;
					
			void getname(string name1)
				{
					name = name1;
				}
			void putname()	
				{
					cout << endl;
					cout << "Name is ";
					cout << name;
				}
	};

int main()
	{
		sample s1;
		string name;

//		cout << endl;
//		cout << "Enter Name : ";
//		cin >> name; // for one word
//		s1.getname(name);
//		s1.putname();

		cout << endl;
		cout << "Enter Name 2 : ";
		getline(cin, name); // for full statement
		s1.getname(name);
		s1.putname();

		return 0;
	}