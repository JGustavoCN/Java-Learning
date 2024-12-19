package br.edu.ifs.ed2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Aluno
 * @param <T>
 */
public class BST<T extends Comparable> {

    No<T> raiz;

    public boolean estaVazio() {
        return raiz == null;
    }

    public No remover(T elemento) {
        if (!buscar(elemento)) {
            return null;
        }
        No noPai = buscar(elemento, raiz);
        No no = noPai.eFilho(elemento);

        if (noPai.filhoEsquerdo.elemento.equals(elemento)) {
            if (!remocaoSemFilho(no, () -> {
                noPai.filhoEsquerdo = null;
            })) {
                if (no.filhoDireito != null && no.filhoEsquerdo == null) {
                    noPai.filhoDireito = no.filhoDireito;
                } else if (no.filhoDireito == null && no.filhoEsquerdo != null) {
                    noPai.filhoEsquerdo = no.filhoEsquerdo;
                } else {

                }
            }

        } else if (noPai.filhoDireito.elemento.equals(elemento)) {
            if (!remocaoSemFilho(no, () -> {
                noPai.filhoDireito = null;
            })) {
                remocaoComFilho(noPai, no);
            }

        }
        return no;
    }

    No noSucessor(No atual) {
        No sucessor = atual.filhoDireito;
        while (sucessor.filhoEsquerdo == null) {
            sucessor = sucessor.filhoEsquerdo;
        }
        return sucessor;
    }

    void remocaoComFilho(No noPai, No no) {
        if (no.filhoDireito != null && no.filhoEsquerdo == null) {
            noPai.filhoDireito = no.filhoDireito;
        } else if (no.filhoDireito == null && no.filhoEsquerdo != null) {
            noPai.filhoEsquerdo = no.filhoEsquerdo;
        } else {
            No<T> sucessor = noSucessor(no);
            if (sucessor.filhoDireito == null) {
                no.elemento = sucessor.elemento;
                No paiSucessor = buscar(sucessor.elemento, no.filhoDireito);
                paiSucessor.filhoEsquerdo = sucessor.filhoDireito;
            }
        }
    }

    boolean remocaoSemFilho(No no, Runnable funcao) {
        if (no.filhoDireito == null && no.filhoEsquerdo == null) {
            funcao.run();
            return true;
        }
        return false;
    }

    public boolean buscar(T elemento) {
        return buscar(elemento, raiz) != null;
    }

    public No buscar(T elemento, No no) {
        if (no.elemento.equals(elemento)) {
            return no;
        }
        while (no != null) {
            // Verificar se o elemento é o filho do nó
            if (no.eFilho(elemento) != null) {
                return no;
            }
            //Percorrer a arvore
            if (no.elemento.compareTo(elemento) < 0) {
                no = no.filhoEsquerdo;
            } else if (no.elemento.compareTo(elemento) > 0) {
                no = no.filhoDireito;
            } else {
                return null;
            }
        }
        return null;
    }

    public List<T> percorrerPreOrdem() {
        List<T> listaPreOrdem = new ArrayList<>();
        if (raiz == null) {
            return listaPreOrdem;
        }

        Stack<No<T>> stack = new Stack<>();
        stack.push(raiz);

        while (!stack.isEmpty()) {
            No<T> atual = stack.pop();
            listaPreOrdem.add(atual.elemento);

            // Empilha o filho direito primeiro para que o filho esquerdo seja processado primeiro
            if (atual.filhoDireito != null) {
                stack.push(atual.filhoDireito);
            }
            if (atual.filhoEsquerdo != null) {
                stack.push(atual.filhoEsquerdo);
            }
        }

        return listaPreOrdem;
    }

    public List<T> percorrerOrdem() {
        List<T> listaOrdem = new ArrayList<>();
        if (raiz == null) {
            return listaOrdem;
        }

        Stack<No<T>> stack = new Stack<>();
        No<T> atual = raiz;

        // Enquanto houver nós para processar
        while (atual != null || !stack.isEmpty()) {
            // Empilha todos os nós da subárvore esquerda
            while (atual != null) {
                stack.push(atual);
                atual = atual.filhoEsquerdo;
            }

            // Processa o nó no topo da pilha
            atual = stack.pop();
            listaOrdem.add(atual.elemento);

            // Agora, processe o filho direito do nó atual
            atual = atual.filhoDireito;
        }

        return listaOrdem;
    }

    public List<T> percorrerPosOrdem() {
        List<T> listaPosOrdem = new ArrayList<>();
        if (raiz == null) {
            return listaPosOrdem;
        }

        Stack<No<T>> stack = new Stack<>();
        No<T> atual = raiz;
        No<T> anterior = null;

        // Enquanto houver nós para processar
        while (atual != null || !stack.isEmpty()) {
            // Explorar a subárvore esquerda, empilhando os nós
            while (atual != null) {
                stack.push(atual);
                atual = atual.filhoEsquerdo;
            }

            // Verifica o topo da pilha
            atual = stack.peek();

            // Se o filho direito não foi visitado e existe, vamos para o filho direito
            if (atual.filhoDireito != null && atual.filhoDireito != anterior) {
                atual = atual.filhoDireito;
            } else {
                // Caso contrário, visitamos o nó atual
                listaPosOrdem.add(atual.elemento);
                anterior = atual;
                stack.pop();
                atual = null; // Para continuar a iterar sobre a pilha
            }
        }

        return listaPosOrdem;
    }

    public int tamanho;

    public void inserir(T elemento) {
        if (estaVazio()) {
            raiz = new No(elemento);
            tamanho++;
            return;
        }
        inserirRecursivo(raiz, elemento);
        tamanho++;
    }

    void inserirWhile(No no, T elemento) {
        while (true) {
            if (no.elemento.compareTo(elemento) > 0) {
                if (no.filhoEsquerdo == null) {
                    no.filhoEsquerdo = new No(elemento);
                    break;
                }
                no = no.filhoEsquerdo;
            } else if (no.elemento.compareTo(elemento) < 0) {
                if (no.filhoDireito == null) {
                    no.filhoDireito = new No(elemento);
                    break;
                }
                no = no.filhoDireito;
            } else {
                break;
            }
        }
    }

    void inserirRecursivo(No no, T elemento) {
        if (no.elemento.compareTo(elemento) > 0) {
            if (no.filhoEsquerdo == null) {
                no.filhoEsquerdo = new No(elemento);
            } else {
                inserirRecursivo(no.filhoEsquerdo, elemento);
            }
        } else if (no.elemento.compareTo(elemento) < 0) {
            if (no.filhoDireito == null) {
                no.filhoDireito = new No(elemento);
            } else {
                inserirRecursivo(no.filhoDireito, elemento);
            }
        }
    }

    class No<T extends Comparable> {

        T elemento;
        No<T> filhoEsquerdo;
        No<T> filhoDireito;

        public No(T elemento) {
            this.elemento = elemento;
        }

        public No eFilho(T elemento) {

            No no = null;
            if (this.filhoEsquerdo != null && this.filhoEsquerdo.elemento.equals(elemento)) {
                no = this.filhoEsquerdo;
            } else if (this.filhoDireito != null && this.filhoDireito.elemento.equals(elemento)) {
                no = this.filhoDireito;
            }
            return no;
        }

        @Override
        public String toString() {
            return elemento.toString();
        }

    }

}
