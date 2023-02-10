#include <iostream>

using namespace std;

class MO
	{	
		public:
			void add()
				{
					int a, b;
					cout << endl;
					cout << "Enter value for A :";
					cin >> a;
					cout << "Enter value for B :";
					cin >> b;
					cout << endl;
					cout << "Addition is ";
					cout << (a+b);
				}
			void add(int a, int b)
				{
					cout << endl;
					cout << "Addition is 2 valuse : ";
					cout << (a+b);
				}
			int add(int a, int b, int c)
				{
					return (a+b+c);
				}
	};

int main()
	{
		MO objmo;
		objmo.add();
		objmo.add(12, 14);
		cout << endl ;
		cout << "Addition of 3 values : ";
		cout << objmo.add(12, 14, 16);
		return 0;
	}
