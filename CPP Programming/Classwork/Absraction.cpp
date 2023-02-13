#include <iostream>

using namespace std;

class FanDemo
	{
		public:
			virtual void OnButton(); // Pure vitual function
			void light()
				{
					cout << endl;
					cout << "Light is on";
				}
	};

class Start: public FanDemo
	{
		public:
			void ac()
				{
					cout << endl;
					cout << "Ac started";
				}
			void OnButton()
				{
					cout << endl;
					cout << "Fan is rotating";
				}
	};
	
int main()
	{
		Start obj;
		obj.ac();
		obj.light();
		obj.OnButton();
		return 0;
	}