package br.edu.ifs.pp.atividades.um;

import br.edu.ifs.pp.atividades.um.fabricas.*;
import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.TiposDeMoveis;


public class Cliente {

    public static void main(String[] args) {
        testeFabricas(new ModernaMovelFactory());
        testeFabricas(new ArtDecoMovelFactory());
        testeFabricas(new VitorianoMovelFactory());
    }
    
    public static void testeFabricas(MovelFactory factory){
        Movel movel = factory.createMovel(TiposDeMoveis.CADEIRA);
        System.out.println("Criou um(a) " + movel.descricao());
        movel = factory.createMovel("Mesa de Centro");
        System.out.println("Criou um(a) " + movel.descricao());
        movel = factory.createMovel(TiposDeMoveis.SOFA.toString());
        System.out.println("Criou um(a) " + movel.descricao());
        System.out.println("----------------------------------------------------------------");
    }
}
