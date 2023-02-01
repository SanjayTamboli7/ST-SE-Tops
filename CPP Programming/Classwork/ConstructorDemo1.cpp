#include <iostream>

using namespace std;

class sample
	{
		public :
		sample()
			{
				cout << endl;
				cout << "Constructor called.";
			};
			
		void show()
			{
				cout << endl;
				cout << "show method called.";
			};
	};
	
int main()
	{
		sample sobj;
		sobj.show();
		return 0;
	}
