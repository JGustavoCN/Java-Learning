/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.ed2;

import javax.swing.JFrame;

/**
 *
 * @author Aluno
 */
public class Teste {
    public static void main(String[] args) {
        BST b =new BST();
        b.inserir(5);
        b.inserir(2);
        b.inserir(7);
        b.inserir(4);
        b.inserir(12);
        b.inserir(1);
        b.inserir(3);
        b.inserir(8);
        b.inserir(9);
        System.out.println(b.percorrerPreOrdem());
        System.out.println("\n---------------------");
        System.out.println(b.percorrerOrdem());
        System.out.println("\n---------------------");
        System.out.println(b.percorrerPosOrdem());
        System.out.println("\n---------------------");
        
        
         // Criando a janela principal
        JFrame janela = new JFrame("Árvore Binária de Busca");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(1000, 800);
        janela.setLocationRelativeTo(null);

    }
}
