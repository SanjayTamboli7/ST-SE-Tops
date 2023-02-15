#include <iostream>

using namespace std;

class Avinash
	{
		private:
			int money;
			friend int Jyot(Avinash objavi);
		public:
			Avinash()
				{
					money = 0;
					cout << endl;
					cout << "In Avinash Constructor Money = " << money;
				}
	};

int Jyot(Avinash objavi)
	{
		objavi.money = 5000;
		return objavi.money;
	}

int main()
	{
		Avinash objavi;
		
		cout << endl;
		cout << "Avinash borrowed " << Jyot(objavi);
		cout << " from Jyot";
		return 0;
	}
