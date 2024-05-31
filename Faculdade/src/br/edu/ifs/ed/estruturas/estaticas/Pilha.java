package br.edu.ifs.ed.estruturas.estaticas;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public class Pilha<E> extends Colecao<E>{

    public Pilha() {
    }

    public Pilha(int capacidadeInicial, int incrementoDeCapacidade) {
        super(capacidadeInicial, incrementoDeCapacidade);
    }

    public Pilha(int capacidadeInicial) {
        super(capacidadeInicial);
    }
    
    public boolean empilhar(E elemento) {
        return adicionar(elemento,tamanho);
    }

    public E desempilhar() {
        if (estaVazia()) throw new VaziaException("Pilha Vazia");
        return remover(tamanho - 1);
    }
    
    public E topo(){
        if (estaVazia()) throw new VaziaException("Pilha Vazia");
        return elementos[tamanho - 1];
    }
    
    

}
