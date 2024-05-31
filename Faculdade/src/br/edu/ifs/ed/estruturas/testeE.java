package br.edu.ifs.ed.estruturas;

import br.edu.ifs.ed.estruturas.estaticas.FilaComPrioridade;
import br.edu.ifs.ed.estruturas.estaticas.Pilha;
import br.edu.ifs.ed.estruturas.estaticas.PilhaFixa;
import br.edu.ifs.ed.estruturas.estaticas.Vetor;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

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
        ArrayList lista = new ArrayList();
        
        
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
        FilaComPrioridade<Integer> fila2 = new FilaComPrioridade();
        fila2.enfileirar(1);
        fila2.enfileirar(0);
        fila2.enfileirar(5);
        fila2.enfileirar(4);
        for (int i = 0; i < fila2.tamanho(); i++) {
            System.out.println(fila2.desenfileirar());
        }
        
        
       
        fila.poll();
         
        //fila.add(fila);
        //fila.remove(fila);
        int k =1;
        int parent = (k - 1) >>> 1;
        System.out.println(parent);
       
    }
}
