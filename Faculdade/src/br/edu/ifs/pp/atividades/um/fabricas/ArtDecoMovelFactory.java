package br.edu.ifs.pp.atividades.um.fabricas;

import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.TiposDeMoveis;
import br.edu.ifs.pp.atividades.um.moveis.artdeco.*;

public class ArtDecoMovelFactory implements MovelFactory {

    @Override
    public Movel createMovel(String tipoDeMovel) {
        return createMovel(TiposDeMoveis.getTipo(tipoDeMovel));
    }

    @Override
    public Movel createMovel(TiposDeMoveis tipoDeMovel) {
        switch (tipoDeMovel) {
            case CADEIRA:
                return new CadeiraArtDeco();
            case MESA_DE_CENTRO:
                return new MesaDeCentroArtDeco();
            case SOFA:
                return new SofaArtDeco();
            default:
                return null;
        }
    }

}
