package ExerciciosNormais.exercicios.exercicios1;

/**
 *
 * @author José Gustavo
 */
public class Account {

    // Os atributos devem estar no começo da classe
    private String name;
    private double balance;
    private static final int TAMANHO_DA_SENHA = 4;
    private int senha;

    public Account(String name, int senha, double balance) {
        this.name = name;
        if (senha > 999 && senha < 10_000) {
            this.senha = senha;
        }
        if (balance > 0) {
            this.balance = balance;
        }
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

    public void deposit(double deposit) {
        if (deposit > 0) {
            this.setBalance(this.balance + deposit);
        } else {
            System.out.println("erro: Valor negativo ou nulo");
        }

    }

    public void withdraw(double withdraw) {

        if (withdraw <= 0 || withdraw > this.balance) {
            System.out.println("Erro: Valor invalido: Muito acima, negativo ou nulo");

        } else {
            this.setBalance(this.balance - withdraw);
        }

    }

    public int importarSenha() {
        int vetor[] = new int[TAMANHO_DA_SENHA];
        int j = 0;
        int criptografado = 0;
        for (int i = (TAMANHO_DA_SENHA - 1); i >= 0; i--) {
            int casa = (int) Math.pow(10, i);
            int casa2 = (this.senha / casa) % 10;
            vetor[j] = ((casa2 + 7) % 10);
            j++;
        }
        for (int i = 0; i < TAMANHO_DA_SENHA; i++) {
            int troca;
            switch (i) {
                case 0:
                    troca = vetor[i];
                    vetor[i] = vetor[i + 2];
                    vetor[i + 2] = troca;
                    break;
                case 1:
                    troca = vetor[i];
                    vetor[i] = vetor[i + 2];
                    vetor[i + 2] = troca;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0; i < TAMANHO_DA_SENHA; i++) {
            switch (i) {
                case 0:
                    criptografado += vetor[i] * 1000;
                    break;
                case 1:
                    criptografado += vetor[i] * 100;
                    break;
                case 2:
                    criptografado += vetor[i] * 10;
                    break;
                case 3:
                    criptografado += vetor[i];
                    break;
                default:
                    break;
            }
        }

        return criptografado;
    }

    public static void verSenha(int criptografado, int senhaAdministracao) {
        int vetor[] = new int[TAMANHO_DA_SENHA];
        int j = 0;
        if (senhaAdministracao != 12345) {
            System.out.println("Senha da Administracao esta incorreta");
        } else {
            for (int i = (TAMANHO_DA_SENHA - 1); i >= 0; i--) {
                int casa = (int) Math.pow(10, i);
                int casa2 = (criptografado / casa) % 10;
                vetor[j] = casa2;
                j++;
            }

            for (int i = 0; i < TAMANHO_DA_SENHA; i++) {
                int troca;
                switch (i) {
                    case 0:
                        troca = vetor[i];
                        vetor[i] = vetor[i + 2];
                        vetor[i + 2] = troca;
                        break;
                    case 1:
                        troca = vetor[i];
                        vetor[i] = vetor[i + 2];
                        vetor[i + 2] = troca;
                        break;
                    default:
                        break;
                }
            }
            for (int i = 0; i < TAMANHO_DA_SENHA; i++) {
                switch (vetor[i]) {
                    case 1:
                        vetor[i] = 4;
                        break;
                    case 2:
                        vetor[i] = 5;
                        break;
                    case 3:
                        vetor[i] = 6;
                        break;
                    case 4:
                        vetor[i] = 7;
                        break;
                    case 5:
                        vetor[i] = 8;
                        break;
                    case 6:
                        vetor[i] = 9;
                        break;
                    case 7:
                        vetor[i] = 0;
                        break;
                    case 8:
                        vetor[i] = 1;
                        break;
                    case 9:
                        vetor[i] = 2;
                        break;
                    default:
                        break;
                }

            }
            for (int k : vetor) {
                System.out.print(k);
            }
        }
    }

}
