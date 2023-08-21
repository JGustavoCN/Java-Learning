package testesclasses;

import dominio.Pessoa;
import dominio.Pessoa.TipoSexo;

public class TestesClasses {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("jOsE gusTavo CorREia Nascimento", -18, 'm', TipoSexo.SEXO_FEMININO );
        Pessoa pessoa2 = new Pessoa("jOSE gusTavo CorREia Nascimento", 18, 'f', Pessoa.TipoSexo.SEXO_FEMININO );
        Pessoa pessoa3 = new Pessoa("jOSE gusTavo CorREia Nascimento", 18, 'z');
        
        System.out.println(pessoa);
        System.out.println(pessoa2.toString());
        System.out.println(pessoa3);
        

    }

}
