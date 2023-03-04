#include <iostream>

using namespace std;

class ShowVal
	{
		private:
			int value1, value2;
			friend void swap(ShowVal ObjShowVal);

		public:
			void AssignValues(int val1, int val2)
				{
					value1 = val1;
					value2 = val2;
				}
	};

void swap(ShowVal ObjShowVal)
	{
		ObjShowVal.value1 = ObjShowVal.value1 + ObjShowVal.value2;
		ObjShowVal.value2 = ObjShowVal.value1 - ObjShowVal.value2;
		ObjShowVal.value1 = ObjShowVal.value1 - ObjShowVal.value2;
		
		cout << endl;
		cout << "\t Now x = " << ObjShowVal.value1;
		cout << endl;
		cout << "\t Now y = " << ObjShowVal.value2;
	}

int main()
	{
		int x, y;
		ShowVal ObjShowVal;
		
		cout << "\t Enter x = ";
		cin >> x;
		cout << "\t Enter y = ";
		cin >> y;

		ObjShowVal.AssignValues(x, y);
    	swap(ObjShowVal);
  	
		return 0;
	}
