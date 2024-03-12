package br.edu.ifs.ed;

import java.util.Vector;

/**
 *
 * @author José Gustavo
 */
public class AppED {

    public static void main(String[] args) {
        testeMatriz();
    }

    /* TENTAR PEGAR OS VALORES REPETIDOS E SEPARAR UMA COPIA EM UM NOVO VETOR E 
    TBM ARMAZENAR A QUANTIDADE DE REPETICOES DE CADA
    
        Crie em Java uma matriz 3x5 de inteiros,
preencha a matriz e depois:
a) Informe se a matriz possui elementos
repetidos;
b) A quantidade de números pares;
c) A quantidade de números ímpares
     */
    public static void testeMatriz() {
        int[][] matriz = new int[3][5];
        int indiceVetorMatriz = 0;
        int[] vetorMatriz = new int[3 * 5];
        int[] vetorRepetidos = new int[3 * 5];
        int countRepetidos = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = Entrada.teclado.nextInt();
                vetorMatriz[indiceVetorMatriz] = matriz[i][j];
                indiceVetorMatriz++;
            }
            
        }
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
            System.out.print(matriz[linha][coluna] + " ");
            
            if (matriz[linha][coluna] % 2 == 0){
                quantPares++;
            }else{
                quantImpares++;
            }
            
        }
        
        boolean temRepetido = false; 
        for (int i = 0; i < vetorMatriz.length; i++) {
            
            for (int j = 0; j < vetorMatriz.length; j++) {
                if (vetorMatriz[i] == vetorMatriz[j]) {
                    for (int k = 0; k < vetorRepetidos.length; k++) {
                        
                    }
                    temRepetido = true;
                }
            }
            
        }
        System.out.println("\nTem repetido? "+ ((temRepetido)?"Sim":"Não"));
        System.out.println("Quantidade pares: "+ quantPares);
        System.out.println("Quantidade impares: "+ quantImpares);
        System.out.println("\nQuantidade de repetidos: "+ countRepetidos);
        for (int repetido : vetorRepetidos) {
            System.out.print(repetido+" ");
        }
        
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
