#include <iostream>

using namespace std;

class sample
	{
		public:
			int a=10, b;
					
			void getb(int c)
				{
					cout << endl;
					b = c;
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
		int b;
		cout << endl;
		cout << "Value of a is ";
		cout << s1.a;
		cout << endl;
		cout << "Enter value for b : ";
		cin >> b;
		s1.getb(b);
		s1.Displayb();
		return 0;
	}