package jogo.structs;

import jogo.abstracts.Posicao;

/**
 *
 * @author José Gustavo
 */
public class Pilha implements Cloneable {

    public class PilhaCheiaException extends RuntimeException {

        public PilhaCheiaException() {}

        public PilhaCheiaException(String message) {super(message);}

    }

    public class PilhaVaziaException extends RuntimeException {

        public PilhaVaziaException() {}

        public PilhaVaziaException(String message) {super(message);}

    }

    public static final int CAPACIDADE_MAXIMA = 25;
    private int tamanho;
    private Posicao[] elementos;

    public Pilha() {
        tamanho = 0;
        elementos = new Posicao[CAPACIDADE_MAXIMA];
    }
    
    public Pilha(int capacidadeMaxima) {
        tamanho = 0;
        elementos = new Posicao[capacidadeMaxima];
    }

    public void empilhar(Posicao elemento) {
        if (estaCheia()) throw new PilhaCheiaException("Pilha cheia");
        elementos[tamanho++] = elemento;
    }

    public Posicao desempilhar() {
        if (estaVazia()) throw new PilhaVaziaException("Pilha Vazia");
        return elementos[--tamanho];
    }
    
    public Posicao topo(){
        if (estaVazia()) throw new PilhaVaziaException("Pilha Vazia");
        return elementos[tamanho - 1];
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaCheia() {
        return tamanho == CAPACIDADE_MAXIMA;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }
    
    @Override
    public Pilha clone(){
        try {
            @SuppressWarnings("unchecked")
            Pilha p = (Pilha) super.clone();
            p.elementos = java.util.Arrays.copyOf(elementos, tamanho);
            return p;
        } catch (CloneNotSupportedException e) {
            // Isso não deveria acontecer, já que somos clonaveis
            throw new InternalError(e);
        }
    }

    @Override
    public String toString() {
        String pilha = "Pilha{" + "tamanho = " + tamanho + ", elementos = [";
        for (int i = 0; i < tamanho; i++) {
            pilha += elementos[i] + " ";
        }
        pilha += "]}";
        return pilha;
    }

}
