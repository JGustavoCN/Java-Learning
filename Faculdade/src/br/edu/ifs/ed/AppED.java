package br.edu.ifs.ed;

import java.util.Vector;

/**
 *
 * @author José Gustavo
 */
public class AppED {
    public static void main(String[] args) {
        System.out.print("Digite a capacidade do vetor: ");
        int capacidade = Entrada.teclado.nextInt();
        Vetor.criar(capacidade);
        int somatorio = Vetor.somatorio();
        System.out.println("Somatorio = "+ somatorio);
        double media = Vetor.media();
        System.out.println("Media = "+ media);
        System.out.print("Obter da posicao: ");
        int posicao = Entrada.teclado.nextInt();
        System.out.println("Valor do Vetor["+posicao+"] = "+Vetor.get(posicao));
        System.out.print("Posicao para trocar no vetor: ");
        posicao = Entrada.teclado.nextInt();
        Vetor.set(posicao);
        Vetor.substituiImparPorZero();
        System.out.println("Maior valor: "+Vetor.maiorValor());
        System.out.println("Menor valor: "+Vetor.menorValor());
        Vetor.imprimir();
    }
}
