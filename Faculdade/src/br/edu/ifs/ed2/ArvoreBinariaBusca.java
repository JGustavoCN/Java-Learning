package br.edu.ifs.ed2;

class No {

    int elemento;
    No pai, esquerdo, direito;

    public No(int elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return elemento + "";
    }

}

public class ArvoreBinariaBusca {

    No raiz;

    public ArvoreBinariaBusca() {

    }

    public No getRaiz() {
        return raiz;
    }

    public void is(int e){
        if (raiz == null) raiz = new No(e);
        
        No noAtual = raiz;
        while(true){
            if (e < noAtual.elemento) {
                if(noAtual.esquerdo == null){
                    noAtual.esquerdo = new No(e);
                    return;
                }else{
                    noAtual = noAtual.esquerdo;
                }
            }else if(e > noAtual.elemento){
                if(noAtual.direito == null){
                    noAtual.direito = new No(e);
                    return;
                }else{
                    noAtual = noAtual.direito;
                }
            }else{
                return;
            }
        }
    }
    
    
    public void i(int e) {
        // Se a árvore estiver vazia, o novo nó é a raiz.
        if (raiz == null) {
            raiz = new No(e);
            return;
        }

        // Percorrendo a árvore para encontrar a posição de inserção.
        No noAtual = raiz;
        while (true) {
            // Se o elemento é menor, vai para o subárvore esquerda
            if (e < noAtual.elemento) {
                // Se não tem filho à esquerda, insere aqui
                if (noAtual.esquerdo == null) {
                    noAtual.esquerdo = new No(e);
                    noAtual.esquerdo.pai = noAtual;
                    return;
                }
                // Caso contrário, continua procurando na subárvore esquerda
                noAtual = noAtual.esquerdo;
            } // Se o elemento é maior ou igual, vai para o subárvore direita
            else if (e > noAtual.elemento) {
                // Se não tem filho à direita, insere aqui
                if (noAtual.direito == null) {
                    noAtual.direito = new No(e);
                    noAtual.direito.pai = noAtual;
                    return;
                }
                // Caso contrário, continua procurando na subárvore direita
                noAtual = noAtual.direito;
            } // Caso o valor já exista na árvore, não faz nada
            else {
                return;  // Não insere elementos duplicados
            }
        }

    }

    public void inserir(int e) {
        No no = new No(e);
        if (raiz == null) {
            raiz = no;
            return;
        }
        No pai = buscaPai(raiz, e);
        if (e < pai.elemento) {
            pai.esquerdo = no;
            no.pai = pai;
        } else if (e > pai.elemento) {
            pai.direito = no;
            no.pai = pai;
        }
    }

    private No buscaPai(No no, int e) {
        if (no == null) {
            return null;
        }
        if (e < no.elemento && no.esquerdo != null) {
            return buscaPai(no.esquerdo, e);
        } else if (e >= no.elemento && no.direito != null) {
            return buscaPai(no.direito, e);
        }
        return no;
    }

    public void percorrerPreOrdem() {
        recursivoPre(raiz);
    }

    public void percorrerOrdem() {
        recursivo(raiz);
    }

    public void percorrerPosOrdem() {
        recursivoPos(raiz);
    }

    private void recursivoPre(No no) {
        if (no == null) {
            return;
        }
        System.out.print(no + ",");
        recursivoPre(no.esquerdo);
        recursivoPre(no.direito);
    }

    private void recursivo(No no) {
        if (no == null) {
            return;
        }
        recursivo(no.esquerdo);
        System.out.print(no + ",");
        recursivo(no.direito);
    }

    private void recursivoPos(No no) {
        if (no == null) {
            return;
        }
        recursivoPos(no.esquerdo);
        recursivoPos(no.direito);
        System.out.print(no + ",");
    }

    public int getAltura() {
        return altura(raiz);
    }

    private int altura(No no) {
        if (no == null) {
            return 0; // A altura de um nó nulo é 0
        }
        // A altura de um nó é 1 + a altura do maior filho (esquerdo ou direito)
        int alturaEsquerda = altura(no.esquerdo);
        int alturaDireita = altura(no.direito);

        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

}
