package br.edu.ifs.pp.atividades.um.fabricas;

import br.edu.ifs.pp.atividades.um.moveis.Movel;
import br.edu.ifs.pp.atividades.um.moveis.artdeco.CadeiraArtDeco;

public class ArtDecoMovelFactory implements MovelFactory {

    public Movel createMovel() {
        return new CadeiraArtDeco();
    }
}
