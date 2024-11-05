package br.edu.ifs.pp.atividades.um.fabricas;

import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.TiposDeMoveis;
import br.edu.ifs.pp.atividades.um.moveis.moderno.*;

public class ModernaMovelFactory implements MovelFactory {

    @Override
    public Movel createMovel(String tipoDeMovel) {
        return createMovel(TiposDeMoveis.getTipo(tipoDeMovel));
    }

    @Override
    public Movel createMovel(TiposDeMoveis tipoDeMovel) {
        switch (tipoDeMovel) {
            case CADEIRA:
                return new CadeiraModerna();
            case MESA_DE_CENTRO:
                return new MesaDeCentroModerna();
            case SOFA:
                return new SofaModerno();
            default:
                return null;
        }
    }
}

