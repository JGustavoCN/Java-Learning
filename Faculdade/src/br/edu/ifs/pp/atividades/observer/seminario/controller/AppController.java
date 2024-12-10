package br.edu.ifs.pp.atividades.observer.seminario.controller;

import br.edu.ifs.pp.atividades.observer.seminario.model.entities.Actor;
import br.edu.ifs.pp.atividades.observer.seminario.model.entities.Agent;
import br.edu.ifs.pp.atividades.observer.seminario.model.observer.AbstractSubject;
import br.edu.ifs.pp.atividades.observer.seminario.model.observer.Observer;
import br.edu.ifs.pp.atividades.observer.seminario.view.ActorView;
import br.edu.ifs.pp.atividades.observer.seminario.view.MainView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Gustavo
 */
public class AppController {
    
    public final Agent agent;
    public final List<Actor> actors;
    
    public AppController() {
        actors = new ArrayList<>();
        this.agent = new Agent();
        for (int i = 0; i < 3; i++) {
            Actor actor = new Actor("Ator "+(i+1));
            actors.add(actor);
            agent.registerObserver(actor);
        }
    } 
    
    public void atualizarActorViews (List<ActorView> actorViews){
        agent.setHasPaper(!agent.hasPaper());
        for (int i = 0; i < actors.size(); i++) {
            actorViews.get(i).updateMessage(actors.get(i).isPaper);
        }
           
        
    }
    
    public void criarActorViews(List<ActorView> actorViews){
        
        for (Actor actor : actors) {
            actorViews.add(new ActorView());
        }
    }
    
}
