package dominio;

public class Lobo extends Mamifero {

    @Override
    public void emitirSom() {
        System.out.println("Auuuuuuuuuuu!");
    }

    public void enterrarOsso() {
        System.out.println("Enterrando Osso...");
    }

    public void abanarRabo() {
        System.out.println("Abanando o Rabo...");
    }

    public void reagir(String frase) {
        if (frase.equalsIgnoreCase("Toma comida") || frase.equalsIgnoreCase("Vamos sair")) {
            System.out.println("Latir e abanar o rabo");
        } else {
            System.out.println("Rosnar");
        }
    }

    public void reagir(int hora, int minuto) {
        if (hora < 12) {
            System.out.println("Abanar o rabo");
        } else if (hora >= 18) {
            System.out.println("Ignorar");
        } else {
            System.out.println("Abanar e latir");
        }
    }

    public void reagir(boolean dono) {
        if (dono) {
            System.out.println("Abanar");
        } else {
            System.out.println("Latir");
        }
    }

    public void reagir(int idade, double peso) {
        if (idade < 5) {
            if (peso < 10) {
                System.out.println("Abanar");
            } else {
                System.out.println("Latir");
            }
        } else {
            if (peso < 10) {
                System.out.println("Rosnar");
            } else {
                System.out.println("Ignorar");
            }
        }
    }

}
