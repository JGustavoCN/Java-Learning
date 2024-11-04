package br.edu.ifs.pp.atividades.um.fabricas;

import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.moderno.CadeiraModerna;

public class ModernoMovelFactory implements MovelFactory {

    public Movel createMovel() {
        return new CadeiraModerna();
    }
}

