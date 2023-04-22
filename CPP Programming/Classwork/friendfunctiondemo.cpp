#include<iostream>
using namespace std;

/*
	In C++, the private members can only be accessed using
	 friend keyword.
*/


class Avinash
{
	private:
		int money;
		friend int Jyot(Avinash);
	public:
		Avinash()
		{
			money = 0;
			cout<<"Money is "<<money;	
		}	
};

int Jyot(Avinash obj)
{
	obj.money = 5000;
	return obj.money;
}

int main()
{
	Avinash avi;
	cout<<"\nMoney given to Jyot is Rs."<<Jyot(avi);
	return 0;
}