package br.edu.ifs.ed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author José Gustavo
 */
public class AppED {

    public static void main(String[] args) {
        int[] vetor = new int[100000];
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100);

        }
        System.out.println("== Com Flag:");
        bubbleSort(vetor);
        bubbleSort(vetor);
        System.out.println("== Sem Flag:");
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(100);

        }
        sortBubble(vetor);
        sortBubble(vetor);
        
    }

    public static void sortBubble(int[] vetor) {

        int aux;
        long fim;
        long inicio;
        inicio = System.currentTimeMillis();
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {

                if (vetor[i] > vetor[j]) {

                    aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }

            }
        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo = " + (fim - inicio));

    }

    public static void bubbleSort(int[] vetor) {
        boolean flagTroca = true;
        int aux;
        long fim;
        long inicio;
        inicio = System.currentTimeMillis();
        while (flagTroca) {
            flagTroca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {

                    flagTroca = true;
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                }
            }

        }
        fim = System.currentTimeMillis();
        System.out.println("Tempo = " + (fim - inicio));
    }

    public static int verificarVetor(int[] vetor, int num) {
        int verificacao = -1;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == num) {
                verificacao = i;
            }
        }
        return verificacao;
    }

    public static void calcularDistancia() {

        int[][] matriz = new int[5][5];
        List<Integer> percurso = new ArrayList();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz[i].length; j++) {
                System.out.print("Digite a distancia de [" + (i + 1) + "] para [" + (j + 1) + "]: ");
                matriz[i][j] = Entrada.teclado.nextInt();
                matriz[j][i] = matriz[i][j];
            }
        }
        int maxDigitos = maxDigitsMatriz(matriz);
        for (int[] vetor : matriz) {
            for (int valor : vetor) {
                System.out.printf("%" + maxDigitos + "d ", valor);
            }
            System.out.println("");
        }
        System.out.println("== Mostre seu percurso dizendo quais foram as cidades visitadas");
        System.out.println("Digite qualquer valor abaixo de 1 para encerrar o caminho");
        int cidade;
        do {
            System.out.print("Digite a cidade visitada: ");
            cidade = Entrada.teclado.nextInt();
            if (cidade <= 0) {
                break;
            }
            percurso.add(cidade);
        } while (true);
        int distancia = 0;

        for (int i = 1; i < percurso.size(); i++) {
            int linha = percurso.get(i - 1) - 1;
            int coluna = percurso.get(i) - 1;
            int tamanho = matriz[linha][coluna];
            System.out.print(tamanho + " ");
            distancia = distancia + tamanho;

        }
        System.out.println("\nDistancia percorrida: " + distancia);
    }

    /* TENTAR PEGAR OS VALORES REPETIDOS E SEPARAR UMA COPIA EM UM NOVO VETOR E 
    TBM ARMAZENAR A QUANTIDADE DE REPETICOES DE CADA
     */
    public static void testeMatriz() {
        int[][] matriz = new int[3][5];
        int indiceVetorMatriz = 0;
        int[] vetorMatriz = new int[3 * 5];
        String[] vetorRepetidos = new String[3 * 5];
        int maiorRepeticao = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = Entrada.teclado.nextInt();
                vetorMatriz[indiceVetorMatriz] = matriz[i][j];
                indiceVetorMatriz++;
            }

        }
        int maxDigits = maxDigits(vetorMatriz);
        int totalDeValores = matriz.length * matriz[0].length;
        int marcarLinha = 0;
        int quantPares = 0;
        int quantImpares = 0;
        for (int i = 0; i < totalDeValores; i++) {

            int linha = i / matriz[0].length;
            int coluna = i % matriz[0].length;

            if (linha != marcarLinha) {
                System.out.println("");
                marcarLinha++;
            }
            System.out.printf("%" + maxDigits + "d ", matriz[linha][coluna]);

            if (matriz[linha][coluna] % 2 == 0) {
                quantPares++;
            } else {
                quantImpares++;
            }

        }

        boolean temRepetido = false;

        boolean posso = false;

        int k = 0;
        for (int i = 0; i < vetorMatriz.length; i++) {

            for (int j = 0; j < vetorMatriz.length; j++) {

                if (vetorMatriz[i] == vetorMatriz[j]) {

                    for (String vetorRepetido : vetorRepetidos) {

                        if (vetorRepetido == null) {
                            posso = true;
                            break;

                        } else {

                            if (!vetorRepetido.equals(Integer.toString(vetorMatriz[i]))) {

                                posso = true;

                            } else {
                                posso = false;
                                break;
                            }

                        }
                    }
                    if (posso) {
                        maiorRepeticao++;
                        vetorRepetidos[k] = Integer.toString(vetorMatriz[i]);
                        k++;
                        break;
                    }

                }
            }

        }
        int[] vetorQuantidadeRepeticoes = new int[vetorRepetidos.length];
        k = 0;
        for (String vetorRepetido : vetorRepetidos) {
            if (vetorRepetido == null) {
                break;
            }
            for (int j = 0; j < vetorMatriz.length; j++) {
                if (vetorRepetido.equals(Integer.toString(vetorMatriz[j]))) {
                    vetorQuantidadeRepeticoes[k]++;
                }
            }
            k++;
        }
        maiorRepeticao = vetorQuantidadeRepeticoes[0];
        for (int i = 1; i < vetorQuantidadeRepeticoes.length; i++) {
            if (maiorRepeticao < vetorQuantidadeRepeticoes[i]) {
                maiorRepeticao = vetorQuantidadeRepeticoes[i];
                if (maiorRepeticao > 2) {
                    temRepetido = true;
                }
            }

        }
        System.out.println("\nTem repetido? " + ((temRepetido) ? "Sim" : "Não"));
        System.out.println("Quantidade pares: " + quantPares);
        System.out.println("Quantidade impares: " + quantImpares);
        System.out.println("Maior quantidade de repeticoes: " + maiorRepeticao);

        System.out.print("Valor unico: ");
        for (String vetorRepetido : vetorRepetidos) {
            if (vetorRepetido != null) {
                System.out.printf("%" + maxDigits + "s ", vetorRepetido);
            }
        }
        System.out.println("");
        System.out.print("Repeticoes:  ");
        for (int i = 0; i < vetorQuantidadeRepeticoes.length; i++) {
            if (vetorQuantidadeRepeticoes[i] != 0) {
                System.out.printf("%" + maxDigits + "d ", vetorQuantidadeRepeticoes[i]);
            }

        }
        System.out.println("");

    }

    private static int maxDigitsMatriz(int[][] matriz) {
        int max = 0;
        for (int[] vetor : matriz) {
            for (int num : vetor) {
                int digits = (int) Math.log10(num) + 1;
                max = Math.max(max, digits);
            }

        }
        return max;
    }

    private static int maxDigits(int[] vetor) {
        int max = 0;
        for (int num : vetor) {
            int digits = (int) Math.log10(num) + 1;
            max = Math.max(max, digits);
        }
        return max;
    }

    private static int maxDigits(String[] vetor) {
        int max = 0;
        for (String num : vetor) {
            if (num == null) {
                break;
            }
            int digits = num.length();
            max = Math.max(max, digits);
        }
        return max;
    }

    public static void testeVetorAluno() {
        Aluno[] turma = new Aluno[2];
        String nome;
        double nota1;
        double nota2;
        for (int i = 0; i < turma.length; i++) {
            System.out.println("== Cadastrar Turma ==");
            System.out.println("-> Aluno");
            System.out.print("Digite o nome: ");
            nome = Entrada.teclado.next();
            System.out.print("Digite a nota 1: ");
            nota1 = Entrada.teclado.nextDouble();
            System.out.print("Digite o nota 2: ");
            nota2 = Entrada.teclado.nextDouble();
            turma[i] = new Aluno(nome, nota1, nota2);
        }
        System.out.println("== Todos os Alunos");
        for (Aluno aluno : turma) {
            System.out.println(aluno.getNome() + " está com média " + aluno.calcularMedia());
        }

        System.out.println("== Procurar aluno");
        System.out.print("Qual o nome do aluno: ");
        nome = Entrada.teclado.next();
        for (Aluno aluno : turma) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno: " + aluno.getNome() + " -> Média: " + aluno.calcularMedia());
            }

        }
        int alunosAbaixoDaMedia = 0;
        for (Aluno aluno : turma) {
            if (aluno.calcularMedia() < 6) {
                alunosAbaixoDaMedia++;
            }
        }
        System.out.println("Quantidade de alunos abaixo da média: " + alunosAbaixoDaMedia);

    }

    public static void testeVetorAutomovel() {
        System.out.print("Numeros de carros para cadastrar: ");
        int quantidade = Entrada.teclado.nextInt();
        Automovel[] automoveis = new Automovel[quantidade];
        String nome;
        String marca;
        String cor;
        for (int i = 0; i < automoveis.length; i++) {
            System.out.println("== Cadastro automovel n° " + (i + 1));
            System.out.print("Digite o nome: ");
            nome = Entrada.teclado.next();
            System.out.print("Digite a marca: ");
            marca = Entrada.teclado.next();
            System.out.print("Digite a cor: ");
            cor = Entrada.teclado.next();
            automoveis[i] = new Automovel(nome, marca, cor);

        }
        System.out.println("== Carros Cadastrados ==");
        for (Automovel automovel : automoveis) {
            System.out.println(automovel);
        }
    }

    public static void testeClasseVetor() {
        System.out.print("Digite a capacidade do vetor: ");
        int capacidade = Entrada.teclado.nextInt();
        Vetor.criar(capacidade);
        Vetor.imprimir();
        int somatorio = Vetor.somatorio();
        System.out.println("Somatorio = " + somatorio);
        double media = Vetor.media();
        System.out.println("Media = " + media);
        System.out.print("Obter da posicao: ");
        int posicao = Entrada.teclado.nextInt();
        System.out.println("Valor do Vetor[" + posicao + "] = " + Vetor.pegar(posicao));
        System.out.print("Posicao para trocar no vetor: ");
        posicao = Entrada.teclado.nextInt();
        System.out.print("Valor para colocar: ");
        int valor = Entrada.teclado.nextInt();
        Vetor.colocar(posicao, valor);
        Vetor.imprimir();
        System.out.println("Substituir o valor impar por zero");
        Vetor.substituirValorImparPorZero();
        Vetor.imprimir();
        System.out.println("Maior valor: " + Vetor.maiorValor());
        System.out.println("Menor valor: " + Vetor.menorValor());
        System.out.println("Substituir a posicao impar por zero");
        Vetor.substituirPosicaoImparPorZero();
        Vetor.imprimir();
    }

}
