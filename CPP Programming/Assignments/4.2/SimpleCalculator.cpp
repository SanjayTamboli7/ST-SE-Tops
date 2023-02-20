#include <iostream>

using namespace std;

int Addition(int a, int b)
	{
		return (a+b);
	}

int Subtraction(int a, int b)
	{
		return (a-b);
	}

int Multiplication(int a, int b)
	{
		return (a*b);
	}

float Division(int a, int b)
	{
		return (a/b);
	}

int menu(int choice)
	{
		system("cls");
		cout << endl;
		cout << "*********Menu********";
		cout << endl;
		cout << "* 1. Addition       *";
		cout << endl;
		cout << "* 2. Subtraction    *";
		cout << endl;
		cout << "* 3. Multiplication *";
		cout << endl;
		cout << "* 4. Division       *";
		cout << endl;
		cout << "* 9. Exit           *";
		cout << endl;
		cout << "*********************"; 
		cout << endl;
		cout << "  Your choice : ";
		cin  >> choice;

		return choice;	
	}

int main()
	{
		int a, b, choice=0;
		char ch;

		while(choice<=4)
			{
				choice=menu(choice);
				cout << endl;
				if(choice<=4)
					{
						cout << "a = ";
						cin >> a;
						cout << "b = ";
						cin >> b;
					}
				switch(choice)
					{
						case 1:
							cout << Addition(a, b);
							sleep(3);
							break;
						case 2:
							cout << Subtraction(a, b);
							sleep(3);
							break;
						case 3:
							cout << Multiplication(a, b);
							sleep(3);
							break;
						case 4:
							cout << Division(a, b);
							sleep(3);
							break;
						case 9:
							break;
						default:
							cout << "Invalid choice";
							sleep(3);
							break;
					}			
			}
		return 0;
	}