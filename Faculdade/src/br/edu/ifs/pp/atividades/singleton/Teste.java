/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.pp.atividades.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Aluno
 */
public class Teste {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // Não é possivel acessar diretamente, mas    
        //LogSingletonEager = new LogSingletonEager();
        LogSingletonEager primeiraInstancia = LogSingletonEager.getInstace();
        // Reflexição
        Constructor<LogSingletonEager> constructorDoSingleton = LogSingletonEager.class.getDeclaredConstructor();
        constructorDoSingleton.setAccessible(true);
        LogSingletonEager segundaInstancia = constructorDoSingleton.newInstance();
        
        // Assim é possivel criar duas instacia de um singleton
        System.out.println(primeiraInstancia);
        System.out.println(segundaInstancia);
    }
}
