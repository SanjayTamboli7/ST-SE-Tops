#include <iostream>
#include <string>

using namespace std;

class Twords
	{
		public:

			string Word1, Word2, JoinWord;

			Twords()
				{
					cout << endl;
					cout << " Enter First Word : ";
					cin >> Word1;
					cout << "Enter Second Word : ";
					cin >> Word2;
				}
			Twords operator+()
				{
					cout << "Before join word";
					JoinWord="";
					JoinWord = JoinWord + Word1 + " " + Word2;
					cout << "After join word";
				}
			DisplayTwords()
				{
					cout << endl;
					cout << " First Word : " << Word1;
					cout << "Second Word : " << Word2;
					cout << "Joined Word : " << JoinWord;
				}
	};

int main()
	{
		Twords ObjTwords;
		+ObjTwords;
		ObjTwords.DisplayTwords();
		return 0;
	}