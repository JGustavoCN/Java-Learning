/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.ed2;

import java.util.Scanner;

public class Avaliacao {

    /*
    
Ex(*$a#.mpl.e:
    
Adventures in Disneyland
    
Two blondes were going to Disneyland when they came to a fork in the road. The sign read: "Disneyland LEFT."
    
So they went home.
    
     */
    public static void main(String[] args) {
        Avaliacao arvore = new Avaliacao();
        entradaDireta(arvore);
        //entradaLinhaPorLinha(arvore);
        System.out.println("============================================");
        arvore.imprimirEmOrdem();

    }

    /**
     * Pode digitar o conjunto de linhas que tiver, se e somente se a quantidade
     * de linha for no maximo 10000 linhas e cada linha só pode ter no maximo
     * 200 caracteres
     * @param arvore
     */
    static void entradaDireta(Avaliacao arvore) {
        Scanner teclado = new Scanner(System.in);
        String entrada = "";
        teclado.useDelimiter("EOF");
        System.out.println("Digite varias linhas: (Para finalizar digite EOF no final)");
        entrada = teclado.next();
        String[] linhasDaEntrada = entrada.split("\n");
        if (linhasDaEntrada.length > 10000) {
            System.out.println("A cima do limite de linhas");
            return;
        }
        for (String linha : linhasDaEntrada) {
            inserirNaAvaliacao(linha, arvore);
        }

    }

    static void entradaLinhaPorLinha(Avaliacao arvore) {
        Scanner teclado = new Scanner(System.in);
        String entrada = "";
        int entradaMaxima = 10000;
        entrada:
        for (int i = 0; i < entradaMaxima; i++) {
            System.out.println("--> Digite a frase: (Para finalizar digite EOF)");
            entrada = teclado.nextLine();
            if (entrada.equals("EOF")) {
                break entrada;
            }
        }
        inserirNaAvaliacao(entrada, arvore);
    }

    static void inserirNaAvaliacao(String entrada, Avaliacao arvore) {
        if (entrada.length() > 200) {
            System.out.println("Quantidade de caracteres passou de 200");
            return;
        }
        entrada = separarDosCaractersEspeciais(entrada);
        String[] palavrasDaEntrada = entrada.split(" ");
        for (String palavra : palavrasDaEntrada) {

            arvore.inserir(palavra);
        }
    }

    static String separarDosCaractersEspeciais(String palavra) {
        String palavraFormatada;
        palavraFormatada = palavra
                .replace(".", " ")
                .replace("\"", " ")
                .replace(":", " ")
                .replace("(", " ")
                .replace("*", " ")
                .replace("$", " ")
                .replace("#", " ");
        return palavraFormatada;
    }

    No raiz;

    public void inserir(String elemento) {
        if (raiz == null) {
            raiz = new No(elemento);
        }
        No atual = raiz;
        while (true) {
            if (elemento.compareToIgnoreCase(atual.elemento) < 0) {
                if (atual.filhoEsquerda == null) {
                    atual.filhoEsquerda = new No(elemento);
                } else {
                    atual = atual.filhoEsquerda;
                }
            } else if (elemento.compareToIgnoreCase(atual.elemento) > 0) {
                if (atual.filhoDireita == null) {
                    atual.filhoDireita = new No(elemento);
                } else {
                    atual = atual.filhoDireita;
                }
            } else {
                return;
            }
        }
    }

    public void imprimirEmOrdem() {
        emOrdem(raiz);
    }

    public void emOrdem(No raiz) {
        if (raiz == null) {
            return;
        }
        emOrdem(raiz.filhoEsquerda);
        System.out.println(raiz.elemento.toLowerCase());
        emOrdem(raiz.filhoDireita);
    }

    class No {

        No filhoEsquerda;
        No filhoDireita;
        String elemento;

        public No(String elemento) {
            this.elemento = elemento;
        }

    }
}
