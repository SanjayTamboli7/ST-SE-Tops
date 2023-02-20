#include <iostream>

using namespace std;

class Add
	{
		public:
			Add(double value1, double value2)
				{
					cout << endl;
					cout << "Addition Result = ";
					cout <<  value1 + value2;
				}
	};

class Subtract
	{
		public:
			Subtract(double value1, double value2)
				{
					cout << endl;
					cout << "Subtraction Result = ";
					cout <<  value1 - value2;
				}
	};

class Multiply
	{
		public:
			Multiply(double value1, double value2)
				{
					cout << endl;
					cout << "Multiply Result = ";
					cout <<  value1 * value2;
				}
	};

class Division
	{
		public:
			Division(double value1, double value2)
				{
					cout << endl;
					cout << "Division Result = ";
					cout <<  value1 / value2;
				}
	};

int main()
	{
		double value1, value2;

		cout << endl;
		cout << "Enter value 1 for calculation : ";
		cin >> value1;
		cout << "Enter value 2 for calculation : ";
		cin >> value2;

		Add AddObj(value1, value2);
		Subtract SubObj(value1, value2);
		Multiply MulObj(value1, value2);
		Division DivObj(value1, value2);
		
		return 0;
	}