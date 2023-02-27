#include <iostream>

using namespace std;

class Matrix
	{
		public:
			
			int i, Num1[5], Num2[5], MatrixTotal[5];

			Matrix()
				{
					cout << endl;
					for(i=0;i<5;i++)
						{
							cout << "Enter Num1[%d] : ";
							cin >> Num1[i];
							cout << "Enter Num2[%d] : ";
							cin >> Num2[i];
						}
				}
			Matrix operator+()
					
				{	
					for(i=0;i<5;i++)
					{
						MatrixTotal[i] = Num1[i] + Num2[i];
					}					
				}
			DisplayMatrix()
				{
					cout << endl;
					cout << "M1" << "\t"<< "M2" << "\t"<< "Tot";
					for(i=0;i<5;i++)
						{
							cout << endl;
							cout << Num1[i]	<< "\t" << Num2[i] << "\t" << MatrixTotal[i];
						}					
				}
	};

int main()
	{
		Matrix ObjMatrix;
		+ObjMatrix;
		ObjMatrix.DisplayMatrix();
		return 0;
	}