#include <iostream>

using namespace std;

class area
	{
		// double area;
		public:
		double FindArea(int objtyp, int tb, int th)
			{
				switch (objtyp)
					{
						case 1:
							return tb * th * 0.5;
							break;
						case 2:
							return tb * th;
							break;
					}
			}
		double FindArea(int rad)
			{
				return 3.14 * rad * rad;
			}
	};

int main()
	{
		int TB, TH, RAL, RAW, Radius;
		area objarea;
		
		cout << endl;
		cout << "  Triangle base : ";
		cin >> TB;
		cout << "Triangle height : ";
		cin >> TH;

		cout << endl;
		cout << "Rectangle length : ";
		cin >> RAL;
		cout << " Rectangle width : ";
		cin >> RAW;

		cout << endl;
		cout << "   Circle radius : ";
		cin >> Radius;

		cout << "  Triangle area : " << objarea.FindArea(1, TB, TH);
		cout << " Rectangle area : " << objarea.FindArea(2, RAL, RAW);
		cout << "    Circle area : " << objarea.FindArea(Radius);

		return 0;
	}