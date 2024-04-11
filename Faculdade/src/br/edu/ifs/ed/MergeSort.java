package br.edu.ifs.ed;

import java.util.Arrays;

/**
 *
 * @author José Gustavo
 */
public class MergeSort {
    
    public static void main(String[] args) {
        int[] vetor = {9,1,8,2,3,7,4,6,5,0};
        mergeSort(vetor, 0, vetor.length);
    }
    
    public static void mergeSort(int[] vetor, int inicio, int fim){
       System.out.println("");
       imprimi(vetor);
        System.out.println("");
        if (inicio >= fim - 1) return;
        int meio = (inicio+fim)/2;
        int[] vet1 = new int[meio];
        for (int i = 0 ; i < meio; i++) {
            vet1[i] = vetor[i];
            
        }
         
             
        imprimi(vet1);
        System.out.println("");
        int[] vet2 = new int[fim - meio];
        for (int i = meio; i < fim; i++) {
            System.out.println(i-meio);
            vet2[i-meio] = vetor[i];
            
        }
        imprimi(vet2);
        
        mergeSort(vet1, inicio, meio);
        mergeSort(vet2, meio, fim);
        
    }
    
    public static int[] merge(int[] vet1, int[] vet2){
        return vet1;
    }
    public static void imprimi(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]+" ");
        }
    }
}
