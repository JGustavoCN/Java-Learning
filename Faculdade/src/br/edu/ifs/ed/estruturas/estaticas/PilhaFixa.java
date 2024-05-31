package br.edu.ifs.ed.estruturas.estaticas;

/**
 *
 * @author José Gustavo
 */
public class PilhaFixa {

    public class PilhaCheiaException extends RuntimeException {

        public PilhaCheiaException() {}

        public PilhaCheiaException(String message) {super(message);}

    }

    public class PilhaVaziaException extends RuntimeException {

        public PilhaVaziaException() {}

        public PilhaVaziaException(String message) {super(message);}

    }

    public static final int CAPACIDADE_MAXIMA = 100;
    private int tamanho;
    private int[] elementos;

    public PilhaFixa() {
        tamanho = 0;
        elementos = new int[CAPACIDADE_MAXIMA];
    }
    
    public PilhaFixa(int capacidadeMaxima) {
        tamanho = 0;
        elementos = new int[capacidadeMaxima];
    }

    public void empilhar(int elemento) {
        if (estaCheia()) throw new PilhaCheiaException("Pilha cheia");
        elementos[tamanho] = elemento;
        tamanho++;
    }

    public int desempilhar() {
        if (estaVazia()) throw new PilhaVaziaException("Pilha Vazia");
        return elementos[--tamanho];
    }
    
    public int topo(){
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
    public String toString() {
        String pilha = "Pilha{" + "tamanho = " + tamanho + ", elementos = [";
        for (int i = 0; i < tamanho; i++) {
            pilha += elementos[i] + " ";
        }
        pilha += "]}";
        return pilha;
    }

}
