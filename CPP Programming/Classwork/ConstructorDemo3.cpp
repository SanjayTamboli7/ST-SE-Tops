#include <iostream>

using namespace std;

class box
	{
		public:
			
		int width, height, depth;
		
		box()
			{
				cout << endl;
				cout << "Default constructor called.";
				width = 4;
				height = 5;
				depth = 6;
			};
		 box(int wid, int hei, int dep)
			{
				cout << endl;
				cout << "Parameter constructor called.";
				width = wid;
				height = hei;
				depth = dep;
			};
		box(const box &bx)
			{
				cout << endl;
				cout << "Copy constructor called.";
				width = bx.width;
				height = bx.height;
				depth = bx.depth;
			};
		void volume()
			{
				cout << endl;
				cout << "In volume function";
				cout << endl;
				cout << (width * height * depth);
				cout << endl;
			};
	};

int main()
	{
		box b1;
		b1.volume();		

		box b2(2, 3, 4);
		b2.volume();		

		box b3(b1);
		b3.volume();

		box b4(b2);
		b4.volume();
		
		return 0;
	}