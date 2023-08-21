package Cadastro;

import Seminario.Estudante;
import Seminario.Local;
import Seminario.Professor;
import Seminario.Seminario;

public class Cadastro {

    public static void main(String[] args) {
        
        Estudante est1 = new Estudante("Gustavo", 18);
        Estudante est2 = new Estudante("Robrigo", 19);
        Estudante est3 = new Estudante("Joao", 20);
        Estudante vetorEstudantes[] = {est1, est2, est3};

        Professor prof1 = new Professor("Regivan", "Matematica Discreta");

        Local loc1 = new Local("Av. Montes Coelho, 360");

        Seminario seminario1 = new Seminario("Funcao Exponencial", prof1, loc1, est1, est2, est3);
        Seminario seminario2 = new Seminario("Funcao Exponencial", prof1, loc1, vetorEstudantes);

        //seminario1.Imprime();
        //System.out.println("------------------------------------");
        //seminario2.Imprime();

        for (Estudante vetorEstudante : vetorEstudantes) {
            vetorEstudante.setSeminario(seminario1);
        }

        prof1.setSeminarios(seminario1, seminario2);
        Seminario vetorSeminarios[] = {seminario1, seminario2};
        prof1.setSeminarios(seminario1, seminario2);
        prof1.setSeminarios(vetorSeminarios);

        seminario1.Imprime();
        System.out.println("------------------------------------");
        prof1.Imprime();
        System.out.println("------------------------------------");
        loc1.Imprime();
        System.out.println("------------------------------------");
        for (int i = 0; i < vetorEstudantes.length; i++) {
            vetorEstudantes[i].Imprime();
            System.out.println("------------------------------------");
        }
    }
}
