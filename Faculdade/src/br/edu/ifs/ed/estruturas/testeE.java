package br.edu.ifs.ed.estruturas;

import br.edu.ifs.ed.estruturas.estaticas.FilaComPrioridade;
import br.edu.ifs.ed.estruturas.estaticas.Pilha;
import br.edu.ifs.ed.estruturas.estaticas.PilhaFixa;
import br.edu.ifs.ed.estruturas.estaticas.Vetor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author José Gustavo
 */
public class testeE {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(5);
        vetor.adicionar("java");
        vetor.adicionar(120);
        vetor.adicionar(new Vetor(5));
        Pilha pilha = new Pilha();
        ArrayList lista = new ArrayList(){
        
            {
                       
            }
        
        };
        lista.add(10);
        lista.add(11);
        lista.add(12);
        lista.add(13);
        
        System.out.println("--------------------------");
        lista.stream().forEach(new Consumer(){
            @Override
            public void accept(Object t) {
                System.out.println(t);
            }
        });
        System.out.println("--------------------------");
        lista.stream().forEach(imprimir -> {
                System.out.println(imprimir);
            
        });
        System.out.println("--------------------------");
        lista.stream().forEach(item -> System.out.println(item));
        System.out.println("--------------------------");
        lista.stream().forEach(System.out::println);
        System.out.println("--------------------------");
        Consumer consumer = System.out::println;
        lista.stream().forEach(consumer);
        int[] vetor4 = {1,2,3};
        Stream.of(vetor4).forEach(consumer);
        
        for (int i = 0; i < vetor.tamanho(); i++) {
           pilha.empilhar(vetor.pegar(i));
           lista.add(vetor.pegar(i));
        }
        System.out.println(pilha);
        System.out.println(vetor);
        System.out.println(lista.toString());
        
        Vector vector = new Vector(10);
        vector.add("java");
        vector.add(120);
        vector.add(new Vetor(10));
        
        Stack stack = new Stack();
        PilhaFixa pilhaFixa = new PilhaFixa();
        
        Queue deque = new ArrayDeque();
        Queue ligada = new LinkedList();
        PriorityQueue fila = new PriorityQueue();
        FilaComPrioridade fila2 = new FilaComPrioridade();
        
        //fila2.enfileirar(3);
        
        while (!fila2.estaVazia()) {            
            System.out.println(fila2.desenfileirar());
        }
        //java.util.Abstract
        fila.offer('C');
        fila.add('C');
        fila.offer('A');
        fila.offer('B');
        System.out.println(fila);
        while (!fila.isEmpty()) {            
            System.out.println(fila.poll());
        }
        
        
        //fila.add(fila);
        //fila.remove(fila);
        int k =1;
        int parent = (k - 1) >>> 1;
        //System.out.println(parent);
       
    }
}
