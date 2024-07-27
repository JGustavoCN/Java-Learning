package br.edu.ifs.ed.estruturas.dinamica.simples;

import br.edu.ifs.ed.estruturas.VaziaException;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public class Fila<E> {

    private No<E> primeiro;
    private No<E> ultimo;
    private int tamanho;

    public Fila() {
    }

    public boolean enfileirar(E elemento) {
        No<E> no = new No(elemento);
        if (estaVazia()) {
            primeiro = no;
        } else {
            ultimo.setProximo(no);
        }
        ultimo = no;
        tamanho++;
        return true;
    }

    private void add(E elemento){
        // Forma sem saber o ultimo No
        if (estaVazia()) {
            primeiro = new No(elemento);
        } else {
            No<E> no = primeiro;
            for (int i = 1; i < tamanho; i++) {
                no = no.getProximo();
            }
            no.setProximo(new No(elemento));
        }
    }
    
    public E desenfileirar() {
        if (estaVazia()) throw new VaziaException("Fila Vazia");
        E elemento = primeiro.getElemento();
        No no = primeiro;
        primeiro = primeiro.getProximo();
        no.setElemento(null);
        no.setProximo(null);
        return elemento;
    }

    public E primeiro() {
        if (estaVazia()) {
            throw new VaziaException("Fila Vazia");
        }
        return primeiro.getElemento();
    }
    
    public void limpar(){
        No no = primeiro;
        primeiro = null;
        ultimo = null;
        tamanho = 0;
        for (int i = 0; i < tamanho; i++) {
            no.setElemento(null);
            No no2 = no.getProximo();
            no.setProximo(null);
            no = no2;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(primeiro.getElemento());
        No<E> no = primeiro;
        while (no.getProximo() != null) {
            no = no.getProximo();
            sb.append(",").append(no.getElemento());
        }
        return sb.append("]").toString();
    }
}
