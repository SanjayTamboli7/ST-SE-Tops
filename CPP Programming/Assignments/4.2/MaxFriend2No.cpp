#include <iostream>

using namespace std;

class AssignValues
	{
		private:
			int value1, value2;
			friend void FindMax(AssignValues ObjAssignVal);
			
		public:
			void AssignVal( int value_1, int value_2 )
				{
					value1 = value_1;
					value2 = value_2;
					cout << endl << "value 1 : " << value1;
					cout << endl << "value 2 : " << value2;
					cout << endl;
				}
	};

void FindMax(AssignValues ObjAssignVal)
	{
		cout << endl;
		if (ObjAssignVal.value1>ObjAssignVal.value2)
			{
				cout << ObjAssignVal.value1;
			}
		else	
			{
				cout << ObjAssignVal.value2;
			}
		cout << " is greater.";	
	}
	
int main()
	{
		int x, y;
		AssignValues ObjAssignVal;

		cout << "\t Enter x = ";
		cin >> x;
		cout << "\t Enter y = ";
		cin >> y;
		ObjAssignVal.AssignVal(x, y);
		FindMax(ObjAssignVal);
		return 0;
	}