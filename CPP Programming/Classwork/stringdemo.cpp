#include<iostream>
using namespace std;

int main()
{
	//char name[10]="tops";
	string fname;
	string lname;
	cout<<"\nEnter Fname : ";
	//cin>>name;
	getline(cin,fname);
	cout<<"\nFName is : "<<fname;
	lname = fname;
	cout<<"\nLName : "<<lname;
	cout<<"\nString Concatenate : "<<(fname+lname);
	int len = fname.size();
	cout<<"\nString Length is : "<<len;
	return 0;
}