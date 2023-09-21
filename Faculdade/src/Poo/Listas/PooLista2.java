package poo.listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author José Gustavo
 */
public class PooLista2 {

    private static final Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // 1
        System.out.println("----> Calculadora");
        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Quantos numeros deseja adcionar: ");
                int quantidade = Integer.parseInt(teclado.nextLine());
                if (quantidade == 0) break;
                double[] numeros = new double[quantidade];
                for (int j = 0; j < numeros.length; j++) {
                    System.out.print("Digite um numero: ");
                    numeros[j] = Double.parseDouble(teclado.nextLine());
                }
                Calculadora(numeros);
            } catch (DivisaoPorZeroException e) {
                e.printStackTrace();
            }
        }
        
        // 2
        System.out.print("Digite um numero de 1 a 7 para converter para o dia da semana: ");
        numeroParaDiaSemana(Integer.parseInt(teclado.nextLine()));
        
        // 3
        System.out.print("Digite um numero que correpsonde a um mes para descobrir a estacao dele: ");
        estacaoDoMes(Integer.parseInt(teclado.nextLine()));
        
        // 4   
        System.out.print("Digite sua idade para descobrir a Faixa Etaria: ");
        ImprimeFaixaEtaria(Integer.parseInt(teclado.nextLine()));
        
        // 5
        System.out.print("Digite a nota para descobrir o conceito: ");
        notaParaConceito(Integer.parseInt(teclado.nextLine()));
        
        // 6
        System.out.print("Menu Produtos");
        List<String> produtos = new ArrayList();
        menuProdutos(produtos);
        
        // 7
        jogoPedraPapelTesoura();
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
     * Os numeros passados serão afetados apenas por uma operacão. As operações
     * seguirão a ordem que foram adiconados os numeros.
     * A operacao de divisao não aceita numero zero
     * @param numerosInteiros
     * @throws Domain.PooLista2.DivisaoPorZeroException
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
                    if (numero == 0) throw new DivisaoPorZeroException("Existe um numero zero dentro dos parametros");
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

    protected enum DiaSemana {DOMINGO, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO}

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
            default:
                System.out.println("Ocorreu algum erro: method numeroParaDiaSemana");
                return null;

        }
        
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

    protected enum FaixaEtaria {CRIANCA, ADOLESCENTE, ADULTO, IDOSO }

    private static FaixaEtaria idadeParaFaixaEtaria(int idade) {

        if (idade > 150) throw new IllegalArgumentException("Idade muito alta (Acima de 150 anos)");
        if (idade < 0) throw new IllegalArgumentException("Idade invalida (Abaixa de 0 anos)");

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

    public static void ImprimeFaixaEtaria(int idade) {

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

    protected enum Conceitos {A, B, C, D, F}

    public static void notaParaConceito(int nota) {
        // 5 - Crie um programa que converta uma nota numérica (0-100) para um conceito (A, B, C, D, F).
        // Utilize switch-case para determinar a letra correspondente à nota inserida kek.
        if (nota < 0 || nota > 100) throw new IllegalArgumentException("Nota invalida");
        Conceitos conceito;
        switch (nota / 10) {
            case 10: 
            case 9:
                conceito =  Conceitos.A;
                break;
            case 8:
                conceito = Conceitos.B;
                break;
            case 7:
                conceito = Conceitos.C;
                break;
            case 6:
                conceito = Conceitos.D;
                break;
            default:
                conceito = Conceitos.F;
                break;
        }
        System.out.println("Conceito: "+conceito.toString());
    }

    public static void menuProdutos(List<String> produtos) {
        // 6 - Desenvolva um programa que apresente um menu com várias opções (por exemplo, "1. Listar produtos", "2. Adicionar produto", "3. Remover produto").
        // Use switch-case para lidar com a escolha do usuário e executar a ação correspondente.
        int opcao;
        do {
            System.out.println("");
            System.out.println(
                      "1. Listar produtos\n"
                    + "2. Adicionar produto\n"
                    + "3. Remover produto\n"
                    + "4. Sair\n"
            );
            System.out.print("Escolha uma opcao: ");
            opcao = Integer.parseInt(teclado.nextLine());
            if (opcao < 1 || opcao > 4) throw new IllegalArgumentException("Opcao do Menu Invalida");
            switch (opcao) {
                case 1:
                    if (produtos.isEmpty()){
                        System.out.println("Não têm produtos");
                        break;
                    }
                    System.out.print("Lista dos Produtos: ");
                    for (String produto : produtos) {
                        System.out.print(produto + ", ");
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
        } while (opcao != 4);

    }

    public static void jogoPedraPapelTesoura() {
        // 7 - Implemente um jogo simples de pedra, papel e tesoura onde o usuário escolhe uma 
        // das opções e o programa escolhe outra aleatoriamente.
        // Utilize switch-case para determinar o vencedor da rodada.
        System.out.println("   Tipos de Jogadas\n"
                + "(1) Pedra\n"
                + "(2) Tesoura\n"
                + "(3) Papel");
        System.out.print("Escolha sua jogada: ");
        int jogada = Integer.parseInt(teclado.nextLine());
        Random random = new Random();
        int jogadaMaquina = random.nextInt(3) + 1;
        System.out.println("Jogada da Maquina: " + jogadaMaquina);
        switch (jogada) {
            case 1:
                switch (jogadaMaquina) {
                    case 1:
                        System.out.println("Empate");
                        break;
                    case 2:
                        System.out.println("Voce Venceu");
                        break;
                    case 3:
                        System.out.println("Voce Perdeu");
                        break;
                }
                break;
            case 2:
                switch (jogadaMaquina) {
                    case 1:
                        System.out.println("Voce Perdeu");
                        break;
                    case 2:
                        System.out.println("Empate");
                        break;
                    case 3:
                        System.out.println("Voce Venceu");
                        break;

                }
                break;
            case 3:
                switch (jogadaMaquina) {
                    case 1:
                        System.out.println("Voce Venceu");
                        break;
                    case 2:
                        System.out.println("Voce Perdeu");
                        break;
                    case 3:
                        System.out.println("Empate");
                        break;

                }
                break;
            default:
                throw new IllegalArgumentException("Jogada invalida");
        }
        
        System.out.print("Quer continuar?(S/N): ");
        Character escolha = teclado.nextLine().charAt(0);
        if(escolha.toString().equalsIgnoreCase("S")){
            jogoPedraPapelTesoura();
        } else{
            System.out.println("Obrigado por jogar!!");
        }
        
    }

}
