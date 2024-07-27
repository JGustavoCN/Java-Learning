package br.edu.ifs.ed.estruturas.dinamica;

import br.edu.ifs.ed.estruturas.dinamica.simples.Fila;
import br.edu.ifs.ed.estruturas.dinamica.simples.Pilha;

/**
 *
 * @author JOsé Gustavo
 */
public class TesteLigados {
    
    public static void main(String[] args) {
        
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
        
        System.out.println("==================================");
        
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
        
    }
    
}
