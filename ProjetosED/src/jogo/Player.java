/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

/**
 *
 * @author Aluno
 */
public class Player {
    
        int linha;
        int coluna;

        public Player() {
            this.linha = 0;
            this.coluna = 0;
        }

        // colocar ele para sbaer qual direcao vai? direita() esquerda() cimaEsquerda()
        public void mover(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        public void direita() {
            this.coluna += 1;
        }

        public void baixo() {
            this.linha += 1;
        }

        public void cima() {
            this.linha -= 1;
        }

        public void esquerda() {
            this.coluna -= 1;
        }

}
