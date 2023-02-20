#include <iostream>

using namespace std;

class FanDemo
	{
		public:
			virtual void OnButton(); // Pure vitual function
			void light()
				{
					cout << endl;
					cout << "Light is on";
				}
	};

class Start: public FanDemo
	{
		public:
			void ac()
				{
					cout << endl;
					cout << "Ac started";
				}
			void OnButton() // Function definition
				{
					cout << endl;
					cout << "Fan is rotating";
				}
	};
	
int main()
	{
		Start obj;
		obj.ac();
		obj.light();
		obj.OnButton();
		return 0;
	}#include<iostream>

using namespace std;


class Name{
	public:
		string name;
		void getName(string n)
		{			
			name = n;
		}
		
		void putName()
		{
			cout<<"\nYour Name is : "<<name;	
		}		
};

int main()
{
	Name n; // Object Creation.
	string name;
	cout<<"\nEnter Name : ";
	getline(cin,name);
	n.getName(name);
	n.putName();
	
	return 0;
}






#include<iostream>
using namespace std;

int main()
{
	int a,b;
	cout<<"Enter the value of A : ";
	cin>>a;
	cout<<"\nEnter the value of B : ";
	cin>>b;
	cout<<"\nAddition : "<<(a+b);
	cout<<"\nSubtraction : "<<(a-b);
	cout<<"\nMultiplication : "<<(a*b);
	cout<<"\nDivision : "<<((float)a/b);
	
	return 0;
}




#include <iostream>

using namespace std;

int main()
	{
		int a = 20, b = 10;
		cout << endl << "a              = " << a ;
		cout << endl << "b              = " << b ;
		cout << endl << "Addition       = " << (a+b);
		cout << endl << "Subtraction    = " << (a-b);
		cout << endl << "Multiplication = " << (a*b);
		cout << endl << "Division       = " << (float)(a/b);
		return 0;
	}#include<iostream>
using namespace std;

/*
	Access specifiers : It is use for the visibility of the class members.
	
	In C++, there are 3 access specifiers
	
	1) public. : it is accessible within or outside the class.	
	
	2) private. : it is accessible only within the class.
	
	3) protected. : it is accessible within the class and to the class which is inheriting it.
	
	- In C++, By default the members inside the class are private


*/

class Sample
{
	public:
		int a;	
		
		void getA(int x)
		{
			a = x;
		}
		
		void putA()
		{
			cout<<"\nA = "<<a;
		}
};


int main()
{
	Sample h1; 
	//cout<<h1.a;
	h1.getA(50);
	h1.putA();	
	return 0;
}










#include<iostream>
using namespace std;

class Demo
{
	public:
		void hello()
		{
				
		}	
};

int main()
{
	return 0;
}#include <iostream>

using namespace std;

class sample
	{
		public:
			int a=10, b;
					
			void getb()
				{
					cout << endl;
					cout << "Enter b :";
					cin >> b;
					return;
				}
			void Displayb()	
				{
					cout << endl;
					cout << "Value of b is ";
					cout << b;
					return;
				}
	};

int main()
	{
		sample s1;
		cout << endl;
		cout << "Value of a is ";
		cout << s1.a;
		s1.getb();
		s1.Displayb();
		return 0;
	}#include <iostream>

using namespace std;

class sample
	{
		public:
			int a=10, b;
					
			void getb(int c)
				{
					cout << endl;
					b = c;
					return;
				}
			void Displayb()	
				{
					cout << endl;
					cout << "Value of b is ";
					cout << b;
					return;
				}
	};

int main()
	{
		sample s1;
		int b;
		cout << endl;
		cout << "Value of a is ";
		cout << s1.a;
		cout << endl;
		cout << "Enter value for b : ";
		cin >> b;
		s1.getb(b);
		s1.Displayb();
		return 0;
	}#include <iostream>

using namespace std;

class sample
	{
		public:

			string name;
					
			void getname(string name1)
				{
					name = name1;
				}
			void putname()	
				{
					cout << endl;
					cout << "Name is ";
					cout << name;
				}
	};

int main()
	{
		sample s1;
		string name;

//		cout << endl;
//		cout << "Enter Name : ";
//		cin >> name; // for one word
//		s1.getname(name);
//		s1.putname();

		cout << endl;
		cout << "Enter Name 2 : ";
		getline(cin, name); // for full statement
		s1.getname(name);
		s1.putname();

		return 0;
	}#include<iostream>
using namespace std;

class Box{
	public:
		double width,depth,height;
		
	Box()
	{
		cout<<"\nDefault Constructor Called.";
		width = 4;
		depth = 5;
		height = 3;		
	}
	
	Box(double w,double h,double d)
	{
		cout<<"\n\nParameterized Constructor Called.";
		width = w;
		height = h;
		depth = d;
	}	
	
	Box(const Box &tops)
	{
		cout<<"\n\nCopy Constructor Called.";
		width = tops.width;
		height = tops.height;
		depth = tops.depth;		
	}
	
	void volume()
	{
		cout<<"\nVolume of Box : "<<(width*height*depth);
	}
	
};


int main()
{
	Box b1;
	b1.volume();
	
	Box b2(5,7,3);
	b2.volume();	
	
	Box b3(4,6,8);
	b3.volume();
	
	Box b4(b1);
	b4.volume();
	
	return 0;
}















#include<iostream>
using namespace std;

/*
	Constructor : It is a special method.
	
		Rules : 
				- Contructor name is same as the class-name,
				- No return-type in Constructor.
				- It is use to initialize the members of the class.
				
		Imp rule: -It is automatically called, when the object of 
					the class is created.
					
		There are 3 types of Contructors.
		
		1) Default Constructor/Parameterless Constructor
		
			syntax:
						class-name()
						{
							//piece of code
						}
			
		
		2) Parameterized Constructor
		
			syntax : 
			
					class-name(parameters......)
					{
						//piece of code
					}
		
		3) Copy Constructor	: Object as an Argument.
		
					class-name(const class-name &obj)
					{
						//piece of code
					}
			
		

*/

class Sample
{
	public:
		Sample()
		{
			cout<<"\nDefault Constructor Called.";			
		}
		
		void show()
		{
			cout<<"\nThis is Show Method";
		}
};


int main()
{
	Sample obj1;  //Object Creation
	obj1.show(); // Function Calling.
	
	return 0;
}



#include <iostream>

using namespace std;

class sample
	{
		public :
		sample()
			{
				cout << endl;
				cout << "Constructor called.";
			};
			
		void show()
			{
				cout << endl;
				cout << "show method called.";
			};
	};
	
int main()
	{
		sample sobj;
		sobj.show();
		return 0;
	}
#include <iostream>

using namespace std;

class sample 
	{
		
		string name;
		int age;
		
		public:
			sample()
				{
					cout << endl;
					cout << "\n\t Default (without parameter) constructor called.";
				}

			sample(string nm1, int ag1)
				{
					name = nm1;
					age = ag1;
					cout << endl;
					cout << "\n\t Constructor called with parameter .";
				}
			
			void show()
				{
				 	cout << endl;
				 	cout << "Name : " << name;
				 	cout << endl;
				 	cout << "Age : " << age;
				};
	};

int main()
	{
		string name;
		int age;
		
		sample obj1;
		cout << endl;
		cout << "Enter the name : ";
		getline(cin, name);
		cout << "Enter the age : ";
		cin >> age ;
		sample obj2(name, age);
		obj2.show();
		return 0;
	}#include <iostream>

using namespace std;

class box
	{
		public:
			
		int width, height, depth;
		
		box()
			{
				cout << endl;
				cout << "Default constructor called.";
				width = 4;
				height = 5;
				depth = 6;
			};
		 box(int wid, int hei, int dep)
			{
				cout << endl;
				cout << "Parameter constructor called.";
				width = wid;
				height = hei;
				depth = dep;
			};
		box(const box &bx)
			{
				cout << endl;
				cout << "Copy constructor called.";
				width = bx.width;
				height = bx.height;
				depth = bx.depth;
			};
		void volume()
			{
				cout << endl;
				cout << "In volume function";
				cout << endl;
				cout << (width * height * depth);
				cout << endl;
			};
	};

int main()
	{
		box b1;
		b1.volume();		

		box b2(2, 3, 4);
		b2.volume();		

		box b3(b1);
		b3.volume();

		box b4(b2);
		b4.volume();
		
		return 0;
	}#include <iostream>

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
							break;
						case 2:
							cout << Subtraction(a, b);
							break;
						case 3:
							cout << Multiplication(a, b);
							break;
						case 4:
							cout << Division(a, b);
							break;
						case 9:
							break;
						default:
							cout << "Invalid choice";
							break;
					}			
			}
		return 0;
	}#include<iostream>
using namespace std;

class Side{
	protected:
		double l;
	public:
		void getVal(int x)
		{
			l = x;
		}		
};

class Square : public Side
{
	public:
			int sqr()
			{
				return l*l;
			}	
};

class Cube : public Side
{
	public:
		int cu()
		{
			return l*l*l;
		}
};

int main()
{
	int a,b;
	cout<<"\nEnter Value for Square : ";
	cin>>a;
	
	Square obj;
	obj.getVal(a);
	cout<<"\nSquare is "<<obj.sqr();
	
	cout<<"\nEnter Value for Cube : ";
	cin>>b;
	Cube cb;
	cb.getVal(b);
	cout<<"\nCube is : "<<cb.cu();
	
	return 0;
}













#include<iostream>
using namespace std;

class Side{
	protected:
		double l;
	public:
		void getVal(int x)
		{
			l = x;
		}		
};

class Square : public Side
{
	public:
			int sqr()
			{
				return l*l;
			}	
};

class Cube : public Side
{
	public:
		int cu()
		{
			return l*l*l;
		}
};

int main()
{
	int a,b;
	cout<<"\nEnter Value for Square : ";
	cin>>a;
	
	Square obj;
	obj.getVal(a);
	cout<<"\nSquare is "<<obj.sqr();
	
	cout<<"\nEnter Value for Cube : ";
	cin>>b;
	Cube cb;
	cb.getVal(b);
	cout<<"\nCube is : "<<cb.cu();
	
	return 0;
}













#include <iostream>

using namespace std;

class side
	{
		protected:
			double l;
		public: 
			void getval(int x)
				{
					l = x;
				}
	};

class square : public side
	{
		public:
			int sqr()
				{
					return l*l;
				}
	};

class cube : public side
	{
		public:
			int cb()
				{
					return l*l*l;
				}
	};


int main()
	{
		int i;

		cout << endl;
		cout << "Enter value for i :";
		cin >> i;
		
		square sobj;
		sobj.getval(i);
		cout << endl;
		cout << "Square : ";
		cout << sobj.sqr();

		cube cobj;
		cobj.getval(i);
		cout << endl;
		cout << "Cube : ";
		cout << cobj.cb();

		return 0;
	}#include <iostream>

using namespace std;

// Abstract class example

class A
	{
		public:
			void msg()
				{
					cout << endl;
					cout << "Hello from class A";
				}
	};

class B: virtual public A
	{
	};
class C: virtual public A
	{
	};
class D: public B, public C
	{
	};

int main()
	{
		D obj;
		obj.msg();
		return 0;
	}/*
	inheritance : It is a feature in OOP, 
				 where a derived-class/child-class/sub-class acquires
				 the properties of the base-class/parent-class/super-class.
				 
	simple-practical def : It is creating a new class from an already
							existing class.
							
				- Code Reusability
				
	Important point : In Inheritance, object will always be created of 
					  derived class.
					  
	There are 5 types of Inheritance
	
	1) Single-level Inheritance
	2) Multi-level Inheritance
	3) Hierarchical -level Inheritance
	4) Multiple-level Inheritance
	5) Hybrid-level Inheritance
	
	
	
	
	
	
	
	
	
	
	
					  
					  
					  
	
				 
	

*/
#include <iostream>

using namespace std;

class MO
	{	
		public:
			void add()
				{
					int a, b;
					cout << endl;
					cout << "Enter value for A :";
					cin >> a;
					cout << "Enter value for B :";
					cin >> b;
					cout << endl;
					cout << "Addition is ";
					cout << (a+b);
				}
			void add(int a, int b)
				{
					cout << endl;
					cout << "Addition is 2 valuse : ";
					cout << (a+b);
				}
			int add(int a, int b, int c)
				{
					return (a+b+c);
				}
	};

int main()
	{
		MO objmo;
		objmo.add();
		objmo.add(12, 14);
		cout << endl ;
		cout << "Addition of 3 values : ";
		cout << objmo.add(12, 14, 16);
		return 0;
	}
#include <iostream>

using namespace std;

class A
	{
		public:
			void show()
				{
					cout << endl ;
					cout << "Show from class A";
				}
	};

class B: public A
	{
		public:
			void show()
				{
					cout << endl;
					A::show();
					cout << endl ;
					cout << "Show from class B";
				}
	};
	
class C: public B
	{
		public:
			void 
			show()
				{
					cout << endl;
					B::show();
					cout << endl ;
					cout << "Show from class C";
				}	
	};
	
int main()
	{
		C obj;
		cout << endl ;
		obj.show();
		return 0;
	}#include<iostream>
using namespace std;
class A
{
	public:
		int a;
		void getA(int x)
		{
			a = x;
		}
		
		void showA()
		{
			cout<<"\nA = "<<a;
		}
};
class B : public A
{
	public:
		int b;
		void getB(int y)
		{
			b = y;
		}
		
		void showB()
		{
			cout<<"\nB = "<<b;
		}
};
class C: public B{
	public:
		int c;
		void getC(int z)
		{
			c= z;
		}
		
		void showC()
		{
			cout<<"\n C = "<<c;
		}
};
int main()
{
	C b;
	int a,b1,c;
	cout<<"\nEnter A : ";
	cin>>a;
	cout<<"\nEnter B : ";
	cin>>b1;
	cout<<"\nEnter C : ";
	cin>>c;
	b.getA(a);
	b.getB(b1);
	b.getC(c);
	b.showA();
	b.showB();
	b.showC();
}#include<iostream>
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





#include <iostream>

using namespace std;

class Distance
	{
		public:
			int feet, inche;
			
			Distance(int f, int i)
				{
					feet = f;
					inche = i;
				}
			Distance operator-()	
				{
					feet = -feet;
					inche = -inche;
					return Distance(feet, inche);
				}
			void Display()	
				{
					cout << endl;
					cout << "Feet = ";
					cout << feet;
					
					cout << endl;
					cout << "Inche = ";
					cout << inche;
				}
	};

int main()
	{
		Distance d1(10, 15);
		d1.Display();
		-d1;
		d1.Display();
	}#include<iostream>
using namespace std;
/*
	Scope Resolution Operator.
	
	::  -> It is use to acces the memebers of the class through outside.

*/


class Demo{
	public:		
		void func();	
		int add(int a,int b)
		{
			return a+b;
		}
		
		void evenOdd(int a);
		
};

void Demo::func()
{
	cout<<"\nFunction Implemented outside the class.";
}

void Demo::evenOdd(int a)
{
	if(a%2==0)
	{
		cout<<"\nIt is Even.";
	}
	else
	{
		cout<<"\nIt is Odd.";
	}
}


int main()
{
	Demo obj;
	obj.func();
	cout<<"\nAddition : "<<obj.add(5,2);
	int n;
	cout<<"\nEnter Number : ";
	cin>>n;
	obj.evenOdd(n);
	return 0;
}#include <iostream>

/*
	This is scope resolution example.
*/

using namespace std;

class box
	{
		public:
			void volume();
	};

void box::volume()
	{	
		cout << endl;
		cout << "In volume function....";
		cout << endl;
	}

int main()
	{
		box b1;
		b1.volume();
	}#include<iostream>
using namespace std;

class A
{
	public:
		int a;
		
		void getA(int x)
		{
			a = x;
		}
		
		void showA()
		{
			cout<<"\nA = "<<a;
		}
};

class B : public A
{
	public:
		int b;
		
		void getB(int y)
		{
			b = y;
		}
		
		void showB()
		{
			cout<<"\nB = "<<b;
		}
};

int main()
{
	B b;
	int a,b1;
	cout<<"\nEnter A : ";
	cin>>a;
	cout<<"\nEnter B : ";
	cin>>b1;

	b.getA(a);
	b.getB(b1);	
	b.showA();
	b.showB();
}#include <iostream>

using namespace std;

int main()
	{
		return 0;
	}#include<iostream>
using namespace std;

/*
	It is used for common memory management;
*/

class staticDemo
{
	public:
		static int objCount=0;
	
	staticDemo()
	{
		cout<<"\nDefault Constructor Called.";
		objCount++; // objCount = objCount+1
	}
		
};

//int staticDemo::objCount=0;

int main()
{
	staticDemo sd1,sd2,sd3;
	cout<<"\n\nObject Count : "<<sd1.objCount;	
	return 0;
}










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

	}#include <iostream>

using namespace std;

template <typename T>
T add(T a, T b)
	{
		return a+b;
	}

int main()
	{
		cout << endl;
		cout << "Add two Integers : " << add<int>(54, 45);
		cout << endl;
		cout << "Add two floats : " << add<float>(54.45f, 45.54f);
		cout << endl;
		cout << "Add two strings : " << add<string>("Sanjay ", "Tamboli");
		return 0;
	}#include<iostream>
using namespace std;


int main()
{
	cout<<"\nWelcome to C++ Programming."<<endl;
	cout<<"In Tops Technology.";
	return 0;
}#include <iostream>

using namespace std;

int main()
	{
		cout << endl << "Welcome to C++ programming.";
		cout << endl << "In Top Technologies.";
		return 0;
	}