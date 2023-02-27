#include <iostream>

using namespace std;

class cricket
	{
		public:

			string name, best_performance;
			int total_run=0, i, run[10];
			double avg_run=0;

			void collect_data()
				{
					cout << endl;
					cout << "Enter player name : ";
					getline(cin, name);
					for(i=0;i<=9;i++)
						{
							cout << "Enter data for inning " << i+1 << ": ";
							cin >> run[i];
							total_run = total_run + run[i];
						}
					fflush(stdin);
					cout << "Best performance  : ";
					getline(cin, best_performance);
				}
	};

class batsman:public cricket
	{
		public:
			void display_data()
				{
					cout << endl;
					cout << "player name : " << name;
					cout << endl;
					cout << "Total run   : " << total_run;
					avg_run = (double)total_run / 10;
					cout << endl;
					cout << "Average run : "<< avg_run ;
					cout << endl;
					cout << "Best performance  : " << best_performance;
				}
	};

int main()
	{
		batsman crcktobj;
		crcktobj.collect_data();		
		crcktobj.display_data();
		return 0;
	}