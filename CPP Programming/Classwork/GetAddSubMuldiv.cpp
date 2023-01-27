#include <iostream>

using namespace std;

int main()
	{
		int a , b ;

		cout << endl << "a = ";
		cin >> a;
		cout << endl << "b = ";
		cin >> b;

		cout << endl << "Addition       = " << (a+b);
		cout << endl << "Subtraction    = " << (a-b);
		cout << endl << "Multiplication = " << (a*b);
		cout << endl << "Division       = " << (float)(a/b);

		return 0;
	}