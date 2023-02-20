#include<iostream>
using namespace std;

class Student
{
	public:
		string name;
		int rollno;
	void getName(string n)
	{
		name = n;
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
		sp = 48;
	}
};

class Result : public Student,public ExtraMarks
{
	public:
		int s1,s2,s3,tot;
		float per;
		
		Result(int p,int c,int m)
		{
			s1 = p;
			s2 = c;
			s3 = m;
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
	int phy,chem,maths;

	string name;
	cout<<"\nEnter your Name : ";
	getline(cin,name);
	cout<<"\nEnter Physics Marks : ";
	cin>>phy;
	cout<<"\nEnter Chemistry Marks : ";
	cin>>chem;
	cout<<"\nEnter Maths Marks : ";
	cin>>maths;
	Result res(phy,chem,maths);
	res.getName(name);		
	res.Display();
	
}





