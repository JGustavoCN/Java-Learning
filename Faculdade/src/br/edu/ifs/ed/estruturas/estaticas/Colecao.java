package br.edu.ifs.ed.estruturas.estaticas;

import java.util.Arrays;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public abstract class Colecao<E> {
    
    protected static final int CAPACIDADE_PADRAO = 11;
    
    //No collections usam um array de objects
    protected E[] elementos;
    protected int tamanho;
    protected int incrementoDeCapacidade;
    
    public Colecao(){
        this(CAPACIDADE_PADRAO);
    }
    
    public Colecao(int capacidadeInicial, int incrementoDeCapacidade){
        super();
        this.elementos = (E[]) new Object[capacidadeInicial];
        this.incrementoDeCapacidade = incrementoDeCapacidade;
    }
    
    public Colecao(int capacidadeInicial){
        this(capacidadeInicial,0);
    }
    
    /*usado quando o vetor interno não é de tipo generic
     E elementos(int indice) {
        return (E) elementos[indice];
    }
    */
    
    public int tamanho() {
        return tamanho;
    }
    
    public boolean estaVazia() {
        return tamanho == 0;
    }
    
    protected boolean estaCheia() {
        return tamanho == elementos.length;
    }
    
    //Metodos para aumentar a capacidade melhorado e detalhado
    private Object[] crescer(int minimaCapacidade){
        return elementos = Arrays.copyOf((E[])elementos,novaCapacidade(minimaCapacidade));
    }
    
    protected Object[] crescer(){
        return crescer(tamanho + 1);
    }
    
    private static final int TAMANHO_MAXIMO_VETOR = Integer.MAX_VALUE - 8;
    
    private int novaCapacidade(int minimaCapacidade){
        // overflow-consciente codigo e o crescimento do vetor é flexivel (não somente duplicar a capacidade)
        int antigaCapacidade = elementos.length;
        int novaCapacidade = antigaCapacidade + ((incrementoDeCapacidade > 0) ?
                                         incrementoDeCapacidade : antigaCapacidade);
        if (novaCapacidade - minimaCapacidade <= 0) {
            if (minimaCapacidade < 0) // overflow : pode ocorrer se acontecer um overflow no limite do tipo int tornando negativo
                throw new Vetor.FaltaDeMemoriaError("Overflow no limite do Vetor");
            return minimaCapacidade;
        }
        return (novaCapacidade - TAMANHO_MAXIMO_VETOR <= 0)
            ? novaCapacidade
            : capacidadeExtrema(minimaCapacidade);
    }
    
    private static int capacidadeExtrema(int minimaCapacidade) {
        if (minimaCapacidade < 0) throw new FaltaDeMemoriaError("Overflow no limite do Vetor");
        return (minimaCapacidade > TAMANHO_MAXIMO_VETOR) ?
            Integer.MAX_VALUE :
            TAMANHO_MAXIMO_VETOR;
    }
    
    protected boolean adicionar(E elemento, int indice){
        if (estaCheia()) crescer();
        // Modificar a ficar parecido com a classe vector
        for (int i = tamanho-1; i >=indice; i--) {
            elementos[i+1]=elementos[i];
        }
        elementos[indice] = elemento;
        tamanho++;
        return true;
    }
    
    protected E remover(int indice){
        
        E elementoAntigo = elementos[indice];
        int numerosMovidos = tamanho - indice - 1;
        if (numerosMovidos> 0)
            System.arraycopy(elementos, indice+1, elementos, indice,
                             numerosMovidos);
        elementos[--tamanho] = null; // Deixe o gc fazer o seu trabalho
        return elementoAntigo;
    }
    
    public void limpar(){
        final E[] ElementosED = this.elementos;
        for (int to = tamanho, i = tamanho = 0; i < to; i++)
            ElementosED[i] = null;
    }

    @Override
    public String toString() {
        
        if (!estaVazia()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < tamanho; i++) {
                sb.append(elementos[i]);
                if (i == tamanho - 1) {
                    return sb.append(']').toString();
                }else{
                    sb.append(',').append(' ');
                }
            }
        }
        return "[]";
    }
    
    public static class FaltaDeMemoriaError extends IllegalArgumentException {

        public FaltaDeMemoriaError() {}

        public FaltaDeMemoriaError(String message) {super(message);}

    }
    
    public static class VaziaException extends RuntimeException {

        public VaziaException() {}

        public VaziaException(String message) {super(message);}
        
    }
    
}
