package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import poo.listas.PooLista2;
import poo.projeto.main.App;

/**
 *
 * @author José Gustavo
 */

public class Main {
    
    public static void main(String[] args){
       
       
        Scanner teclado = new Scanner(System.in, "latin1");
        System.out.println(teclado.delimiter());
        System.out.println(teclado.locale());
                
        
        
        //Se usar o metodo useDelimiter vai
        teclado.useDelimiter("\n").
                useLocale(Locale.getDefault(Locale.Category.FORMAT));
        System.out.println();
        
        String nome;
        int idade;
        
        System.out.print("?: ");
        nome = teclado.next();
        System.out.println(nome);
        
        System.out.print("?: ");
        idade = teclado.nextInt();
        System.out.print("Res: ");
        System.out.print(idade);
        
        System.out.print("?: ");
        nome = teclado.next();
        nome = nome.substring(1);
        System.out.print("Res: ");
        System.out.print(nome);
        
      
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader ler = new BufferedReader(isr);
        try {  
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
