#include <iostream>

using namespace std;

class person
	{
		public:
			string name;
			int age;
			void SetPersonData(string nm, int ag)
				{
					name = nm;
					age = ag;
				}
			string ReadPersonName()
				{
					return name;
				}
			int ReadPersonAge()
				{
					return age;
				}
	};
class student:public person
	{
		public: 
			double _percent;
			void SetStudentData(double percent)
				{
					_percent = percent;
				}
			double ReadStudentData()
				{
					return _percent;
				}
	};
class salary:public person
	{
		public:
			int _salary;
			void SetSalaryData(int salary)
				{
					_salary = salary;
				}
			int ReadSalaryData()
				{
					return _salary;
				}
	};
int main()
	{
		string person_name;
		int person_age, salary1;		
		double percent;
		person prsnobj;
		student studobj;
		salary salaryobj;
		cout << endl;
		cout << "Enter person name : ";
		getline(cin, person_name);
		cout << "Enter person age  : ";
		cin >> person_age;
		prsnobj.SetPersonData(person_name, person_age);
		cout << "Enter percentage  : ";
		cin >> percent;
		studobj.SetStudentData(percent);
		cout << "Enter salary  : ";
		cin >> salary1;
		salaryobj.SetSalaryData(salary1);
		cout << endl;
		cout << "Person Name       : " << prsnobj.ReadPersonName();
		cout << endl;
		cout << "Person Age        : " << prsnobj.ReadPersonAge();
		cout << endl;
		cout << "Person Percentage : " << studobj.ReadStudentData();
		cout << endl; 
		cout << "Person Salary     : " << salaryobj.ReadSalaryData();
		return 0;
	}