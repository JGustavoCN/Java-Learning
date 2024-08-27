package br.edu.ifs.ed.estruturas.dinamica;

import br.edu.ifs.ed.estruturas.dinamica.simples.Fila;
import br.edu.ifs.ed.estruturas.dinamica.simples.Lista;
import br.edu.ifs.ed.estruturas.dinamica.simples.Pilha;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.UUID;

/**
 *
 * @author José Gustavo
 */
public class TesteLigados {

    public static void main(String[] args) {
        UUID id;
        
        id = UUID.randomUUID();
        System.out.println(id);
        id = UUID.nameUUIDFromBytes("Paracetamol".toUpperCase().getBytes());
        System.out.println(id.compareTo(
                UUID.nameUUIDFromBytes(
                        "PAracetamol".toUpperCase().getBytes()
                )
        ));
        
        Lista<String> lista = new Lista();
        
        
        lista.adicionar("d");
        lista.adicionar("c");
        lista.adicionar("b");
        lista.adicionar("a");
        lista.adicionar("z");
        lista.adicionar("y");
        System.out.println(lista);
        lista.ordenar((String p1, String p2) -> p1.compareToIgnoreCase(p2));
        System.out.println(lista);
        
        
        System.out.println("==================================");

        System.out.println("==================================");
        
        LinkedList lista2 = new LinkedList();

        lista.adicionar("1");
        lista.adicionar("3");
        lista.adicionar("5");
        System.out.println(lista);
        lista.adicionar("2", 1);
        lista.adicionar("4", 3);
        System.out.println(lista);
        lista.remover(3);
        lista.remover(1);
        System.out.println(lista);
        lista.adicionar("2", 1);
        lista.adicionar("4", 3);
        System.out.println(lista);
        lista.remover("2");
        lista.remover("4");
        System.out.println(lista);
    }

    static void pilhaTest() {
        System.out.println("--> PILHA");
        Pilha pilha = new Pilha();
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        System.out.println(pilha);
        pilha.desempilhar();
        System.out.println(pilha);
        pilha.desempilhar();
        System.out.println(pilha);
        System.out.println(pilha.topo());
    }

    static void listaTest() {
        System.out.println("--> LISTA");
        Lista lista = new Lista();
        LinkedList lista2 = new LinkedList();

        lista.adicionar(1);
        lista.adicionar(4);
        lista.adicionar(5);
        lista.adicionar(2, 1);
        System.out.println(lista);
        lista.adicionar(3, lista.indiceDe(4));
        System.out.println(lista);
        lista.limpar();

        System.out.println("================");

        lista.adicionar(1);
        lista.adicionar(3);
        lista.adicionar(4);
        System.out.println(lista);
        lista.adicionar(0, 0);
        System.out.println(lista);
        lista.adicionar(2, 2);
        System.out.println(lista);
        lista.adicionar(6, lista.tamanho());
        System.out.println(lista);
        lista.adicionar(5, lista.tamanho() - 1);
        System.out.println(lista);

        System.out.println("================");

        lista.limpar();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        System.out.println(lista);
        lista.remover();
        System.out.println(lista);
        lista.remover();
        System.out.println(lista);
        lista.remover();
        System.out.println(lista);

        System.out.println("\n---------------------------\n");

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        System.out.println(lista);
        System.out.println(lista.pegar(lista.tamanho() - 1));
        lista.removerUltimo();
        System.out.println(lista);
        System.out.println(lista.pegar(lista.tamanho() - 1));
        lista.removerUltimo();
        System.out.println(lista);
        System.out.println(lista.pegar(lista.tamanho() - 1));
        lista.removerUltimo();
        System.out.println(lista);
    }

    static void filaTest() {
        System.out.println("--> FILA");
        Fila fila = new Fila();
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
        System.out.println(fila.primeiro());
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.enfileirar(4);
        fila.enfileirar(5);
        System.out.println(fila);
        fila.limpar();
        System.out.println(fila);
        System.out.println(fila.tamanho());

    }

}
