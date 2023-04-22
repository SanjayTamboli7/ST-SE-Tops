#include<iostream>
using namespace std;

/*
	template : It is used as a Common Type.
	
			- It is Type Safety.
			
			syntax:
			
				template type
				function

*/
/*
int add(int a,int b)
{
	return a+b;
}

string concate(string n,string l)
{
	return n+l;
}

float add(float n1,float n2)
{
	return n1+n2;
}
*/

template <typename T>
T common(T a,T b)
{
	return a+b;
}

int main()
{
	cout<<"\nAdd using Int: "<<common<int>(54,7);
	cout<<"\nString Concatenation : "<<common<string>("abc","pqr");
	cout<<"\nAdd using Float: "<<common<float>(42.7f,7.9f);
	return 0;	
}