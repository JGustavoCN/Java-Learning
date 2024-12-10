package br.edu.ifs.pp.atividades.observer.seminario.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Gustavo
 */
public abstract class AbstractSubject<T> implements Subject<T> {
    
    private final List<Observer<T>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(T message) {
        for (Observer<T> observer : observers) {
            observer.update(message);
        }
    }
    
}
