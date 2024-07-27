package br.edu.ifs.ed.estruturas.estaticas;

import br.edu.ifs.ed.estruturas.VaziaException;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public class Fila<E> extends Colecao<E>{

    public Fila() {
        super();
    }

    public Fila(int capacidadeInicial, int incrementoDeCapacidade) {
        super(capacidadeInicial, incrementoDeCapacidade);
    }

    public Fila(int capacidadeInicial) {
        super(capacidadeInicial);
    }
    
    public boolean enfileirar(E elemento){
        return super.adicionar(elemento, tamanho);
    }
    
    public E desenfileirar(){
        if (estaVazia()) throw new VaziaException("Fila Vazia");
        return remover(0);
    }
    
    public E verPrimeiro(){
        if(estaVazia()) throw new VaziaException("Fila Vazia");
        return elementos[0];
    }
    
}
