package Main;

import java.util.List;
import java.util.Random;
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

    protected enum FaixaEtaria {
        CRIANCA, ADOLESCENTE, ADULTO, IDOSO
    }

    private static FaixaEtaria idadeParaFaixaEtaria(int idade) {

        if (idade > 150) {
            throw new IllegalArgumentException("Idade muito alta (Acima de 150 anos)");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade invalida (Abaixa de 0 anos)");
        }

        if (idade < 12) {
            return FaixaEtaria.CRIANCA;
        } else if (idade < 19) {
            return FaixaEtaria.ADOLESCENTE;
        } else if (idade < 65) {
            return FaixaEtaria.ADULTO;
        } else {
            return FaixaEtaria.IDOSO;
        }

    }

    public static void ImprimefaixaEtaria(int idade) {

        // 4 - Escreva um programa que peça ao usuário para inserir sua idade e 
        // use switch-case para classificar a pessoa em categorias como "Criança", "Adolescente", "Adulto" e "Idoso"
        switch (idadeParaFaixaEtaria(idade)) {
            case CRIANCA:
                System.out.println("Criança");
                break;
            case ADOLESCENTE:
                System.out.println("Adolescente");
                break;
            case ADULTO:
                System.out.println("Adulto");
                break;
            case IDOSO:
                System.out.println("Idoso");
                break;
        }

    }

    protected enum Conceitos {
        A, B, C, D, F
    }

    public static Conceitos notaParaConceito(int nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("Nota invalida");
        }
        if (nota >= 90) {
            return Conceitos.A;
        } else if (nota >= 70) {
            return Conceitos.B;
        } else if (nota >= 50) {
            return Conceitos.C;
        } else if (nota >= 30) {
            return Conceitos.D;
        } else {
            return Conceitos.F;
        }
    }

    public static void imprimeConceito(Enum conceito) {
        System.out.println(conceito.toString());
    }

    public static void ImprimeNotaParaConceito(int nota) {
        // 5 - Crie um programa que converta uma nota numérica (0-100) para um conceito (A, B, C, D, F).
        // Utilize switch-case para determinar a letra correspondente à nota inserida kek.
        imprimeConceito(notaParaConceito(nota));
    }

    public static void MenuProdutos(int opcao, List<String> produtos) {
        // 6 - Desenvolva um programa que apresente um menu com várias opções (por exemplo, "1. Listar produtos", "2. Adicionar produto", "3. Remover produto").
        // Use switch-case para lidar com a escolha do usuário e executar a ação correspondente.
        if(opcao < 1 || opcao > 3) throw new IllegalArgumentException("Opcao do Menu Invalida");
        System.out.println(
                "1. Listar produtos\n"+ 
                "2. Adicionar produto\n"+ 
                "3. Remover produto\n"
        );
        switch (opcao) {
            case 1:
                System.out.print("Lista dos Produtos: ");
                for (String produto : produtos) {
                    System.out.print(produto+", ");
                }
                break;
            case 2:
                System.out.print("Adicionar produto: ");
                produtos.add(teclado.nextLine());
                break;
            case 3:
                System.out.print("Remover produto: ");
                produtos.remove(teclado.nextLine());
                break;
        }
        
    }
    
    public static void jogoPedraPapelTesoura(){
        // 7 - Implemente um jogo simples de pedra, papel e tesoura onde o usuário escolhe uma 
        // das opções e o programa escolhe outra aleatoriamente.
        // Utilize switch-case para determinar o vencedor da rodada.
        System.out.println("   Tipos de Jogadas\n(1) Pedra\n(2) Tesoura\n(3) Papel");
        System.out.println("Escolha sua jogada: ");
        int jogada = teclado.nextInt();
        Random random = new Random();
        int jogadaMaquina = random.nextInt(3)+1;
        if (jogadaMaquina == jogada){
        
            System.out.println("Empate");
        }else if(jogadaMaquina == 1 && jogada == 3){
            System.out.println("Vencedor Pessoa");
        }else if(jogadaMaquina == 2 && jogada == 1){
            System.out.println("Vencedor Pessoa");
        }else if(jogadaMaquina == 3 && jogada == 2){
            System.out.println("Vencedor Pessoa");
        }else{
            System.out.println("Vencedor Maquina");
        }
    }
    

}
