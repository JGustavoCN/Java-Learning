package br.edu.ifs.ed.ordenacao;

import java.util.Arrays;

/**
 *
 * @author José Gustavo
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] vetor = {9, 1, 8, 2, 3, 7, 4, 6, 5, 0};
//        int [] vet = new int[]{9, 1, 8, 2, 3, 7, 4, 6, 5, 0};
        mergeSort(vetor, 0, vetor.length-1);
//        mergeSort(vetor, 0, vetor.length);
        imprimi(vetor);
    }

    public static void mmergeSort(int[] vetor, int inicio, int fim) {
        System.out.println("");
        imprimi(vetor);
        System.out.println("");
        if (inicio >= fim) {
            return;
        }
        int meio = (inicio + fim) / 2;
        int[] vet1 = new int[meio];
        System.arraycopy(vetor, 0, vet1, 0, meio);

        imprimi(vet1);
        System.out.println("");
        int[] vet2 = new int[fim - meio];
        for (int i = meio; i < fim; i++) {
            System.out.println(i - meio);
            vet2[i - meio] = vetor[i];

        }
        imprimi(vet2);

        mergeSort(vet1, inicio, meio);
        mergeSort(vet2, meio, fim);

    }
    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if(inicio>= fim) return;
        int meio = (inicio + fim)/2;
        mergeSort(vetor, inicio, meio);
        mergeSort(vetor, meio+1, fim);
        merge(vetor,inicio, meio, fim);
    }
    public static void merge(int[] vetor,int inicio,int meio, int fim) {
        // transfere os elementos entre inicio e fim para um array auxiliar.
        int[] helper = new int[vetor.length];
        for (int i = inicio; i <= fim; i++) {
            helper[i] = vetor[i];
        }
        
        int i = inicio;
        int j = meio + 1;
        int k = inicio;
        
        while (i <= meio && j <= fim) {
            
            if (helper[i] <= helper[j]) {
                vetor[k] = helper[i];
                i++;
            } else {
                vetor[k] = helper[j];
                j++;
            }
            k++;    
            
        }
        
        // se a metade inicial não foi toda consumida, faz o append.
        while (i <= meio) {
            vetor[k] = helper[i];
            i++;
            k++;
        }
        
        // se a metade final não foi toda consumida, faz o append.
        while (j <= fim) {
            vetor[k] = helper[j];
            j++;
            k++;
        } 
        
    }

    public static void imprimi(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
    public static void imprimi(int[] vetor, int inicio, int fim) {
        for (int i = inicio; i < fim; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}
