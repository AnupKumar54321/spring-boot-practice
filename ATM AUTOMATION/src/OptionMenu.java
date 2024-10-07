import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu extends Account {
	 
	Scanner menuInput= new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	public void getLogin() throws IOException
	{
		int x = 1;
		do {
			try 
			{
				data.put(377338, 376472);
				data.put(242475, 254362);
				data.put(136522, 584678);
				System.out.println("!*WELCOME TO ATM AUTOMATION SYSTEM*!");
				System.out.println("Please Enter your Customer Number to continue: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Please Enter your PIN Number: ");
				setPinNumber(menuInput.nextInt());
			} 
			catch (Exception e) {
				System.out.println("\n" + "!!!INVALID CHARACTER(S)!!!...ONLY NUMBERS..." + "\n");
				x=2;
			}
			
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			if(data.containsKey(cn) && data.get(cn) == pn)
			{
				getAccountType();
			}
			else
			{
				System.out.println("\n" + "Wrong Customer Number or PIN Number" + "\n");
			}
		} while (x==1);
	}
	
	public void getAccountType()
	{
		System.out.println("Select the Account you want to Access: ");
		System.out.println("1. Checking Account");
		System.out.println("2. Saving Account");
		System.out.println("3. Exit");
		
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1: 
			getChecking();
			break;
		
		case 2:
			getSaving();
			break;
			
		case 3:
			System.out.println("Thank You for using this ATM" + "\n" + "--HAVE A NICE DAY--" + "\n");
			break;
			
		default:
			System.out.println("\n" + "Invalid Choise" + "\n");
			getAccountType();
		}
	}
	public void getChecking()
	{
		System.out.println("CHECKING ACCOUNT: ");
		System.out.println("1. View Balance");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Deposit Amount");
		System.out.println("4. Exit");
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank You for using this ATM" + "\n" + "--HAVE A NICE DAY--" + "\n");
			break;
			
	    default:
	    	System.out.println("\n" + "Invalid Choise" + "\n");
	    	getChecking();
		}
	}
	
	public void getSaving()
	{
		System.out.println("SAVING ACCOUNT: ");
		System.out.println("1. View Balance");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Deposit Amount");
		System.out.println("4. Exit");
		System.out.println("Choice: ");
		
        int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
			
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
			
		case 4:
			System.out.println("Thank You for using this ATM" + "\n" + "--HAVE A NICE DAY--" + "\n");
			break;
			
	    default:
	    	System.out.println("\n" + "Invalid Choise" + "\n");
	    	getChecking();
		}
	}
		
}


