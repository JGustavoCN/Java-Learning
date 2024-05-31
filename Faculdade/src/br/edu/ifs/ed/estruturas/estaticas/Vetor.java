package br.edu.ifs.ed.estruturas.estaticas;

/**
 *
 * @author José Gustavo
 * @param <E> Tipo dos elementos
 */

public class Vetor<E> extends Colecao<E>{

    public Vetor() {
    }

    public Vetor(int capacidadeInicial, int incrementoDeCapacidade) {
        super(capacidadeInicial, incrementoDeCapacidade);
    }

    public Vetor(int capacidadeInicial) {
        super(capacidadeInicial);
    }
    
    public void verificarIndice(int indice){
        if(!(indice >= 0 && indice < this.tamanho)) throw new IndiceForaDoLimiteException(indice);
    }
    
    public boolean adicionar(E elemento) {
        return super.adicionar(elemento, tamanho);
    }
    
    @Override
    public boolean adicionar(E elemento, int indice){
        verificarIndice(indice);
        return super.adicionar(elemento, indice);
    }

    @Override
    public E remover(int indice) {
        verificarIndice(indice);
        return super.remover(indice); 
    }
    
    public boolean remover(E elemento){
        int indice = indiceDe(elemento);
        if (indice >= 0) {
            remover(indice);
            return true;
        }
        return false;
    }
    
    public E pegar(int indice){
        verificarIndice(indice);
        return elementos[indice];
    }
    
    public boolean contem(E elemento){
        return indiceDe(elemento)>=0;
    }
    
    /**
     * Retorna o índice da primeira ocorrência do elemento especificado em
     * este vetor, pesquisando a partir de {@code indice}, ou retorna -1 se
     * o elemento não foi encontrado.
     *
     * @param elemento elemento a ser procurado
     * @param indice índice para iniciar a pesquisa
     * @return o índice da primeira ocorrência do elemento em
     * este vetor na posição {@code indice} ou posteriormente no vetor;
     * {@code -1} se o elemento não for encontrado.
     * @throws IndiceForaDoLimiteException se o índice especificado for negativo
     */
    public int indiceDe(E elemento, int indice){
        verificarIndice(indice);
        //busca sequencial
        if (elemento == null) {
            for (int i = indice ; i < tamanho ; i++)
                if (pegar(indice)==null)
                    return i;
        } else {
            for (int i = indice ; i < tamanho ; i++)
                if (elemento.equals(pegar(indice)))
                    return i;
        }
        return -1;
    }
    
    public int indiceDe(E elemento){
        return indiceDe(elemento, 0);
    }
    
    public int ultimoIndiceDe(E elemento){
        return ultimoIndiceDe(elemento, tamanho-1);
    }
    
    public int ultimoIndiceDe(E elemento, int indice){
        verificarIndice(indice);
        if (elemento == null) {
            for (int i = indice; i >= 0; i--)
                if (elementos[i]==null)
                    return i;
        } else {
            for (int i = indice; i >= 0; i--)
                if (elemento.equals(elementos[i]))
                    return i;
        }
        return -1;
    }
    
    //Não posso ter uma classe Exception dentro de uma classe que possua Generic, por isso o static
    public static class IndiceForaDoLimiteException extends VirtualMachineError {

        public IndiceForaDoLimiteException() {}

        public IndiceForaDoLimiteException(String message) {super(message);}
        
        public IndiceForaDoLimiteException(int indice) {super("Indice fora do intervalo do vetor: " + indice);}
    }
    
}
