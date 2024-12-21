package br.edu.ifs.pp.atividades.decorator.avaliacao.controller;

import br.edu.ifs.pp.atividades.decorator.avaliacao.model.*;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        int escolha;
        do {
            Acai tigela = fazerTigela();
            System.out.println("\n========= Minha Tigela =========");
            System.out.println(tigela != null ? tigela.minhaTigela() : "Não ecolheu");
            System.out.println("===================================");
            System.out.println("Quer fazer mais uma tigela? (1 - Sim / 2 - Nao)");
            escolha = teclado.nextInt();
        } while (escolha == 1);
    }
    
    public static Scanner teclado = new Scanner(System.in);

    public static Acai fazerTigela() {
        System.out.println(
                "1 - 'AcaiPuro': Representa uma tigela com açaí puro.\n"
                + "2 - 'AcaiComBanana': Representa uma tigela com açaí misturado com banana.\n"
                + "3 - 'AçaiComCupuacu': Representa uma tigela com açaí misturado com cupuaçu."
        );
        System.out.println("Escolha a base: ");
        int escolha = teclado.nextInt();
        Acai tigela = null;
        switch (escolha) {
            case 1 -> tigela = new AcaiPuro();
            case 2 -> tigela = new AcaiComBanana();
            case 3 -> tigela = new AcaiComCupuacu();
            default -> System.out.println("Opcao não existe - base de acai errada");
        }

        System.out.println("Quer adicional? (S/N)");
        char adicional = teclado.next().trim().toLowerCase().charAt(0);
        return switch (adicional) {
            case 's' -> adicionais(tigela);
            default -> tigela;
        };
    }

    public static Acai adicionais(Acai tigela) {

        System.out.println(
                "1 - 'Granola': Adiciona granola à tigela.\n"
                + "2 - 'LeiteCondensado': Adiciona leite condensado à tigela.\n"
                + "3 - 'Pacoca': Adiciona paçoca à tigela.\n"
                + "4 - 'Castanha': Adiciona castanha à tigela.\n"
                + "0 - Não quero mais adicionais"
        );
        System.out.println(
                "\n========= Minha Tigela =========\n"
                + tigela.minhaTigela()
                + "\n============================="
        );
        System.out.println("Escolha um adicional: ");
        int escolha = teclado.nextInt();

        return switch (escolha) {
            case 1 -> adicionais(new Granola(tigela));
            case 2 -> adicionais(new LeiteCondensado(tigela));
            case 3 -> adicionais(new Pacoca(tigela));
            case 4 -> adicionais(new Castanha(tigela));
            default -> tigela;
        };
    }

}
