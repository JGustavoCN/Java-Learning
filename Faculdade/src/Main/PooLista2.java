package Main;

import java.util.Scanner;

/**
 *
 * @author José Gustavo
 */
public class PooLista2 {

    public static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int cont = 0;
        do {
            try {
                Calculadora(1, 2, 3);
            } catch (DivisaoPorZeroException e) {
                e.printStackTrace();
            }
            cont++;
        } while (cont < 4);

        System.out.println("Digite um numero de 1 a 7 para converter para o dia da semana: ");
        numeroParaDiaSemana(Integer.parseInt(teclado.nextLine()));

        System.out.println("Digite um numero que correpsonde a um mes para descobrir a estacao dele: ");
        estacaoDoMes(Integer.parseInt(teclado.nextLine()));

    }

    private static class DivisaoPorZeroException extends Exception {

        public DivisaoPorZeroException() {
        }

        public DivisaoPorZeroException(String msg) {
            super(msg);
        }
    }

    /**
     *
     * Os numeros passados serão afetados apenas por uma operacão.As operações
     * seguirão a ordem que foram adiconados os numeros
     *
     * @param numerosInteiros
     * @throws Main.PooLista2.DivisaoPorZeroException
     */
    public static void Calculadora(double... numerosInteiros) throws DivisaoPorZeroException {

        // 1 - Crie um programa Java que simule uma calculadora simples que realiza operações como adição, subtração, multiplicação e divisão.
        // Utilize switch-case para determinar qual operação será realizada com base em uma entrada do usuário.
        String menu = " (1) Soma \n"
                + " (2) Subtracao \n"
                + " (3) Multiplicacao \n"
                + " (4) Divisao \n";
        int escolhaOperacao;
        String operacao = "";
        double resultado = 0;

        do {
            System.out.println(menu);
            System.out.print("Escolha a operacao: ");
            escolhaOperacao = Integer.parseInt(teclado.nextLine());
        } while (escolhaOperacao < 1 || escolhaOperacao > 4);

        switch (escolhaOperacao) {
            case 1:
                for (double numero : numerosInteiros) {
                    operacao += Double.toString(numero) + " + ";
                    resultado += numero;
                }
                operacao = operacao.substring(0, operacao.length() - 3);
                System.out.println(operacao + " = " + resultado);
                break;
            case 2:
                for (double numero : numerosInteiros) {
                    operacao += Double.toString(numero) + " - ";
                    if (resultado == 0) {
                        resultado = numero;
                    } else {
                        resultado -= numero;
                    }
                }
                operacao = operacao.substring(0, operacao.length() - 3);
                System.out.println(operacao + " = " + resultado);
                break;
            case 3:
                for (double numero : numerosInteiros) {
                    operacao += Double.toString(numero) + " * ";
                    if (resultado == 0) {
                        resultado = numero;
                    } else {
                        resultado *= numero;
                    }

                }
                operacao = operacao.substring(0, operacao.length() - 3);
                System.out.println(operacao + " = " + resultado);
                break;
            case 4:
                for (double numero : numerosInteiros) {
                    if (numero == 0) {
                        throw new DivisaoPorZeroException("Existe um numero zero dentro dos parametros");
                    }
                    operacao += Double.toString(numero) + " / ";
                    if (resultado == 0) {
                        resultado = numero;
                    } else {
                        resultado /= numero;
                    }

                }
                operacao = operacao.substring(0, operacao.length() - 3);
                System.out.println(operacao + " = " + resultado);
                break;
        }

    }

    protected enum DiaSemana {
        DOMINGO, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO
    }

    public static DiaSemana numeroParaDiaSemana(int numero) {

        // 2 - Escreva um programa que peça ao usuário para inserir um número de 1 a 7 e utilize um  
        // switch-case para imprimir o dia da semana correspondente (1 para domingo, 2 para segunda-feira, etc.).
        if (numero < 1 || numero > 7) {
            throw new IllegalArgumentException("Esse numero nao corresponde a um dia de uma semana");
        }
        switch (numero) {
            case 1:
                System.out.println(DiaSemana.DOMINGO.toString());
                return DiaSemana.DOMINGO;
            case 2:
                System.out.println(DiaSemana.SEGUNDA.toString());
                return DiaSemana.SEGUNDA;
            case 3:
                System.out.println(DiaSemana.SEXTA.toString());
                return DiaSemana.TERCA;
            case 4:
                System.out.println(DiaSemana.QUARTA.toString());
                return DiaSemana.QUARTA;
            case 5:
                System.out.println(DiaSemana.QUINTA.toString());
                return DiaSemana.QUINTA;
            case 6:
                System.out.println(DiaSemana.SEXTA.toString());
                return DiaSemana.SEXTA;
            case 7:
                System.out.println(DiaSemana.SABADO.toString());
                return DiaSemana.SABADO;

        }
        return null;
    }

    public static void estacaoDoMes(int numeroDoMes) {

        // 3 - Crie um programa que peça ao usuário para inserir um mês (em forma numérica) e 
        // utilize switch-case para determinar e imprimir a estação do ano correspondente.
        switch (numeroDoMes) {
            case 1:
            case 2:
            case 3:
                System.out.println("A estacao do mes " + numeroDoMes + " é o VERÂO ");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("A estacao do mes " + numeroDoMes + " é o OUTONO ");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("A estacao do mes " + numeroDoMes + " é o INVERNO ");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("A estacao do mes " + numeroDoMes + " é o PRIMAVERA ");
                break;
            default:
                throw new IllegalArgumentException("Esse numero nao corresponde a um mês");
        }
    }
    
    public static void faixaEtaria(int idade){
        boolean ver = true;
        Boolean crianca = idade < 18;
        /*
        switch (ver) {
            case crianca:
                
                break;
            default:
                throw new AssertionError();
        }
        */
    }

}
