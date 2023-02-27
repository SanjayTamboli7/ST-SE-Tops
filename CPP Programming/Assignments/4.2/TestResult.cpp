#include <iostream>

using namespace std;

class Student
	{
		public:

			int Roll_No;
			void SetRollNo(int _RollNo)
				{
					Roll_No = _RollNo;
				}

			int ReadRollNo()
				{
					return Roll_No;
				}
	};

class Test:public Student
	{
		public:
			int MarkSubject1, MarkSubject2;

			void SetMarks(int MarkSubject_1, int MarkSubject_2)
				{
					MarkSubject1 = MarkSubject_1;
					MarkSubject2 = MarkSubject_2;
				}			
			int ReadMark1()
				{
					return MarkSubject1;
				}
			int ReadMark2()
				{
					return MarkSubject2;
				}
	};

class Result:public Test
	{
		public:
			int TotalMark()
				{
					return MarkSubject1 + MarkSubject2;
				}
	};
	
int main()
	{
		int RollNumber;
		int Mark_Subject1, Mark_Subject2;
		Result objResult;

		cout << "Enter Roll Number : ";
		cin >> RollNumber;
		cout << "Enter Subject 1 Mark : ";
		cin >> Mark_Subject1;
		cout << "Enter Subject 2 Mark : ";
		cin >> Mark_Subject2;

		objResult.SetRollNo(RollNumber);
		objResult.SetMarks(Mark_Subject1, Mark_Subject2);
		cout << endl;
		cout << "Roll Number : " << objResult.ReadRollNo();
		cout << endl;
		cout << "Subject 1 Mark : " << objResult.ReadMark1();
		cout << endl;
		cout << "Subject 2 Mark : " << objResult.ReadMark2();
		cout << endl;
		cout << "Total Mark : " << objResult.TotalMark();

		return 0;
	}