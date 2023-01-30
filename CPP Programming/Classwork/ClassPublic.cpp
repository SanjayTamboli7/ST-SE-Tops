#include <iostream>

using namespace std;

class sample
	{
		public:
			int a=10, b;
					
			void getb()
				{
					cout << endl;
					cout << "Enter b :";
					cin >> b;
					return;
				}
			void Displayb()	
				{
					cout << endl;
					cout << "Value of b is ";
					cout << b;
					return;
				}
	};

int main()
	{
		sample s1;
		cout << endl;
		cout << "Value of a is ";
		cout << s1.a;
		s1.getb();
		s1.Displayb();
		return 0;
	}