#include <iostream>

using namespace std;

class OverLoadMathOps
	{
		public:
			int MathOperation(int a, int b, int c, int d, int e)
				{
					return a+b+c+d+e;
				}
			int MathOperation(int a, int b, int c, int d)
				{
					return a*b*c*d;
				}
			int MathOperation(int a, int b, int c)
				{
					return a-b-c;
				}
			double MathOperation(int a, int b)
				{
					return a/b;
				}
	};

int main()
	{
		int val1, val2, val3, val4, val5;
		OverLoadMathOps ObjOLMO;

		cout << endl;
		cout << "Ener value 1 : ";
		cin >> val1;
		cout << "Ener value 2 : ";
		cin >> val2;
		cout << "Ener value 3 : ";
		cin >> val3;
		cout << "Ener value 4 : ";
		cin >> val4;
		cout << "Ener value 5 : ";
		cin >> val5;

		cout << "      Addition of 5 values : " << ObjOLMO.MathOperation(val1, val2, val3, val4, val5);
		cout << endl;
		cout << "Multiplication of 4 values : " << ObjOLMO.MathOperation(val1, val2, val3, val4);
		cout << endl;
		cout << "  Substraction of 3 values : " << ObjOLMO.MathOperation(val1, val2, val3);
		cout << endl;
		cout << "      Division of 2 values : " << ObjOLMO.MathOperation(val1, val2);
		cout << endl;
		
		return 0;
	}