package ExerciciosNormais.exercicios.exercicio1;

//Não precisa do import, pois estao na mesma classe
import ExerciciosNormais.exercicios.exercicio1.Account;
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
        Account conta1 = new Account("Gustavo", 3333, 100), conta2 = null;
//        displayAccount(conta2);
        System.out.println(conta1.importarSenha());
        Account.verSenha(conta1.importarSenha(), 12345);
        System.out.println("");
        System.out.println(criptografar(1234));
        
//        criando um objeto da propria classe para utilizar um metodo nao static
        AccountTest main = new AccountTest();
        System.out.println(main.descriptografar(criptografar(1234)));

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

    // Método para criptografar um número de quatro dígitos
    public static int criptografar(int numero) {
        int digito1 = (numero / 1000 + 7) % 10;
        int digito2 = ((numero / 100) % 10 + 7) % 10;
        int digito3 = ((numero / 10) % 10 + 7) % 10;
        int digito4 = (numero % 10 + 7) % 10;

        return digito3 * 1000 + digito4 * 100 + digito1 * 10 + digito2;
    }

    // Método para descriptografar um número criptografado
    public int descriptografar(int numeroCriptografado) {
        int digito1 = (numeroCriptografado / 1000 + 3) % 10;
        int digito2 = ((numeroCriptografado / 100) % 10 + 3) % 10;
        int digito3 = ((numeroCriptografado / 10) % 10 + 3) % 10;
        int digito4 = (numeroCriptografado % 10 + 3) % 10;

        return digito3 * 1000 + digito4 * 100 + digito1 * 10 + digito2;
    }
}
