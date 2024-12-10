package br.edu.ifs.pp.atividades.observer.seminario.model.observer;

/**
 *
 * @author José Gustavo
 */

@FunctionalInterface
public interface Observer<T> {
    
    void update(T message);
    
}
