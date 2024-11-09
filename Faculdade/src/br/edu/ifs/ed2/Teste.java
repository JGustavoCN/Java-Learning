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
        ArvoreBinariaBusca b = new ArvoreBinariaBusca();
        b.inserir(5);
        b.inserir(2);
        b.inserir(7);
        b.inserir(4);
        b.inserir(10);
        b.inserir(1);
        b.inserir(3);
        b.inserir(8);
        b.inserir(9);
        b.inserir(11);
        b.inserir(6);
        b.percorrerPreOrdem();
        System.out.println("\n---------------------");
        b.percorrerOrdem();
        System.out.println("\n---------------------");
        b.percorrerPosOrdem();
        
        
         // Criando a janela principal
        JFrame janela = new JFrame("Árvore Binária de Busca");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(1000, 800);
        janela.setLocationRelativeTo(null);

        // Criando o painel de exibição e adicionando a árvore
        ArvoreBinariaVisualizacao painel = new ArvoreBinariaVisualizacao(b);
        janela.add(painel);
        janela.setVisible(true);
    }
}
