#include <iostream>

using namespace std;

class Distance
	{
		public:
			int feet, inche;
			
			Distance(int f, int i)
				{
					feet = f;
					inche = i;
				}
			Distance operator-()	
				{
					feet = -feet;
					inche = -inche;
					return Distance(feet, inche);
				}
			void Display()	
				{
					cout << endl;
					cout << "Feet = ";
					cout << feet;
					
					cout << endl;
					cout << "Inche = ";
					cout << inche;
				}
	};

int main()
	{
		Distance d1(10, 15);
		d1.Display();
		-d1;
		d1.Display();
	}