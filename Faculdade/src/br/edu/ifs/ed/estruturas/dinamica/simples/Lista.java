package br.edu.ifs.ed.estruturas.dinamica.simples;

import br.edu.ifs.ed.estruturas.IndiceForaDoLimiteException;
import br.edu.ifs.ed.estruturas.VaziaException;
import java.util.LinkedList;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public class Lista<E> {
    
    private No<E> primeiro;
    private No<E> ultimo;
    private int tamanho;

    private static final int NAO_ENCONTRADO = -1; 
    
    public Lista() {
    }

    public boolean adicionar(E elemento) {
        return adicionarUltimo(elemento);
    }
    
    public boolean adicionarUltimo(E elemento) {
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
    
    
    public boolean adicionarPrimeiro(E elemento) {
        primeiro = new No(elemento, primeiro);
        if (estaVazia()) ultimo = primeiro;
        tamanho++;
        return true;
    }

    public boolean adicionar(E elemento, int indice){
        verificarElemento(indice);
        if (indice == 0) return adicionarPrimeiro(elemento);
        if(indice == tamanho) return adicionarUltimo(elemento);
        
        No<E> anterior = pegarNo(indice-1);
        No<E> proximo = anterior.getProximo();
        anterior.setProximo(new No(elemento, proximo));
        tamanho++;
        return true;
    }
    
    public E remover() {
        return removerInicio();
    }
    
    public E remover(int indice) {
        verificarIndice(indice);
        if(indice == 0) return removerInicio();
        if(indice == tamanho-1) return removerUltimo();
        final No<E> anterior = pegarNo(indice-1);
        final No<E> removido = anterior.getProximo().recortar();
        final No<E> proximo = removido.getProximo();
        anterior.setProximo(proximo);
        tamanho--;
        return removido.getElemento();
    }
    
    public E remover(E elemento) {
        return remover(indiceDe(elemento));
    }
    
    public E removerInicio() {
        if (estaVazia()) throw new VaziaException("Fila Vazia");
        final No<E> no = primeiro.recortar();
        primeiro = no.getProximo();
        tamanho--;
        if (estaVazia()) ultimo = null;
        return no.getElemento();
    }
    
    public E removerUltimo() {
        if (estaVazia()) throw new VaziaException("Fila Vazia");
        if (tamanho == 1) return remover();
        final No<E> anterior = pegarNo(tamanho-2);
        final E removido = this.ultimo.recortar().getElemento();
        this.ultimo = anterior;
        ultimo.setProximo(null);
        tamanho--;
        return removido;
    }
    
    public E pegar(int indice){
        verificarIndice(indice);
        return pegarNo(indice).getElemento();
    }
    
    public E pegarPrimeiro(){
        final No<E> f = primeiro;
        if (f == null) throw new VaziaException();
        return f.getElemento();
    }
    
    public E pegarUltimo(){
        final No<E> l = primeiro;
        if (estaVazia()) throw new VaziaException();
        return l.getElemento();
    }
    
    private No<E> pegarNo(int indice){
        verificarIndice(indice);
        if (indice == 0) return primeiro;
        if (indice == tamanho-1) return ultimo;
        No<E> atual = primeiro;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }
    
    public int indiceDe(E elemento){
        No atual = primeiro;
        int indice = 0;
        if (elemento == null) {
            for (; atual != null; atual = atual.getProximo()) {
                if (atual.getElemento() == null)
                    return indice;
                indice++;
            }
        } else {
            for (; atual != null; atual = atual.getProximo()) {
                if (elemento.equals(atual.getElemento()))
                    return indice;
                indice++;
            }
        }
        return NAO_ENCONTRADO;
    }
    
    public void limpar() {
        for (No atual = primeiro; atual != null; atual = atual.recortar().getProximo()){}
        primeiro = ultimo = null;
        tamanho = 0;
    }

    public boolean contem(E elemento){
        return indiceDe(elemento)>=0;
    }
    
    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void verificarIndice(int indice){
        if(!(indice >= 0 && indice < this.tamanho)) throw new IndiceForaDoLimiteException(indice);
    }
    
    public void verificarElemento(int indice){
        if(!(indice >= 0 && indice <= this.tamanho)) throw new IndiceForaDoLimiteException(indice);
    }
    
    @Override
    public String toString() {
        if (estaVazia() || primeiro == null) return "[]";
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(primeiro.getElemento());
        No<E> no = primeiro;
        while (no.getProximo() != null) {
            no = no.getProximo();
            sb.append(", ").append(no.getElemento());
        }
        return sb.append("]").toString();
    }
}
