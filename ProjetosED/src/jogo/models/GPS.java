package jogo.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Stack;
import jogo.abstracts.Desenhavel;
import jogo.abstracts.Posicao;
import jogo.main.KeyHandler;

/**
 *
 * @author José Gustavo
 */
public class GPS implements Desenhavel {

    public class Caminho implements Desenhavel{
        ArrayList<Posicao> posicoes = new ArrayList<>();

        @Override
        public void paint(Graphics2D g) {
            for (Posicao posicao : posicoes) {
                g.fillOval(mapa.chao[posicao.linha][posicao.coluna].formato.x + 45, mapa.chao[posicao.linha][posicao.coluna].formato.y + 45, 10, 10);
            }
        }
    }
    
    public Mapa mapa;
    public ArrayList<Caminho> caminhos;
    private boolean[][] visitados;
    private Stack<Posicao> posicoes;

    public GPS(Mapa mapa) {
        this.mapa = mapa;
        this.visitados = new boolean[mapa.getTamanhoY()][mapa.getTamanhoX()];
        this.posicoes = new Stack();
        this.caminhos = new ArrayList<>();
    }
    
    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.green);
        for (Caminho caminho : caminhos) {
            if (KeyHandler.mostrarTodosCaminhos) {
                caminho.paint(g);
            }else{
                if (KeyHandler.mostrarMaioresCaminhos && caminho.posicoes.size() == maiorTamanhoDeCaminho()) {
                    caminho.paint(g);
                }
                if (KeyHandler.mostrarMenoresCaminhos && caminho.posicoes.size() == menorTamanhoDeCaminho()) {
                    caminho.paint(g);
                }
                
            }
            
        }
    }
    
    public void verificarCaminhos(Posicao posicaoAtual) {
        jogo.models.Chao[][] chao = mapa.chao;

        int linhas = chao.length;
        int colunas = chao[0].length;

        // Verifica se a posição atual é válida e não foi visitada ainda
        if (posicaoAtual.linha >= 0 && posicaoAtual.linha < linhas
                && posicaoAtual.coluna >= 0 && posicaoAtual.coluna < colunas
                && chao[posicaoAtual.linha][posicaoAtual.coluna].isCaminho()
                && !visitados[posicaoAtual.linha][posicaoAtual.coluna]) {

            // Adiciona a posição atual ao posicoes
            posicoes.push(posicaoAtual);

            // Condição de parada: chegou ao final da chao
            if (posicaoAtual.linha == linhas - 1 && posicaoAtual.coluna == colunas - 1) {
                setCaminho((Stack) posicoes.clone());
            } else {
                // Marca a posição atual como visitada
                visitados[posicaoAtual.linha][posicaoAtual.coluna] = true;

                // Verifica recursivamente as posições vizinhas
                verificarCaminhos(new Posicao(posicaoAtual.linha, posicaoAtual.coluna + 1));
                verificarCaminhos(new Posicao(posicaoAtual.linha + 1, posicaoAtual.coluna));
                verificarCaminhos(new Posicao(posicaoAtual.linha, posicaoAtual.coluna - 1));
                verificarCaminhos(new Posicao(posicaoAtual.linha - 1, posicaoAtual.coluna));

                // Desmarca a posição atual como visitada
                visitados[posicaoAtual.linha][posicaoAtual.coluna] = false;

            }
          
            // Remove a posição atual do posicoes
            posicoes.pop();
        }

    }

    public int maiorTamanhoDeCaminho(){
        if (caminhos.isEmpty()) return 0;
        int maior= 0;
        for (int i = 0; i < caminhos.size(); i++) {
            if (caminhos.get(i).posicoes.size() > maior) {
                maior = caminhos.get(i).posicoes.size();
            }
        }
        return maior;
    }
    public int menorTamanhoDeCaminho(){
        if (caminhos.isEmpty()) return 0;
        int menor = 25;
        for (int i = 0; i < caminhos.size(); i++) {
            if (caminhos.get(i).posicoes.size() < menor) {
                menor = caminhos.get(i).posicoes.size();
            }
        }
        return menor;
    }
    public void setCaminho(Stack posicoes) {
        Caminho caminho = new Caminho();
        while (!posicoes.isEmpty()) {
            caminho.posicoes.add((Posicao) posicoes.pop());
        }
        caminhos.add(caminho);
    }

    public boolean temCaminho() {
        return !caminhos.isEmpty();
    }

}
