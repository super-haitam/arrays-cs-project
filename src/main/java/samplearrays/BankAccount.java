package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;

    double[] transactions = new double[1000];
    int index = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount < 0) {
             System.out.println("Error: Deposit of amount (" + amount + "$) failed.");
             return;
        }

        this.currentBalance += amount;
        this.transactions[index++] = amount;
        System.out.println("Deposit: (" + this.name + ", " + amount + "$) - Balance: " + this.currentBalance);
    }

    public void withdraw(double amount){
        if (amount > this.currentBalance) {
            System.out.println("Error: Withdrawal of amount (" + amount + "$) failed.");
            return;
        }

        this.currentBalance -= amount;
        this.transactions[index++] = -amount;
        System.out.println("Withdrawal: (" + this.name + ", " + amount + "$) - Balance: " + this.currentBalance);
    }

    public void displayTransactions(){
        for (double trans : transactions) System.out.println(trans);
    }

    public void displayBalance(){
        System.out.println(this.currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
