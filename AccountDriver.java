import javax.swing.JOptionPane;

public class AccountDriver{
	public static void main(String[] args){

		/** Declare the variable */
		int count = 0 , counts = 1 , options = 1 ;
		int answer , array_length , initial_deposit , option , account_number , account_no ;
		final int SIZE = 50 ;
		double amount_withdraw , amount_deposit ;
		double balance = 0.0 ;
		boolean error = true , decision = false ;
		String identity_card_number , a , b ;


		/** Declare and create an array */
		Account account[] = new Account[SIZE];

        /** Prompt the user to create an account */
		String name = JOptionPane.showInputDialog(null,"Enter your name:\t", "Create your new bank account!",JOptionPane.QUESTION_MESSAGE);
	    identity_card_number = JOptionPane.showInputDialog(null,"Enter your identity card number (IC): ", "Your bank account!",JOptionPane.QUESTION_MESSAGE);
		String initial_depositStr = JOptionPane.showInputDialog(null, "An initial amount is needed to open an account"+"\nPlease key in the amount of money",
									"Amount saving into your new account", JOptionPane.INFORMATION_MESSAGE);
		balance = Double.parseDouble(initial_depositStr);

		/** While loop to check the condition of the initial deposit */
		while(balance<50){
			initial_depositStr = JOptionPane.showInputDialog(null, "Minimum RM50 amount is needed to open an account"+"\nPlease key in the amount of money",
									"Amount saving into your new account", JOptionPane.INFORMATION_MESSAGE);
		balance = Double.parseDouble(initial_depositStr);
		}

		/** Random generate account number */
		account_number = (int) ((Math.random()*999999)+10000);

		/** Store the information into the array */
		Account holders = new Account(name, identity_card_number, account_number, balance);
        account[count] = holders;
        a = holders.toString();
        JOptionPane.showMessageDialog(null,"\t" + a + "", "The information of your account .", JOptionPane.PLAIN_MESSAGE);

		/** Prompt for choice to continue */
		option = JOptionPane.showConfirmDialog(null,"Do you want to continue the operation?", "Account", JOptionPane.YES_NO_OPTION);

        if(option == JOptionPane.YES_OPTION){
		do{

		/** Display the menu */
		String answerStr = JOptionPane.showInputDialog(null,"Option 1 : Create account \nOption 2 : Withdraw or Deposit \nOption 3 : Print the details of an account number \nOption 4 : Print the details of all accounts \nOption 5 : Exit",
						   "Menu of the service", JOptionPane.PLAIN_MESSAGE);
		answer = Integer.parseInt(answerStr);

		/** Switch case */
		switch(answer){

		/** Create new account */
		case 1 :{
		String array_lengthStr = JOptionPane.showInputDialog(null,"How many account do you want to register ?","Open An Account",JOptionPane.INFORMATION_MESSAGE);
	    array_length = Integer.parseInt(array_lengthStr);

	    /** Prompt the user for amount of accounts to create */
	    while(array_length > 49){
	    	JOptionPane.showMessageDialog(null,"Maximum 50 accounts are available for the registration!", "ERROR!!!", JOptionPane.WARNING_MESSAGE);
	    	array_lengthStr = JOptionPane.showInputDialog(null,"How many account do you want to register ?","Open An Account",JOptionPane.INFORMATION_MESSAGE);
	    	array_length = Integer.parseInt(array_lengthStr);
	    }

		/** Prompt the user to create accounts */
        for(int i = 0 ; i < array_length; i++){
		 	name = JOptionPane.showInputDialog(null,"Enter your name:\t", "Create your new bank account!",JOptionPane.QUESTION_MESSAGE);
	    	identity_card_number = JOptionPane.showInputDialog(null,"Enter your identity card number (IC): ", "Your bank account!",JOptionPane.QUESTION_MESSAGE);
		    initial_depositStr = JOptionPane.showInputDialog(null, "An initial amount is needed to open an account"+"\nPlease key in the amount of money",
										"Amount saving into your new account", JOptionPane.INFORMATION_MESSAGE);
			balance = Double.parseDouble(initial_depositStr);

		/** While loop to check the condition of the initial deposit*/
		while(balance<50){
			initial_depositStr = JOptionPane.showInputDialog(null, "Minimum RM50 amount is needed to open an account"+"\nPlease key in the amount of money",
									"Amount saving into your new account", JOptionPane.INFORMATION_MESSAGE);
			balance = Double.parseDouble(initial_depositStr);
		}

		/** Random generate account number */
			account_number = (int) ((Math.random()*999999)+10000);
		    holders = new Account(name, identity_card_number, account_number, balance);
        	account[counts] = holders;
        	counts++;
        	b = holders.toString();
        	JOptionPane.showMessageDialog(null,"\t" + b + "", "The information of your account .", JOptionPane.PLAIN_MESSAGE);
        	}
		/** Prompt for choice to continue */
		options = JOptionPane.showConfirmDialog(null,"Do you want to continue the operation?", "Account", JOptionPane.YES_NO_OPTION);

		}break;

		/** In the main, prompt the user to key in the account number.
			Search the content of the array, and print out the detail if the account number is found from the objects store in the array. */
		case 2 :{

		String account_noStr = JOptionPane.showInputDialog(null,"Please key in your account number:\t", "Account", JOptionPane.QUESTION_MESSAGE);
		account_no = Integer.parseInt(account_noStr);

        /** for loop to print details of chosen account */
        for(int i=0; i< (count + counts); i++){
        	if(account_no == account[i].getAccNo()){
        		JOptionPane.showMessageDialog(null,"" + account[i] + "", "The information of your account .", JOptionPane.PLAIN_MESSAGE);

           		/** Decision making for Cash Deposit or Cash Withdraw */
       			Object[] decisions = {"Cash Deposit", "Cash Withdrawal"};
				int choice = JOptionPane.showOptionDialog(null,"Please choose an operation . ", "Transaction in progress...", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
				null,decisions,decisions[0]);

				/** for deposit or withdraw */
				if (choice == JOptionPane.YES_OPTION)
					decision = true;	// cash deposit
				else
					decision = false;	// cash withdraw

				/** Withdrawal Operation */
        		if(decision == false){
        			String amount_withdrawStr = JOptionPane.showInputDialog(null,"Enter the amount that you want to withdraw:\t", "Transaction Type: Cash Withdrawal", JOptionPane.QUESTION_MESSAGE);
        			amount_withdraw = Double.parseDouble(amount_withdrawStr);
        			error = false;
        				if(amount_withdraw > account[i].getBalance()){
        					JOptionPane.showMessageDialog(null,"Your current balance is not sufficient to withdraw the money!"+ "\nTransaction is rejected");}
        				else{
        					account[i].Withdraw(amount_withdraw);
        					}
        		}
        		/** Deposit Operation */
        		else if(decision == true){
        			String amount_depositStr = JOptionPane.showInputDialog(null,"Enter the amount that you want to deposit:\t", "Transaction Type: Cash Deposit", JOptionPane.QUESTION_MESSAGE);
        			amount_deposit = Double.parseDouble(amount_depositStr);
        			account[i].Deposit(amount_deposit);
        			error = false;
        		}
        		break;
        	}
        	else {error = true;}
        }

		/** Show error message for wrong account number */
        while(error == true){
        	JOptionPane.showMessageDialog(null,"Account number not found!" + "\nTransaction is rejected", "Account", JOptionPane.QUESTION_MESSAGE);
        	break;
        }

        /** Prompt for choice to continue */
		options = JOptionPane.showConfirmDialog(null,"Do you want to continue the operation?", "Account", JOptionPane.YES_NO_OPTION);
        }break;

        /** In the main, prompt the user to key in the account number.
			Search the content of the array, and print out the detail if the account number is found from the objects store in the array. */
		case 3:{

		String account_noStr = JOptionPane.showInputDialog(null,"Please key in your account number:\t", "Account", JOptionPane.QUESTION_MESSAGE);
		account_no = Integer.parseInt(account_noStr);

        /** For loop to print details of all account */
        for(int i=0; i<(count + counts); i++){
        	if(account_no == account[i].getAccNo()){
        		JOptionPane.showMessageDialog(null,"" + account[i] + "", "The information of your account .", JOptionPane.PLAIN_MESSAGE);
        	}
        }

		/** Prompt for choice to continue */
		options = JOptionPane.showConfirmDialog(null,"Do you want to continue the operation?", "Account", JOptionPane.YES_NO_OPTION);
		       }break;

        /** Search the content of the array, and print out all the detail of the account from the objects store in the array. */
		case 4:{
        	for(int i=0; i<(count + counts);i++){
        		JOptionPane.showMessageDialog(null,"" + account[i] + "", "The information of your account .", JOptionPane.PLAIN_MESSAGE);
        	}

        /** Prompt for choice to continue */
        options = JOptionPane.showConfirmDialog(null,"Do you want to continue the operation?", "Account", JOptionPane.YES_NO_OPTION);
        }break;

		/** Exit */
		case 5:{
		JOptionPane.showMessageDialog(null,"Thank you for using our service!", "Have a nice day.", JOptionPane.PLAIN_MESSAGE);
		options = JOptionPane.NO_OPTION;
		}
	}
	/** Loop back to the menu */
	}while(options == JOptionPane.YES_OPTION);
    }

	/** End program */
	else if(option == JOptionPane.NO_OPTION){
        	JOptionPane.showMessageDialog(null,"Thank you for using our service!", "Have a nice day.", JOptionPane.PLAIN_MESSAGE);}
	}
}
