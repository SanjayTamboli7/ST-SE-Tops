#include <iostream>

using namespace std;

class side
	{
		protected:
			double l;
		public: 
			void getval(int x)
				{
					l = x;
				}
	};

class square : public side
	{
		public:
			int sqr()
				{
					return l*l;
				}
	};

class cube : public side
	{
		public:
			int cb()
				{
					return l*l*l;
				}
	};


int main()
	{
		int i;

		cout << endl;
		cout << "Enter value for i :";
		cin >> i;
		
		square sobj;
		sobj.getval(i);
		cout << endl;
		cout << "Square : ";
		cout << sobj.sqr();

		cube cobj;
		cobj.getval(i);
		cout << endl;
		cout << "Cube : ";
		cout << cobj.cb();

		return 0;
	}