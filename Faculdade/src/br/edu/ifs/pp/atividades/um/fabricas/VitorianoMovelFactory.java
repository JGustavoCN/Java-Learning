package br.edu.ifs.pp.atividades.um.fabricas;

import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.vitoriano.CadeiraVitoriano;

public class VitorianoMovelFactory implements MovelFactory {

    public Movel createMovel() {
        return new CadeiraVitoriano();
    }
}
