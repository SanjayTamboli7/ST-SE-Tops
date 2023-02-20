#include <iostream>

using namespace std;

class BankAccount
	{
		private:
			string AcHolderNm, AcType;
			int    AcNo;
			double Balance;
		public:
			void AssignValues(string AcNm, string AcTyp, int AcNumber, double AcBal)
				{
					AcHolderNm = AcNm;
					AcType 	   = AcTyp;
					AcNo 	   = AcNumber;
					Balance    = AcBal;
	
					cout << endl;
					cout << "Account holder name : ";
					cout << AcHolderNm;
					cout << endl;
					cout << "Account type	 : ";	
					cout << AcType;
					cout << endl;
					cout << "Account number	   : ";
					cout << AcNo;
					cout << endl;
					cout << "Account balance	   : ";
					cout << Balance;
				}
			double DepositAmount(double CreditAmount)
				{
					Balance = Balance + CreditAmount;
					cout << endl;
					cout << "New balance	   : ";
					cout << Balance;
					return Balance;
				}
			double WithdrawAmount(double CreditAmount)
				{
					Balance = Balance - CreditAmount;
					cout << endl;
					cout << "New balance	   : ";
					cout << Balance;
					return Balance;
				}
	};
	
int main()
	{
		string AcNm, AcTyp, Check_balance;
		int    AcNumber;
		double AcBal, CreditAmount, DebitAmount;
		
		BankAccount BAObj;
		
		system("cls");
		cout << endl;
		cout << "Enter Account holder name : ";
		getline(cin, AcNm);
		cout << "Enter Account type	 : ";	
		getline(cin, AcTyp);
		cout << "Enter Account number	   : ";
		cin >> AcNumber;
		cout << "Enter Account balance	   : ";
		cin >> AcBal;
		BAObj.AssignValues(AcNm, AcTyp, AcNumber, AcBal);
		
		cout << endl << endl;
		cout << "Enter Deposit Amount	   : ";
		cin >> CreditAmount;
		AcBal = BAObj.DepositAmount(CreditAmount);
		Check_balance = "Fail";
		while (Check_balance == "Fail")
			{
				cout << endl << endl;
				cout << "Enter Amount to withdraw	   : ";
				cin >> DebitAmount;
				if (DebitAmount < AcBal) Check_balance = "Pass";
			}
		if (Check_balance == "Pass")
			{
				AcBal = BAObj.WithdrawAmount(DebitAmount);
			}

		BAObj.AssignValues(AcNm, AcTyp, AcNumber, AcBal);

		return 0;
	}
