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
		
		Result()
		{
			s1 = 75;
			s2 = 42;
			s3 = 64;
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
	Result res;
	string name;
	cout<<"\nEnter your Name : ";
	getline(cin,name);
	res.getName(name);	
	res.Display();
	
}





