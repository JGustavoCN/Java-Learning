package br.edu.ifs.pp.atividades.observer.seminario.model.entities;

import br.edu.ifs.pp.atividades.observer.seminario.model.observer.Observer;

/**
 *
 * @author José Gustavo
 */
public class Actor implements Observer<Boolean> {
    
    private final String name;
    public boolean isPaper;   

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public void update(Boolean hasPaper) {
        isPaper = hasPaper;
    }
}
