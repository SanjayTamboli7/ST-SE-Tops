#include <iostream>

using namespace std;

inline double multiply(double val1, double val2)
	{
		return val1 * val2;
	}

inline double cube(double val)
	{
		return val * val * val;
	}

int main()
	{
		double value1, value2;

		cout << endl;
		cout << "Enter value 1 for multiplication : ";
		cin >> value1;
		cout << "Enter value 2 for multiplication : ";
		cin >> value2;
		cout << "Multiplication Result = " << multiply(value1, value2) << endl;
		cout << "Enter value cube : ";
		cin >> value1;
		cout << "Cube Result = " << cube(value1) << endl;

		return 0;
	}