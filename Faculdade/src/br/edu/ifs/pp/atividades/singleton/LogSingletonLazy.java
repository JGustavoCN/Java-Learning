package br.edu.ifs.pp.atividades.singleton;

/**
 *
 * Use Lazy Initialization quando você não sabe se o objeto será realmente
 * necessário e quer evitar o custo de criação do objeto até que ele seja de
 * fato utilizado. Isso pode ser útil, por exemplo, quando o processo de criação
 * do objeto é caro em termos de tempo ou recursos.
 *
 * Desvantagens: 
 * 
 *  1 - Concorrência: Se o código for executado em um ambiente
 * multithreaded, pode ser necessário tomar cuidados extras para garantir que a
 * inicialização ocorra de forma segura em relação a múltiplas threads tentando
 * criar a instância ao mesmo tempo. 
 * 
 *  2 - Complexidade: Pode adicionar complexidade ao código, porque você 
 * precisará gerenciar corretamente o processo de criação e acesso à instância.
 *
 * @author José Gustavo
 *
 */
public class LogSingletonLazy {

    /*
    Com volatile, a JVM impede que o processo de criação da instância seja 
    "otimizado" de maneira que a instância possa ser vista como já criada antes 
    de ter sido completamente inicializada.
     */
    private static volatile LogSingletonLazy instace;

    private LogSingletonLazy() {

    }

// Poderia ser assim mas não é eficiente public static synchronized LogSingletonLazy getInstace()
    public static LogSingletonLazy getInstace() {
        /*
      Double-checked locking é uma técnica para melhorar a eficiência de um 
      padrão Singleton com Lazy Initialization, tentando minimizar a sobrecarga 
      de desempenho que a sincronização pode causar.
         */
        if (instace == null) {
            synchronized (LogSingletonLazy.class) {
                if (instace == null) {
                    instace = new LogSingletonLazy();
                }
            }
        }
        return instace;
    }
}
