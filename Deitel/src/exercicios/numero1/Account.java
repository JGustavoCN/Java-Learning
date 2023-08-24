package exercicios.numero1;

/**
 *
 * @author José Gustavo
 */
public class Account {
    
    // Os atributos devem estar no começo da classe
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        if (balance > 0)
            this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double deposit){
        if (deposit > 0)
        this.setBalance(this.balance+deposit);
        
    }
    public void withdraw(double withdraw){
        if (withdraw > 0)
        this.setBalance(this.balance-withdraw);
        
    }
    
    
}
