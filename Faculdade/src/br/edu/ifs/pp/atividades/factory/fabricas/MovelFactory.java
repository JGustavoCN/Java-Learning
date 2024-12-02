package br.edu.ifs.pp.atividades.factory.fabricas;

import br.edu.ifs.pp.atividades.factory.moveis.Movel;
import br.edu.ifs.pp.atividades.factory.moveis.TiposDeMoveis;

public interface MovelFactory {

    Movel createMovel(String tipoDeMovel);
    Movel createMovel(TiposDeMoveis tipoDeMovel);
}
