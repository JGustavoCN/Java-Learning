package br.edu.ifs.pp.atividades.factory.fabricas;

import br.edu.ifs.pp.atividades.factory.moveis.Movel;
import br.edu.ifs.pp.atividades.factory.moveis.TiposDeMoveis;
import br.edu.ifs.pp.atividades.factory.moveis.vitoriano.*;

public class VitorianoMovelFactory implements MovelFactory {

    @Override
    public Movel createMovel(String tipoDeMovel) {
        return createMovel(TiposDeMoveis.getTipo(tipoDeMovel));
    }

    @Override
    public Movel createMovel(TiposDeMoveis tipoDeMovel) {
        switch (tipoDeMovel) {
            case CADEIRA:
                return new CadeiraVitoriano();
            case MESA_DE_CENTRO:
                return new MesaDeCentroVitoriano();
            case SOFA:
                return new SofaVitoriano();
            default:
                return null;
        }
    }
}
