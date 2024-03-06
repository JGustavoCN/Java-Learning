package br.edu.ifs.ed;

import static br.edu.ifs.ed.Entrada.*;

/**
 *
 * @author Aluno
 */
public class Vetor {

    protected static int vetor[];

    public static void criar(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade ilegal -> " + capacidade);
        }
        vetor = new int[capacidade];
        System.out.println("Vetor de tamanho " + capacidade + " criado!!!");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("[ ] ");

        }
        System.out.println("\n-- Preencha o vetor --");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Posição [" + i + "]" + " -> Digite um numero: ");
            vetor[i] = teclado.nextInt();
        }
        imprimir();
    }

    public static int somatorio() {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma = soma + vetor[i];

        }
        return soma;
    }

    public static double media() {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma = soma + vetor[i];

        }
        double media = (double) soma / vetor.length;
        return media;
    }
    
    public static int get(int posicao){
        return vetor[posicao];
    }
    
    public static void set(int posicao){
        imprimir();
        System.out.print("Posição [" + posicao + "]" + " -> Digite um numero: ");
        vetor[posicao] = teclado.nextInt();
        imprimir();
        
    }
    
    public static void substituiImparPorZero(){
        imprimir();
        for (int i = 0; i < vetor.length; i++) if (vetor[i]%2 != 0) vetor[i] = 0;
        imprimir();
    }
    
    public static int maiorValor(){
        int maior = vetor[0];
        for (int valor: vetor) if (valor > maior) maior = valor;
        return maior;
    }
    public static int menorValor(){
        int menor = vetor[0];
        for (int valor: vetor) if (valor < menor) menor = valor;
        return menor;
    }
    
    public static void imprimir(){
        if (vetor == null) throw new IllegalArgumentException("Não existe vetor");
        System.out.println("== Vetor ==");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("[" + vetor[i] + "] ");

        }
        System.out.println("");
    }
}
