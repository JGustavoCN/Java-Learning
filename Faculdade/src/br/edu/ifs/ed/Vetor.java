package br.edu.ifs.ed;

import static br.edu.ifs.ed.Entrada.*;

/**
 *
 * @author José Gustavo
 */
public class Vetor {

    private static int vetor[];
    
    public static int capacidade;
    
    public static void criar(int capacidade) {
        if (capacidade <= 0) throw new IllegalArgumentException("Capacidade ilegal -> " + capacidade);
        
        vetor = new int[capacidade];
        Vetor.capacidade = vetor.length;
        System.out.println("Vetor de tamanho " + capacidade + " criado!!!");
        for (int i = 0; i < vetor.length; i++)System.out.print("[ ] ");
        
        System.out.println("\n-- Preencha o vetor --");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Posição [" + i + "]" + " -> Digite um numero: ");
            vetor[i] = teclado.nextInt();
        }
    }

    public static int somatorio() {
        if (eInexistente()) throw new IllegalArgumentException("Não existe vetor");
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) soma = soma + vetor[i];
        return soma;
    }

    public static double media() {return (double)somatorio()/vetor.length;}
    
    public static int pegar(int posicao) {
        if (eInexistente()) throw new IllegalArgumentException("Não existe vetor");
        if (vetor.length < posicao || posicao < 0) throw new ArrayIndexOutOfBoundsException("Posição "+posicao+" fora dos limites da capacidade ("+capacidade+")");
        return vetor[posicao];
    }
    
    public static void colocar(int posicao, int valor){
        if (eInexistente()) throw new IllegalArgumentException("Não existe vetor");
        if (vetor.length < posicao || posicao < 0) throw new ArrayIndexOutOfBoundsException("Posição "+posicao+" fora dos limites da capacidade ("+capacidade+")");
        vetor[posicao] = valor;
    }
    
    public static void substituirValorImparPorZero() {for (int i = 0; i < vetor.length; i++) if (vetor[i]%2 != 0) vetor[i] = 0;}
    
    public static void substituirPosicaoImparPorZero() {for (int i = 1; i < vetor.length; i = i + 2) vetor[i] = 0;}
    
    public static int maiorValor(){
        if (eInexistente()) throw new IllegalArgumentException("Não existe vetor");
        int maior = vetor[0];
        for (int valor: vetor) if (valor > maior) maior = valor;
        return maior;
    }
    public static int menorValor(){
        if (eInexistente()) throw new IllegalArgumentException("Não existe vetor");
        int menor = vetor[0];
        for (int valor: vetor) if (valor < menor) menor = valor;
        return menor;
    }
    
    public static void imprimir(){
        if (eInexistente()) throw new IllegalArgumentException("Não existe vetor");
        System.out.println("== Vetor ==");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("[" + vetor[i] + "] ");

        }
        System.out.println("");
    }
    
    public static boolean eInexistente(){return vetor == null;}
    
}
