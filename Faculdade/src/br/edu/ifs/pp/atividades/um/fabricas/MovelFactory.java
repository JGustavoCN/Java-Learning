package br.edu.ifs.pp.atividades.um.fabricas;

import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.TiposDeMoveis;

public interface MovelFactory {

    Movel createMovel(String tipoDeMovel);
    Movel createMovel(TiposDeMoveis tipoDeMovel);
}
