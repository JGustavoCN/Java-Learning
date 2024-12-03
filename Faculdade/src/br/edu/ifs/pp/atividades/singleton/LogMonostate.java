package br.edu.ifs.pp.atividades.singleton;

/**
 * A distinção em relação à Singleton está no comportamento x estrutura. 
 * Enquanto Singleton força a estrutura da singularidade, impedindo que mais 
 * instâncias sejam criadas, Monostate impõe o comportamento da singularidade, 
 * permitindo a instanciação de vários objetos.
 * 
 * Desvantagens: 
 *   1 - Eficiência: tendo em vista que Monostate habilita a criação e 
 * destruição de múltiplas instâncias, isto pode ter um custo considerável 
 * durante a execução do sistema;
 *   2 - Memória: independente da utilização de um Monostate, as suas variáveis 
 * irão ocupar espaço.
 * 
 * @author José Gustavo
 */
public class LogMonostate {
    
    private static String log;
    
    static {
        log = "Log: ";
    }
    
    public LogMonostate(){
        
    }
    
    public void log (String log){
        LogMonostate.log += log;
    }
    
}
