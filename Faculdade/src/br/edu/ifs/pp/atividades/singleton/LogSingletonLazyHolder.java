package br.edu.ifs.pp.atividades.singleton;

/**
 * 
 * Use Lazy Holder quando você deseja evitar a complexidade e os problemas de 
 * sincronização de Lazy Initialization tradicional e quer uma solução simples 
 * e eficiente para o problema de concorrência. Ele é considerado a melhor forma 
 * de implementar um Singleton em Java, especialmente para evitar problemas com 
 * a sincronização e a criação excessiva de objetos.
 * 
 * Desvantagens:
 *  1 - Limitações: Essa abordagem é específica para Java e pode não ser 
 *      aplicável em outras linguagens de programação ou plataformas.
 * 
 * @author José Gustavo
 * 
 */
public class LogSingletonLazyHolder {
    private static final LogSingletonLazyHolder INSTACE = new LogSingletonLazyHolder();
    
    private LogSingletonLazyHolder(){
        
    }
    
    public static synchronized LogSingletonLazyHolder getInstace(){
        return INSTACE;
    }
}
