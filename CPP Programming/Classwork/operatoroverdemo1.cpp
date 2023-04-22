#include<iostream>
using namespace std;


class Distance
{
	public:
		int feet,inches;
	
		Distance(int f,int i)
		{
			feet = f;
			inches = i;
		}
		
		Distance operator-()
		{
			feet = -feet;
			inches = -inches;
			return Distance(feet,inches);
		}
		
		void Display()
		{
			cout<<"\nFeet : "<<feet<<"\nInches : "<<inches;
			
		}
		
};


int main()
{
	Distance d1(5,-7);
	d1.Display();
	-d1;
	d1.Display();
	
	return 0;
}