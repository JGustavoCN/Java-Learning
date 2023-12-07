package main;

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

        App.main(args);
//        PooLista2.main(args);
    }
}
