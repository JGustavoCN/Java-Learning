package ExerciciosNormais.exercicios.exercicios1;

//Não precisa do import, pois estao na mesma classe
import ExerciciosNormais.exercicios.exercicios1.Account;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author José Gustavo
 *
 * Exercicio do Capitulo 3
 *
 */
public class AccountTest {

    public static void main(String[] args) {
        /*
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.53);

        // exibe saldo inicial de cada objeto
        System.out.printf("%s balance: $%.2f %n",
                account1.getName(),
                account1.getBalance());
        System.out.printf("%s balance: $%.2f %n%n",
                account2.getName(),
                account2.getBalance());
        // cria um Scanner para obter entrada a partir da janela de comando
        

        System.out.print("Enter deposit amount for account1: "); // prompt
        double depositAmount = input.nextDouble(); // obtém a entrada do usuárioÿ
        System.out.printf("%nadding %.2f to account1 balance%n%n",
                depositAmount);
        account1.deposit(depositAmount); // adiciona o saldo de account1ÿ

        // exibe os saldos
        System.out.printf("%s balance: $%.2f %n",
                account1.getName(),
                account1.getBalance());
        System.out.printf("%s balance: $%.2f %n%n",
                account2.getName(),
                account2.getBalance());

        System.out.print("Enter deposit amount for account2: "); // prompt
        depositAmount = input.nextDouble(); // obtém a entrada do usuárioÿ
        System.out.printf("%nadding %.2f to account2 balance%n%n",
                depositAmount);
        account2.deposit(depositAmount); // adiciona ao saldo de account2ÿ

        // exibe os saldos
        System.out.printf("%s balance: $%.2f %n",
                account1.getName(),
                account1.getBalance());
        System.out.printf("%s balance: $%.2f %n%n",
                account2.getName(),
                account2.getBalance());
         */

        Account conta1 = new Account("Gustavo",1245,100)
                , conta2 = null;
//        displayAccount(conta1);
        System.out.println(conta1.importarSenha());
        Account.verSenha(conta1.importarSenha(), 12345);

    }

    public static void displayAccount(Account accountToDisplay) {

        String nome = JOptionPane.showInputDialog(
                null,
                "Digite o nome da titular: ",
                "Criacao da Conta",
                JOptionPane.INFORMATION_MESSAGE
        );

        int senha = Integer.parseInt(
                JOptionPane.showInputDialog(
                        null,
                        "Digite a senha de 4 digitos: : ",
                        "Criacao da Conta",
                        JOptionPane.INFORMATION_MESSAGE
                )
        );
        double deposito = Double.parseDouble(
                JOptionPane.showInputDialog(
                        null,
                        "Qual o valor do primeiro deposito: ",
                        "Criacao da Conta",
                        JOptionPane.INFORMATION_MESSAGE
                )
        );

        accountToDisplay = new Account(nome, senha, deposito);
        System.out.printf("%s balance: $%.2f %n",
                accountToDisplay.getName(),
                accountToDisplay.getBalance()
        );
    }

}
