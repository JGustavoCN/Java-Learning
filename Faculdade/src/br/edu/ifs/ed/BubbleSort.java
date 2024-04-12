package br.edu.ifs.ed;

import java.util.Random;

/**
 *
 * @author José Gustavo
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] vetor = new int[10000];
        Random random = new Random();
        long inicio;
        long fim;
        
        for (int i = 0; i < vetor.length; i++) vetor[i] = random.nextInt(99);
        inicio = System.currentTimeMillis();
        BubbleSort.todos(vetor);
        fim = System.currentTimeMillis();
        System.out.println("Tempo = "+(fim-inicio));
        
        
        for (int i = 0; i < vetor.length; i++) vetor[i] = random.nextInt(99);
        inicio = System.currentTimeMillis();
        BubbleSort.vizinho(vetor);
        fim = System.currentTimeMillis();
        System.out.println("Tempo = "+(fim-inicio));
        
        for (int i = 0; i < vetor.length; i++) vetor[i] = random.nextInt(99);
        inicio = System.currentTimeMillis();
        BubbleSort.vizinho2(vetor);
        fim = System.currentTimeMillis();
        System.out.println("Tempo = "+(fim-inicio));
        
        
        System.out.println(Character.getNumericValue('a'));
        System.out.println(((char)(122)));
        
        
        char[] vetorChar = new char[10000];
        for (int i = 0; i < vetorChar.length; i++){
            vetorChar[i] = (char) (97+random.nextInt(26));
        }
        inicio = System.currentTimeMillis();
        BubbleSort.alfabeticaChar(vetorChar);
        fim = System.currentTimeMillis();
        System.out.println("Tempo = "+(fim-inicio));
        
        String[] vetorString = new String[10000];
        for (int i = 0; i < vetorString.length; i++){
            vetorString[i] = Character.toString((char) (97+random.nextInt(26)));
            for (int j = 1; j < 10; j++) {
                vetorString[i] += Character.toString((char) (97+random.nextInt(26)));
            }
            
        }
        
        inicio = System.currentTimeMillis();
        BubbleSort.alfabeticaString(vetorString);
        fim = System.currentTimeMillis();
        System.out.println("Tempo = "+(fim-inicio));
        
        for (int i = 0; i < vetorString.length; i++){
            vetorString[i] = Character.toString((char) (97+random.nextInt(26)));
            for (int j = 1; j < 10; j++) {
                vetorString[i] += Character.toString((char) (97+random.nextInt(26)));
            }
            
        }
        
        inicio = System.currentTimeMillis();
        BubbleSort.vizinhoAlfabeticaString(vetorString);
        fim = System.currentTimeMillis();
        System.out.println("Tempo = "+(fim-inicio));
        
    }

    public static void todos(int[] vetor) {
        int aux;
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] > vetor[j]) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }

            }
        }
    }

    public static void vizinho(int[] vetor) {
        int aux;
        boolean troca = true;
        while (troca) {
            troca = false;
            for (int j = 0; j < vetor.length - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    troca = true;
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }

            }
        }

    }
    public static void vizinho2(int[] vetor) {
        int aux;
        boolean troca;
        for (int i = 0; i < vetor.length; i++) {
            troca = false;
            for (int j = 0; j < vetor.length - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    troca = true;
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }

            }
            if (!troca) break;
        }

    }
    public static void alfabeticaChar(char[] vetor){
        char aux;
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (Character.compare(vetor[i], vetor[j]) > 0) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }

            }
        }
    }
    public static void alfabeticaString(String[] vetor){
        String aux;
        
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i].compareToIgnoreCase(vetor[j])  > 0) {
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }

            }
        }
    }
    public static void vizinhoAlfabeticaString(String[] vetor){
        String aux;
        
        boolean troca = true;
        while (troca) {
            troca = false;
            for (int j = 0; j < vetor.length - 1; j++) {
                if (vetor[j].compareToIgnoreCase(vetor[j+1])  > 0) {
                    troca = true;
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }

            }
        }
        
    }
    
    public static void imprimir(char[] vetor) {
        for (char i : vetor) {
            System.out.print(i + ", ");
        }
    }
    public static void imprimir(int[] vetor) {
        for (int i : vetor) {
            System.out.print(i + ", ");
        }
    }
    public static void imprimir(Object[] vetor) {
        for (Object i : vetor) {
            System.out.print(i + ", ");
        }
    }

}
