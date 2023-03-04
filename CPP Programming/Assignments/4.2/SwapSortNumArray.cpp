#include <iostream>

using namespace std;

template <typename Tmpl>
Tmpl SortArray(Tmpl NumArr[5])
	{
		int i, j, tot=0, tmp;
		cout << endl ;

		for(i=0;i<5;i++)
			{
				for(j=i+1;j<5;j++)
					{
						if (NumArr[i] > NumArr[j])
							{
								tmp = NumArr[i];
								NumArr[i] = NumArr[j];
								NumArr[j] = tmp;
							}
					}
			}
		
		cout << "Array after sorting....";
		
		for(i=0;i<5;i++)
			{
				cout << endl << NumArr[i];
			}
		return tot;
	}

int main()
	{
		int i, NoArr[5];

		for(i=0;i<5;i++)		
			{
				cout << "\t Enter NoArr["<< i << "] : ";
				cin >> NoArr[i];
			}

		i = SortArray<int>(NoArr);
		
		return 0;
	}
