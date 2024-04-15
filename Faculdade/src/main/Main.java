package main;

import br.edu.ifs.ed.Entrada;
import br.edu.ifs.poo.listas.PooLista2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

import br.edu.ifs.poo.projeto.main.App;

/**
 *
 * @author José Gustavo
 */
public class Main {

    
    
    public static void main(String[] args) {
          andandoNaVia();
//        App.main(args);
//        PooLista2.main(args);
    }
    
    
    
    public static void andandoNaVia(){
        System.out.print("Digite o tamanho: ");
        int tamanho = Entrada.teclado.nextInt();
        int matriz[][] = new int[tamanho][tamanho];
        System.out.println("=== Andando na via\n");
        Player jogador = new Player();
        for (int[] is : matriz) {
            for (int i : is) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        do {    
            clearConsole();
            pintar(matriz, jogador);
            ir(matriz, posicao(matriz, jogador), jogador);
        } while (!cheguei(matriz, jogador));
        
    }
    static enum Local{
        MEIO_SUPERIOR,MEIO_INFERIOR, CANTO_SUPERIOR_DIREITO, CANTO_SUPERIOR_ESQUERDO, MEIO_ESQUERDO, MEIO, 
        MEIO_DIREITO,CANTO_INFERIOR_ESQUERDO
        ,CANTO_INFERIOR_DIREITO
    }
    
    static class Player{
        int linha;
        int coluna;

        public Player() {
            this.linha = 0;
            this.coluna = 0;
        }
        // colocar ele para sbaer qual direcao vai? direita() esquerda() cimaEsquerda()
        public void mover(int linha, int coluna){
            this.linha = linha;
            this.coluna = coluna;
        }
        
    }
    
    public final static void clearConsole(){
        for(int i = 0; i <= 20; i++){

              System.out.println();

        }
 
    }
    
    public static void pintar(int[][] matriz, Player player){
        matriz[player.linha][player.coluna] = 1;
        for (int[] is : matriz) {
            for (int i : is) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
    
    public static boolean cheguei(int[][]matriz, Player jogador){
        return jogador.linha == matriz.length-1 && jogador.coluna == matriz[0].length-1;
    }
    
    public static Local posicao(int[][] matriz, Player jogador){
        Local local = null;
        int linha = jogador.linha;
        int coluna = jogador.coluna;
        if(linha == 0 && coluna == 0 ){
            return Local.MEIO_INFERIOR;
        }else if (linha == 0 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO_SUPERIOR;
        } else if(linha == 0 && coluna == matriz[0].length - 1){
            return Local.CANTO_SUPERIOR_DIREITO;
        }else if(linha > 0 && linha < matriz.length - 1 && coluna == 0 ){
            return Local.MEIO_ESQUERDO;
        } else if(linha > 0 && linha < matriz.length - 1 && coluna > 0 && coluna < matriz[0].length - 1 ){
            return Local.MEIO;
        }else if(linha > 0 && linha < matriz.length - 1 && coluna == matriz[0].length ){
            return Local.MEIO_DIREITO;
        }else if(linha == matriz.length - 1 && coluna == 0 ){
            return Local.CANTO_INFERIOR_ESQUERDO;
        }else if (linha == 0 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO_INFERIOR;
        }else if(linha == matriz.length - 1 && coluna == matriz[0].length ){
            return Local.CANTO_INFERIOR_DIREITO;
        }
        return local;
    }
    
    
    
    public static void ir(int[][] matriz, Local local, Player jogador){
        int caminho;
        switch (local) {
            case CANTO_SUPERIOR_ESQUERDO:
                caminho = Entrada.random.nextInt(3);
                if (caminho == 0) {
                    jogador.mover(jogador.linha, jogador.coluna+1);
                } else if(caminho == 1){
                    jogador.mover(jogador.linha+1, jogador.coluna);
                }else{
                    jogador.mover(jogador.linha+1, jogador.coluna+1);
                }
                break;
            
        }
    }
    
    
    public static void entrada(){
        
        Scanner teclado = new Scanner(System.in, "latin1");
        System.out.println(teclado.delimiter());
        System.out.println(teclado.locale());

        //Se usar o metodo useDelimiter vai
        teclado.useDelimiter("\\n").
                useLocale(Locale.getDefault(Locale.Category.FORMAT));
        System.out.println();

        String nome;
        int idade;

        System.out.print("Nome: ");
        nome = teclado.next();
        System.out.println(nome);
        
        
        
        System.out.print("Idade: ");
        idade = teclado.nextInt();
        
        System.out.print("Res: ");
        System.out.println(idade);
        

        System.out.print("Nome: ");
        nome = teclado.next();
        System.out.print("Res: ");
        System.out.print(nome);

        
        
        System.out.println("-------------------------------------");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader ler = new BufferedReader(isr);
        try {
            System.out.println("Nome: ");
            nome = ler.readLine();
            System.out.println(nome);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        
    }
}
