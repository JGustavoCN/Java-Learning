package br.edu.ifs.pp.atividades.adapter;

/**
 *
 * @author José Gustavo
 */
public class TresParaDoisPinosAdapter extends TomadaDeDoisPinos {
    
    private TomadaDeTresPinos tomadaDeTresPinos;
    
    public TresParaDoisPinosAdapter(TomadaDeTresPinos tomadaDeTresPinos){
       this.tomadaDeTresPinos = tomadaDeTresPinos; 
    }

    @Override
    public void ligarNaTomadaDeDoisPinos() {
        tomadaDeTresPinos.ligarNaTomadaDeTresPinos();
    }
    
    
}
