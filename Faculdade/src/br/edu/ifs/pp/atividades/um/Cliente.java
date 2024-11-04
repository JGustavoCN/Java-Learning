package br.edu.ifs.pp.atividades.um;

import br.edu.ifs.pp.atividades.um.fabricas.ModernoMovelFactory;
import br.edu.ifs.pp.atividades.um.fabricas.MovelFactory;
import br.edu.ifs.pp.atividades.um.moveis.Movel;


public class Cliente {

    public static void main(String[] args) {
        MovelFactory factory = new ModernoMovelFactory();
        Movel movel = factory.createMovel();
        System.out.println("Criou um(a) " + movel.descricao());
// Repetir para outros produtos e estilos...
    }
}
