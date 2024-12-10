package br.edu.ifs.pp.atividades.observer.seminario.model.observer;

/**
 *
 * @author José Gustavo
 */
public interface Subject<T> {
    
    void registerObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers(T message);
}
