#include <iostream>

using namespace std;

int main()
	{
		string fname, lname, fullname;

		cout << endl;
		cout << "Enter first name : ";
		getline(cin, fname);

		cout << endl;
		cout << "Enter last name : ";
		getline(cin, lname);

		fullname = fname + " " + lname ;
		
		cout << endl;
		cout << fname;
		
		cout << endl;
		cout << lname;

		cout << endl;
		cout << fullname;
		
		cout << endl;
		cout << "Full name lenth is " << fullname.size();

	}