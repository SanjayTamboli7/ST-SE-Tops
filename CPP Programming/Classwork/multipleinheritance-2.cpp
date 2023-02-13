#include<iostream>
using namespace std;
class Student
{
	public:
		string name;
		int rollno;
	void getName(string n, int rn)
	{
		name = n;
		rollno = rn;
	}
		
	Student()
	{
		rollno = 41;
	}		
};
class ExtraMarks
{
	public:
		int sp;
		
	ExtraMarks()
	{
		cout<<"\nEnter SP :";
		cin>>sp;
	}
};
class Result : public Student,public ExtraMarks
{
	public:
		int s1,s2,s3,tot;
		float per;
	Result(int phy, int chem, int bio)
		{
			s1 = phy;
			s2 = chem;
			s3 = bio;
			tot = s1+s2+s3+sp;
			per = (float)tot/4;
		}
		void Display()
		{
			cout<<"\nRoll No : "<<rollno;
			cout<<"\nName : "<<name;
			cout<<"\nTotal : "<<tot;
			cout<<"\nPercentage : "<<per;
		}		
};

int main()
{
	string name;
	int RollNu, phy, chem, bio, spc;
	cout<<"\nEnter your Name : ";
	getline(cin,name);
	cout << "Enter Roll Number : " ;
	cin >> RollNu;
	cout << "Enter Physics Marks : " ;
	cin >> phy;
	cout << "Enter Chemistry Marks : " ;
	cin >> chem;
	cout << "Enter Biology Marks : " ;
	cin >> bio;
//	cout << "Enter Special Marks : " ;
//	cin >> spc;
	Result res(phy, chem, bio);
	res.getName(name, RollNu);	
	res.Display();
}





