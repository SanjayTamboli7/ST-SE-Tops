#include <iostream>

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
	}