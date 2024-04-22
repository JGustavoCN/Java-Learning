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

    public static class Posicao {

        int linha;
        int coluna;

        public Posicao(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        public void mover(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }
    }

    public static boolean verificarCaminho(int[][] matriz, Posicao posicaoAtual, Posicao posicaoAnterior) {
        
        if (matriz.length - 1 == posicaoAtual.linha && matriz[0].length - 1 == posicaoAtual.coluna) return true;
        
        int formatoCaminho = 1;
        boolean caminhoDireita = false;
        boolean caminhoBaixo = false;
        boolean caminhoEsquerda = false;
        boolean caminhoCima = false;
        
        if (posicaoAtual.coluna < matriz[0].length - 1 && posicaoAnterior.coluna != posicaoAtual.coluna + 1 && matriz[posicaoAtual.linha][posicaoAtual.coluna + 1] == formatoCaminho) {
            caminhoDireita = verificarCaminho(matriz, new Posicao(posicaoAtual.linha, posicaoAtual.coluna + 1), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }
        
        if (posicaoAtual.linha < matriz.length - 1 && posicaoAnterior.linha != posicaoAtual.linha + 1 && matriz[posicaoAtual.linha + 1][posicaoAtual.coluna] == formatoCaminho) {
            caminhoBaixo = verificarCaminho(matriz, new Posicao(posicaoAtual.linha + 1, posicaoAtual.coluna), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }
        
        if (posicaoAtual.coluna > 0 && posicaoAnterior.coluna != posicaoAtual.coluna - 1 && matriz[posicaoAtual.linha][posicaoAtual.coluna - 1] == formatoCaminho) {
            caminhoEsquerda = verificarCaminho(matriz, new Posicao(posicaoAtual.linha, posicaoAtual.coluna - 1), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }
        
        if (posicaoAtual.linha > 0 && posicaoAnterior.linha != posicaoAtual.linha - 1 && matriz[posicaoAtual.linha - 1][posicaoAtual.coluna] == formatoCaminho) {
            caminhoCima = verificarCaminho(matriz, new Posicao(posicaoAtual.linha - 1, posicaoAtual.coluna), new Posicao(posicaoAtual.linha, posicaoAtual.coluna));
        }
        
        return caminhoEsquerda || caminhoBaixo || caminhoDireita || caminhoCima;

    }

    public static void main(String[] args) {
        andandoNaVia();
        
        int[][] matriz2
                = {
                    {1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1},
                    {1, 1, 1, 0, 1},
                };
        
        int[][] matriz1
                = {
                    {1, 1, 1, 1},
                    {0, 0, 0, 1},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1},
                };

        boolean tem = verificarCaminho(matriz2, new Posicao(0, 0), new Posicao(0, 0));
        
        if (tem) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
        

//        App.main(args);
//        PooLista2.main(args);
    }

    public static void andandoNaVia() {
        System.out.print("Digite o tamanho: ");
        int tamanho = Entrada.teclado.nextInt();
        int matriz[][] = new int[tamanho][tamanho];
        System.out.println("=== Andando na via\n");
        Player jogador = new Player();
        for (int[] is : matriz) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        do {
            clearConsole();
            pintar(matriz, jogador);
            ir(matriz, posicao(matriz, jogador), jogador);
        } while (!cheguei(matriz, jogador));
        clearConsole();
        pintar(matriz, jogador);
        boolean tem = verificarCaminho(matriz, new Posicao(0, 0), new Posicao(0, 0));
        
                
        if (tem) {
            System.out.println("OK");
        } else {
            System.out.println("NOT OK");
        }
    }

    public static enum Local {
        MEIO_SUPERIOR, MEIO_INFERIOR, CANTO_SUPERIOR_DIREITO, CANTO_SUPERIOR_ESQUERDO, MEIO_ESQUERDO, MEIO,
        MEIO_DIREITO, CANTO_INFERIOR_ESQUERDO, CANTO_INFERIOR_DIREITO
    }

    public static class Player {

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

    public final static void clearConsole() {
        for (int i = 0; i <= 20; i++) {

            System.out.println();

        }

    }

    public static void pintar(int[][] matriz, Player player) {

        matriz[player.linha][player.coluna] += 1;
        for (int[] is : matriz) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public static boolean cheguei(int[][] matriz, Player jogador) {
        return jogador.linha == matriz.length - 1 && jogador.coluna == matriz[0].length - 1;
    }

    public static Local posicao(int[][] matriz, Player jogador) {

        int linha = jogador.linha;
        int coluna = jogador.coluna;
        if (linha == 0 && coluna == 0) {
            return Local.CANTO_SUPERIOR_ESQUERDO;
        } else if (linha == 0 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO_SUPERIOR;
        } else if (linha == 0 && coluna == matriz[0].length - 1) {
            return Local.CANTO_SUPERIOR_DIREITO;
        } else if (linha > 0 && linha < matriz.length - 1 && coluna == 0) {
            return Local.MEIO_ESQUERDO;
        } else if (linha > 0 && linha < matriz.length - 1 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO;
        } else if (linha > 0 && linha < matriz.length - 1 && coluna == matriz[0].length - 1) {
            return Local.MEIO_DIREITO;
        } else if (linha == matriz.length - 1 && coluna == 0) {
            return Local.CANTO_INFERIOR_ESQUERDO;
        } else if (linha == matriz.length - 1 && coluna > 0 && coluna < matriz[0].length - 1) {
            return Local.MEIO_INFERIOR;
        } else if (linha == matriz.length - 1 && coluna == matriz[0].length - 1) {
            return Local.CANTO_INFERIOR_DIREITO;
        } else {
            System.out.println("Posiçao não encontrada");
            return null;
        }

    }

    public static void ir(int[][] matriz, Local local, Player jogador) {
        int caminho;
        int coluna = jogador.coluna;
        int linha = jogador.linha;
        switch (local) {
            case CANTO_SUPERIOR_ESQUERDO:
                caminho = Entrada.random.nextInt(3);
                switch (caminho) {
                    case 0:
                        jogador.direita();
                        break;
                    case 1:
                        jogador.baixo();
                        break;
                    default:
                        jogador.direita();
                        jogador.baixo();
                        break;
                }
                break;

            case MEIO_SUPERIOR:
                caminho = Entrada.random.nextInt(5);
                switch (caminho) {
                    case 0:
                        jogador.direita();
                        break;
                    case 1:
                        jogador.esquerda();
                        jogador.baixo();
                        break;
                    case 2:
                        jogador.baixo();
                        break;
                    case 3:
                        jogador.esquerda();
                        break;
                    default:
                        jogador.baixo();
                        jogador.direita();
                        break;
                }
                break;
            case CANTO_SUPERIOR_DIREITO:
                caminho = Entrada.random.nextInt(3);
                switch (caminho) {
                    case 0:
                        jogador.esquerda();
                        jogador.baixo();
                        break;
                    case 1:
                        jogador.esquerda();
                        break;
                    default:
                        jogador.baixo();
                        break;
                }
                break;
            case MEIO_ESQUERDO:
                caminho = Entrada.random.nextInt(5);
                switch (caminho) {
                    case 0:
                        jogador.cima();
                        break;
                    case 1:
                        jogador.cima();
                        jogador.direita();
                        break;
                    case 2:
                        jogador.direita();
                        break;
                    case 3:
                        jogador.direita();
                        jogador.baixo();
                        break;
                    default:
                        jogador.baixo();
                        break;
                }
                break;
            case MEIO:
                caminho = Entrada.random.nextInt(8);
                switch (caminho) {
                    case 0:
                        jogador.cima();
                        break;
                    case 1:
                        jogador.cima();
                        jogador.direita();
                        break;
                    case 2:
                        jogador.direita();
                        break;
                    case 3:
                        jogador.direita();
                        jogador.baixo();
                        break;
                    case 4:
                        jogador.esquerda();
                        break;
                    case 5:
                        jogador.esquerda();
                        jogador.cima();
                        break;
                    case 6:
                        jogador.esquerda();
                        jogador.baixo();
                        break;
                    default:
                        jogador.baixo();
                        break;
                }
                break;
            case MEIO_DIREITO:
                caminho = Entrada.random.nextInt(5);
                switch (caminho) {
                    case 0:
                        jogador.cima();
                        break;
                    case 1:
                        jogador.esquerda();
                        jogador.cima();
                        break;
                    case 2:
                        jogador.esquerda();
                        break;
                    case 3:
                        jogador.esquerda();
                        jogador.baixo();
                        break;
                    default:
                        jogador.baixo();
                        break;
                }
                break;
            case CANTO_INFERIOR_ESQUERDO:
                caminho = Entrada.random.nextInt(3);
                switch (caminho) {
                    case 0:
                        jogador.cima();
                        break;
                    case 1:
                        jogador.cima();
                        jogador.direita();
                        break;
                    default:
                        jogador.direita();
                        break;
                }
                break;
            case MEIO_INFERIOR:
                caminho = Entrada.random.nextInt(5);
                switch (caminho) {
                    case 0:
                        jogador.cima();
                        break;
                    case 1:
                        jogador.cima();
                        jogador.direita();
                        break;
                    case 2:
                        jogador.cima();
                        jogador.esquerda();
                        break;
                    case 3:
                        jogador.esquerda();
                        break;
                    default:
                        jogador.direita();
                        break;
                }
                break;
            case CANTO_INFERIOR_DIREITO:
                caminho = Entrada.random.nextInt(3);
                switch (caminho) {
                    case 0:
                        jogador.cima();
                        break;
                    case 1:
                        jogador.cima();
                        jogador.esquerda();
                        break;

                    default:
                        jogador.esquerda();
                        break;
                }
                break;

        }
        
    }

    public static boolean jaEsteve(Player jogador, int[][] matriz) {
        return matriz[jogador.linha][jogador.coluna] == 1;
    }

    public static void entrada() {

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
