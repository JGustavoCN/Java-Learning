package br.edu.ifs.pp.atividades.observer.seminario.model.entities;

import br.edu.ifs.pp.atividades.observer.seminario.model.observer.AbstractSubject;

/**
 *
 * @author José Gustavo
 */
public class Agent extends AbstractSubject<Boolean> {
    
    private boolean hasPaper = false;

    public boolean hasPaper() {
        return hasPaper;
    }

    public void setHasPaper(boolean hasPaper) {
        this.hasPaper = hasPaper;
        notifyObservers(hasPaper);
    }
}
