package br.edu.ifs.pp.atividades.singleton;

/**
 * 
 * Use Eager Initialization quando você tiver certeza de que o objeto será 
 * utilizado durante todo o ciclo de vida da aplicação e que não haverá problemas 
 * em alocar recursos para ele desde o início.
 * 
 * Desvantagens:
 *  1 - Desperdício de Recursos: Se a instância nunca for usada, você terá criado
 *      um objeto desnecessário, consumindo recursos sem necessidade.
 *  2 - Uso de memória: Pode ser ineficiente se o objeto criado for muito grande
 *     ou consumir muitos recursos e se não for usado frequentemente.
 * 
 * @author José Gustavo
 * 
 */
public class LogSingletonEager {
    private static final LogSingletonEager INSTACE = new LogSingletonEager();
    
    private LogSingletonEager(){
        
    }
    
    public static synchronized LogSingletonEager getInstace(){
        return INSTACE;
    }
}
