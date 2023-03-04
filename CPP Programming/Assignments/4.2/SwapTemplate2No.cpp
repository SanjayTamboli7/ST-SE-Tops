#include <iostream>

using namespace std;

template <typename Tmpl>
Tmpl Swap(Tmpl a, Tmpl b)
	{
		a = a + b;
		b = a - b;
		a = a - b;
		
		cout << endl;
		cout << "\t Now x = " << a;
		cout << endl;
		cout << "\t Now y = " << b;
		return a+b;
	}

int main()
	{
		int x, y, z;
		
		cout << "\t Enter x = ";
		cin >> x;
		cout << "\t Enter y = ";
		cin >> y;

		z = Swap<int>(x, y);
  	
		return 0;
	}
