package br.edu.ifs.pp.atividades.singleton;

/**
 * 
 * A ideia central do Singleton com enum é que o enum em Java é garantido pela 
 * linguagem como thread-safe e é instanciado de forma única quando a classe enum 
 * é carregada pela JVM. Além disso, o padrão de enum implementa internamente os 
 * mecanismos necessários para garantir que a instância da classe seja criada de 
 * maneira eficiente, sem a necessidade de sincronização ou de complicações extras.
 * 
 * Quando usar:
 *   1 - Quando não há necessidade de controle sobre o processo de criação da 
 * instância de maneira mais complexa (como no caso de Lazy Initialization). 
 *   2 - Quando você precisa garantir segurança contra deserialização ou reflexão 
 * que poderiam quebrar o padrão Singleton tradicional.
 *   3 - Quando quiser algo simplificado, mas não simples
 * 
 * Desvantagens:
 * 
 *   1 - Menos Flexibilidade: O Singleton com enum pode ser menos flexível quando 
 * você precisa controlar o processo de inicialização de forma mais específica. 
 * Por exemplo, se você precisar realizar alguma lógica complexa durante a criação 
 * da instância, o Singleton com enum pode ser limitado, já que ele é projetado 
 * para inicializar a instância de maneira muito simples.
 * 
 *   2 - Maior complexidade em sistemas dinâmicos: Em sistemas muito dinâmicos 
 * onde a criação do Singleton precisa ser controlada em tempo de execução, 
 * o enum pode ser mais restritivo. Embora isso seja uma vantagem em muitos casos 
 * (por exemplo, para garantir a imutabilidade), pode ser uma desvantagem se 
 * você precisar de flexibilidade.
 * 
 * @author José Gustavo
 * 
 */
public enum LogSingletonEnum {
    INSTACE;
    
    private String log; 
    
    LogSingletonEnum(){
        log = "Log: ";
    }
    
    public void log(String log){
        this.log += log;
    }
}
