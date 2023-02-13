#include <iostream>

using namespace std;

// Abstract class example

class A
	{
		public:
			void msg()
				{
					cout << endl;
					cout << "Hello from class A";
				}
	};

class B: virtual public A
	{
	};
class C: virtual public A
	{
	};
class D: public B, public C
	{
	};

int main()
	{
		D obj;
		obj.msg();
		return 0;
	}