package br.edu.ifs.ed.estruturas.estaticas;

import java.util.Comparator;

/**
 *
 * @author José Gustavo
 * @param <E>
 */
public class FilaComPrioridade<E> extends Fila<E>{
    
    private Comparator comparador;

    public FilaComPrioridade() {
    }

    public FilaComPrioridade(int capacidadeInicial, int incrementoDeCapacidade) {
        super(capacidadeInicial, incrementoDeCapacidade);
    }

    public FilaComPrioridade(int capacidadeInicial) {
        super(capacidadeInicial);
    }
    
    /**
     *
     * @param elemento
     * @return
     * @throws ElementoNaoComparavelException
     */
    @Override
    public boolean enfileirar(E elemento) throws ElementoNaoComparavelException {
        if (elemento == null) throw new ElementoNuloException();
        if (!(elemento instanceof Comparable)) throw new ElementoNaoComparavelException();
        if (estaCheia()) crescer();
        ajustarParaCima(tamanho, elemento);
        tamanho++;
        return true;
    }

    private void ajustarParaCima(int indice, E elemento) {
        if (comparador != null)
            ajustarParaCimaComComparador(indice, elemento, elementos, comparador);
        else
            ajustarParaCimaComparavel(indice, elemento, elementos);
    }
    
    private static <T> void ajustarParaCimaComparavel(int indice, T elemento, Object[] es) {
        Comparable<? super T> chave = (Comparable<? super T>) elemento;
        while (indice > 0) {
            int pai = (indice - 1) >>> 1;
            Object e = es[pai];
            if (chave.compareTo((T) e) >= 0)
                break;
            es[indice] = e;
            indice = pai;
        }
        es[indice] = chave;
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
        final E resultado;

        if ((resultado = elementos[0]) != null) {
            final int n;
            final E elemento = (E) elementos[(n = --tamanho)];
            elementos[n] = null;
            ajustarParaBaixo(n, elemento);
        }
        return resultado;
    }
    
    private void ajustarParaBaixo(int indice, E elemento) {
        if (comparador != null)
            ajustarParaBaixoComComparador(indice, elemento, elementos, tamanho, comparador);
        else
            ajustarParaBaixoComparavel(indice, elemento, elementos, tamanho);
    }

    private static <T> void ajustarParaBaixoComparavel(int indice, T elemento, Object[] es, int n) {
        // assert n > 0;
        Comparable<? super T> chave = (Comparable<? super T>) elemento;
        int metade = n >>> 1;           // loop while a non-leaf
        while (indice < metade) {
            int filho = (indice << 1) + 1; // assume left filho is least
            Object c = es[filho];
            int direito = filho + 1;
            if (direito < n &&
                ((Comparable<? super T>) c).compareTo((T) es[direito]) > 0)
                c = es[filho = direito];
            if (chave.compareTo((T) c) <= 0)
                break;
            es[indice] = c;
            indice = filho;
        }
        es[indice] = chave;
    }

    private static <T> void ajustarParaBaixoComComparador(
        int indice, T elemento, Object[] es, int n, Comparator<? super T> cmp) {
        // assert n > 0;
        int metade = n >>> 1;
        while (indice < metade) {
            int filho = (indice << 1) + 1;
            Object c = es[filho];
            int direito = filho + 1;
            if (direito < n && cmp.compare((T) c, (T) es[direito]) > 0)
                c = es[filho = direito];
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
