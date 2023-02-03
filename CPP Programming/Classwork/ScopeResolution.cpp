#include <iostream>

/*
	This is scope resolution example.
*/

using namespace std;

class box
	{
		public:
			void volume();
	};

void box::volume()
	{	
		cout << endl;
		cout << "In volume function....";
		cout << endl;
	}

int main()
	{
		box b1;
		b1.volume();
	}