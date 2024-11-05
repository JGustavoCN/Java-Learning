package br.edu.ifs.pp.atividades.um.fabricas;

import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.TiposDeMoveis;
import br.edu.ifs.pp.atividades.um.moveis.vitoriano.*;

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
