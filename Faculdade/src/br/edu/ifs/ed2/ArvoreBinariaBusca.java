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
