package br.edu.ifs.ed.estruturas.estaticas;

import java.util.Comparator;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public class FilaComPrioridade<E> extends Fila<E>{
    
    private final Comparator<? super E> comparador;

    public FilaComPrioridade() {
        this(CAPACIDADE_PADRAO,null);
    }

    public FilaComPrioridade(int capacidadeInicial, int incrementoDeCapacidade) {
        this(capacidadeInicial, null);
        this.incrementoDeCapacidade = incrementoDeCapacidade;
    }

    public FilaComPrioridade(int capacidadeInicial) {
        this(capacidadeInicial,null);
    }
    
    public FilaComPrioridade(Comparator<? super E> comparador) {
        this(CAPACIDADE_PADRAO, comparador);
    }
    public FilaComPrioridade(int capacidadeInicial,
                         Comparator<? super E> comparador) {
        super(capacidadeInicial);
        this.comparador = comparador;
        
    }
    public Comparator<? super E> comparador() {
        return comparador;
    }
    
    /**
     *
     * @param elemento
     * @return
     * @throws ElementoNaoComparavelException
     */
    @Override
    public boolean enfileirar(E elemento) throws ElementoNaoComparavelException {
        //Objects.requireNonNull(elemento); lança nullpointer
        if (elemento == null) throw new ElementoNuloException();
        if (comparador == null || !(elemento instanceof Comparable)) throw new ElementoNaoComparavelException("Implemente Comparable ou adicione um comparador");
        if (estaCheia()) crescer();
        ajustarParaCima(tamanho, elemento);
        tamanho++;
        return true;
    }

    private void ajustarParaCima(int indice, E elemento) {
        if (comparador != null)
            ajustarParaCimaComComparador(indice, elemento, elementos, comparador);
        else
            ajustarParaCimaComparavel(indice, (Comparable) elemento, elementos);
    }
    
    private static <T extends Comparable> void ajustarParaCimaComparavel(int indice, T elemento, Object[] es) {
        while (indice > 0) {
            int pai = (indice - 1) >>> 1;
            Object e = es[pai];
            if (elemento.compareTo((T) e) >= 0)
                break;
            es[indice] = e;
            indice = pai;
        }
        es[indice] = elemento;
    }

    private static <T> void ajustarParaCimaComComparador(
            int indice, T elemento, Object[] es, Comparator<? super T> cmp
    ) {
        while (indice > 0) {
            int pai = (indice - 1) >>> 1;
            Object e = es[pai];
            if (cmp.compare(elemento, (T) e) >= 0)
                break;
            es[indice] = e;
            indice = pai;
        }
        es[indice] = elemento;
    }
    
    @Override
    public E desenfileirar() {
        if (estaVazia()) throw new VaziaException("Fila Vazia");
        
        final E resultado = elementos[0];
        final int n = --tamanho;
        final E elemento = elementos[n];
        elementos[n] = null;
        
        if (n > 0)
            ajustarParaBaixo(0,elemento);
        
        return resultado;
    }
    /**
     * Esse metodo faz trocas entre os filhos do indice e o elemento, depois vai descendo
     * continuando as trocas e organizando o heap
     * @param indice = 0
     * @param elemento = o antigo último elemento do array
     */
    private void ajustarParaBaixo(int indice, E elemento) {
        if (comparador != null)
            ajustarParaBaixoComComparador(indice, elemento, elementos, tamanho, comparador);
        else
            ajustarParaBaixoComparavel(indice, (Comparable) elemento, elementos, tamanho);
    }
    
   
    private static <T extends Comparable<T>> void ajustarParaBaixoComparavel(int indice, T elemento, Object[] es, int tamanho) {
        // garantir que tamanho > 0;
        int metade = tamanho >>> 1;       // laço enquanto não for um nó folha
        while (indice < metade) {
            int filho = (indice << 1) + 1; // assume que o filho esquerdo é o menor
            Object c = es[filho];
            int filhoDireito = filho + 1;
            if (filhoDireito < tamanho &&
                ((Comparable<? super T>) c).compareTo((T) es[filhoDireito]) > 0) // FilhoE é para ficar depois do FilhoD?
                c = es[filho = filhoDireito];
            if (elemento.compareTo((T) c) <= 0) // Chave é para ficar antes do C? True ele troca com o pai
                break;
            es[indice] = c; //Filho que vai trocar com o pai
            indice = filho;
        }
        es[indice] = elemento;
    }

    private static <T> void ajustarParaBaixoComComparador(
        int indice, T elemento, Object[] es, int tamanho, Comparator<? super T> cmp) {
        // confirmar que tamanho > 0;
        int metade = tamanho >>> 1;
        while (indice < metade) {
            int filho = (indice << 1) + 1;
            Object c = es[filho];
            int filhoDireito = filho + 1;
            if (filhoDireito < tamanho && cmp.compare((T) c, (T) es[filhoDireito]) > 0)
                c = es[filho = filhoDireito];
            if (cmp.compare(elemento, (T) c) <= 0)
                break;
            es[indice] = c;
            indice = filho;
        }
        es[indice] = elemento;
    }
    
    public static class ElementoNuloException extends IllegalArgumentException {

        public ElementoNuloException() {}

        public ElementoNuloException(String message) {super(message);}
        
    }

    public static class ElementoNaoComparavelException extends IllegalArgumentException {

        public ElementoNaoComparavelException() {super("O elemento não é comparavel, implemente a interface Comparavel nele");}

        public ElementoNaoComparavelException(String message) {super(message);}
        
    }    
}
