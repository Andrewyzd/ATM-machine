import javax.swing.JOptionPane;

public class Account{

	private String name;
	private String identity_card_number;
	private int account_number;
	private double balance;


	/**
	 *default constructor to initialize value
	 */
	public Account(){
		name = "James Gosling";
		identity_card_number = "12345";
		account_number = 987654;
		balance = 0.0;
	}

	/**
	 *overloaded constructor to initialize the data
	 *@param name the name of account holder
	 *@param identity_card_number the ic no of the account holder
	 *@param account_number the account no of the account holder
	 *@param balance the balance in the bank account
	 */
	public Account(String name, String identity_card_number, int account_number, double balance){
		this.name = name;
		this.identity_card_number = identity_card_number;
		this.account_number = account_number;
		this.balance = balance;
	}

	/**
	 *setName() - mutator method to change the name of account holder
	 *@param na_me name of account holder
	 */
	public void setName(String na_me){
		name = na_me;
	}

	/**
	 *setICNo() - mutator method to change the identity card number of account holder
	 *@param ic identity card number of account holder
	 */
	public void setICNo(String ic){
		identity_card_number = ic;
	}

	/**
	 *setAccNo() - mutator method to change the account number of account holder
	 *@param acNo account number of account holder
	 */
	public void setAccNo(int acNo){
		account_number = acNo;
	}

	/**
	 *setBalance() - mutator method to change the balance of account holder
	 *@param acNo account number of account holder
	 */
	public void setBalance(double bal_ance){
		balance = bal_ance;
	}

	/** Method for Deposit Operation */
	public double Deposit(double amount){
		JOptionPane.showMessageDialog(null,"Transaction success" , "Account", JOptionPane.PLAIN_MESSAGE );
	    balance = balance + amount;
		JOptionPane.showMessageDialog(null, "Your new balance is \nRM " + balance);
		return balance;
	}

	/** Method for Withdraw Operation */
	public double Withdraw(double amount){
			if(amount > balance){
        				JOptionPane.showMessageDialog(null,"Your current balance is not sufficient to withdraw the money!"+ "\nTransaction is rejected");
		    	    }
    	 else{JOptionPane.showMessageDialog(null,"Transaction success" +"\nPlease take your cash.", "Resit", JOptionPane.PLAIN_MESSAGE );
    	balance = balance - amount;
    	JOptionPane.showMessageDialog(null, "Your new balance is \nRM " + balance);
		}
		return balance;
		}

	/**
	 *getName() - accessor method to get the name of account holder
	 *@return name of account holder
	 */
	public String getName(){
		return name;
	}

	/**
	 *getICNo() - accessor method to get the identity card number of account holder
	 *@return identity card number of account holder
	 */
	public String getICNo(){
		return identity_card_number;
	}

	/**
	 *getAccNo() - accessor method to get the account number of account holder
	 *@return account number of account holder
	 */
	public int getAccNo(){
		return account_number;
	}

	/**
	 *getBalance() - accessor method to get the balance in the bank account
	 *@return balance in the bank account
	 */
	public double getBalance(){
		return balance;
	}

    /**
      * The string representation is "Name = name, Identity card number = identity_card_number, Account no = account_number, Balance = balance"
      * Where name is the name of account holder, identity_card_number is the identity card number of account holder
      * account_number is the account number of account holder and balance is the balance in the bank account
      */
	public String toString(){
		return "Name: " + name + "\nIdentity card number: " + identity_card_number + "\nAccount no: " + account_number + "\nBalance: RM" + balance;
	}
}