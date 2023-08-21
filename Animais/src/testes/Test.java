package testes;

import dominio.Animal;
import dominio.Mamifero;

public class Test {

    public static void main(String[] args) {
        
        //Animal j = new Object();
        var a = new Mamifero();
        Object m = new Mamifero();
        Animal n = new Mamifero();
        Mamifero b = new Mamifero();
        System.out.println(m);
        System.out.println(n);
        System.out.println(b);
        a.alimentar();
        
    }
    
}
