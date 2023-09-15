package ExerciciosNormais.exercicios.Jogos;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author José Gustavo
 */
public class Jokenpo implements Jogavel {
    @Override
    public void jogar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("   Tipos de Jogadas\n"
                + "(1) Pedra\n"
                + "(2) Tesoura\n"
                + "(3) Papel");
        System.out.println("Escolha sua jogada: ");
        int jogada = Integer.parseInt(teclado.nextLine());
        Random random = new Random();
        int jogadaMaquina = random.nextInt(3) + 1;
        System.out.println("Jogada da Maquina: " + jogadaMaquina);
        switch (jogada) {
            case 1:
                switch (jogadaMaquina) {
                    case 1:
                        System.out.println("Empate");
                        break;
                    case 2:
                        System.out.println("Voce Venceu");
                        break;
                    case 3:
                        System.out.println("Voce Perdeu");
                        break;
                }
                break;
            case 2:
                switch (jogadaMaquina) {
                    case 1:
                        System.out.println("Voce Perdeu");
                        break;
                    case 2:
                        System.out.println("Empate");
                        break;
                    case 3:
                        System.out.println("Voce Venceu");
                        break;

                }
                break;
            case 3:
                switch (jogadaMaquina) {
                    case 1:
                        System.out.println("Voce Venceu");
                        break;
                    case 2:
                        System.out.println("Voce Perdeu");
                        break;
                    case 3:
                        System.out.println("Empate");
                        break;

                }
                break;
            default:
                throw new IllegalArgumentException("Jogada invalida");
        }
        System.out.print("Quer continuar? (Sim/Não)");
        Character escolha = teclado.next().charAt(0);
        if(escolha.toString().equalsIgnoreCase("S")){
            jogar();
        } else{
            System.out.println("Obrigado por jogar!!");
        }
    }
}    
    
