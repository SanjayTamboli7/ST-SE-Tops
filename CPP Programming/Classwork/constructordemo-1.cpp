#include<iostream>
using namespace std;

class Box{
	public:
		double width,depth,height;
		
	Box()
	{
		cout<<"\nDefault Constructor Called.";
		width = 4;
		depth = 5;
		height = 3;		
	}
	
	Box(double w,double h,double d)
	{
		cout<<"\n\nParameterized Constructor Called.";
		width = w;
		height = h;
		depth = d;
	}	
	
	Box(const Box &tops)
	{
		cout<<"\n\nCopy Constructor Called.";
		width = tops.width;
		height = tops.height;
		depth = tops.depth;		
	}
	
	void volume()
	{
		cout<<"\nVolume of Box : "<<(width*height*depth);
	}
	
};


int main()
{
	Box b1;
	b1.volume();
	
	Box b2(5,7,3);
	b2.volume();	
	
	Box b3(4,6,8);
	b3.volume();
	
	Box b4(b1);
	b4.volume();
	
	return 0;
}















