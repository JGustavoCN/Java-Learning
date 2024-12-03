package br.edu.ifs.pp.atividades.singleton;

/**
 * 
 * Use Lazy Holder quando você deseja evitar a complexidade e os problemas de 
 * sincronização de Lazy Initialization tradicional e quer uma solução simples 
 * e eficiente para o problema de concorrência. Ele é considerado a melhor forma 
 * de implementar um Singleton em Java, especialmente para evitar problemas com 
 * a sincronização e a criação excessiva de objetos já que só é carregada quando
 * a classe que está aninhada for acessada.
 * 
 * Desvantagens:
 *  1 - Limitações: Essa abordagem é específica para Java e pode não ser 
 *      aplicável em outras linguagens de programação ou plataformas.
 * 
 * @author José Gustavo
 * 
 */
public class LogSingletonLazyHolder {
    
    // LogSingletonLazyHolder foi carregada, mas a LogHolder ainda não
    private static class LogHolder{
        private static final LogSingletonLazyHolder INSTANCE = new LogSingletonLazyHolder();
    }
    
    private String log;
    
    private LogSingletonLazyHolder(){
        log = "Log: ";
    }
    
    public static LogSingletonLazyHolder getInstace(){
        // Agora a LogHolder vai ser carregada, quando chamar o metodo
        return LogHolder.INSTANCE;
    }
    
    public void log(String log){
        this.log += log;
    }
}
