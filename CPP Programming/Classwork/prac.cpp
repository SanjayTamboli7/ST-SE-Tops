#include<iostream>

using namespace std;

class checkAccount
{
	public:
		
		long accno;
		double balance=0;
		
		
		checkAccount(long acc)
		{
			accno = acc;
			cout<<"Account No. is "<<accno;
		}
		
		void deposit(double amt)
		{
			balance = balance + amt;
		}
		
		void withdraw(double amt) 
		{
			if(amt<=balance)
			{
				balance = balance - amt;
			}
			else
			{
				double needs = amt - balance;
				cout<<"Sorry you need Rs."<<needs<<" more to withdraw";
			}
		}
		
		
		void checkBalance()
		{
			cout<<"\nBalance : "<<balance;
		}
				
};


int main()
{
	checkAccount ca(233444);
	cout<<"\nEnter Amount to Deposit : ";
	int amt;
	cin>>amt;
	ca.deposit(amt);
	cout<<"\nAmount Deposited Successful.";
	ca.checkBalance();	
	cout<<"\nEnter Amount to Withdraw : ";
	cin>>amt;
	ca.withdraw(amt);	
	ca.checkBalance();
	
	
	return 0;
}