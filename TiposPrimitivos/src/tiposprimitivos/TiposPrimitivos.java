/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiposprimitivos;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class TiposPrimitivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Se retornar pt_BR, entao o float precisa usar o separador ","
        System.out.println("Linguagem aceita: " + Locale.getDefault());
        Scanner teclado = new Scanner(System.in);
        /*
        setar o locale para US. Com isso, você pode digitar 3.92 que o número 
        será lido corretamente (mas agora 3,92 não funciona mais).
        teclado.useLocale(Locale.US); 
         */

 /* Declaracao direta
        String nome = "Gustavo";
        float nota = 8.5f;
        float nota = (float) 8.5;
         */
        System.out.print("Digite o nome do aluno: ");
        String nome = teclado.nextLine();
        System.out.print("Digite a nota: ");
        float nota = teclado.nextFloat();

        /*Formas de mostrar informacao
        System.out.println("Nota: "+nota);
        System.out.printf("Nota de %s: %.2f \n", nome, nota);
         */
        System.out.format("Nota de %s: %.2f \n", nome, nota);

       /* Manipulacao de variaveis 
        int idade = (int) 30;
        //String valor = idade -> erro
        String valor = Integer.toString(idade);
        System.out.println(valor);
       
        String valor = "30";
        int idade = Integer.parseInt(valor);
        System.out.println (idade);
       */
    }

}
