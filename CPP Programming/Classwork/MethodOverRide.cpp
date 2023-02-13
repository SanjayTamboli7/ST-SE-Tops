#include <iostream>

using namespace std;

class A
	{
		public:
			void show()
				{
					cout << endl ;
					cout << "Show from class A";
				}
	};

class B: public A
	{
		public:
			void show()
				{
					cout << endl;
					A::show();
					cout << endl ;
					cout << "Show from class B";
				}
	};
	
class C: public B
	{
		public:
			void 
			show()
				{
					cout << endl;
					B::show();
					cout << endl ;
					cout << "Show from class C";
				}	
	};
	
int main()
	{
		C obj;
		cout << endl ;
		obj.show();
		return 0;
	}