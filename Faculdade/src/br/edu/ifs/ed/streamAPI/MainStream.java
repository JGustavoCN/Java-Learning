package br.edu.ifs.ed.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author José Gustavo
 */
public class MainStream {

    static List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

    public static void main(String[] args) {
        /*
        

Desafio 7 - Encontrar o segundo número maior da lista:
Com a ajuda da Stream API, encontre o segundo número maior da lista e exiba o resultado no console.

Desafio 8 - Somar os dígitos de todos os números da lista:
Utilizando a Stream API, realize a soma dos dígitos de todos os números da lista e exiba o resultado no console.

Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):
Com a Stream API, verifique se todos os números da lista são distintos (não se repetem) e exiba o resultado no console.

Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
Utilize a Stream API para agrupar os valores ímpares múltiplos de 3 ou de 5 e exiba o resultado no console.
        
         */
        listaOrdemCrescente(numeros);
        System.out.println("\n--------------------------");
        listaSomaPares(numeros);
        System.out.println("--------------------------");
        listaTodosPositivos(numeros);
        System.out.println("--------------------------");
        listaRemoverImpares(numeros);
        System.out.println("\n--------------------------");
        listaMediaMaior5(numeros);
        System.out.println("--------------------------");
        listaContemMaior10(numeros);
        System.out.println("--------------------------");
        listaSegundoMaior(numeros);
        System.out.println("--------------------------");
        listaSomarDigitos(numeros);
        System.out.println("--------------------------");
        listaTodosSaoDiferentes(numeros);
        System.out.println("--------------------------");
        listaGrupoMult35(numeros);
    }

    public static void listaOrdemCrescente(List<Integer> lista) {
        /*Desafio 1 - Mostre a lista na ordem numérica:
        Crie um programa que utilize a Stream API para ordenar a lista de números em ordem crescente e a exiba no console.*/

        //lista.stream().sorted().forEach(System.out::print);
        lista.stream().sorted().forEach(item -> System.out.print(item + " "));
    }

    public static void listaSomaPares(List<Integer> lista) {
        /*Desafio 2 - Imprima a soma dos números pares da lista:
        Utilizando a Stream API, realize a soma dos números pares da lista e exiba o resultado no console.*/

        lista.stream().filter(item -> item % 2 == 0).reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(lista.stream().filter(item -> item % 2 == 0).reduce(0, (x, y) -> x + y));
        //IntStream trabalhar com tipo primitivo
        System.out.println(lista.stream().mapToInt(Integer::intValue).filter(item -> item % 2 == 0).sum());
        System.out.println(lista.stream().filter(item -> item % 2 == 0).mapToInt(Integer::intValue).summaryStatistics().getSum());
    }

    public static void listaTodosPositivos(List<Integer> lista) {
        /*Desafio 3 - Verifique se todos os números da lista são positivos:
        Com a ajuda da Stream API, verifique se todos os números da lista são positivos e exiba o resultado no console.*/

        //allMatch todos são positivos?
        System.out.println((lista.stream().allMatch(item -> item > 0) ? "Todos positivos" : "Algum não é positivo"));
        //anyMatch algum é negativo?
        System.out.println((lista.stream().anyMatch(item -> item < 0) ? "Algum não é positivo" : "Todos positivos"));
        //noneMatch nenhum é negativo?
        System.out.println((lista.stream().noneMatch(item -> item < 0) ? "Todos positivos" : "Algum não é positivo"));
        //findAny pegue qualquer um
        System.out.println((lista.stream().filter(item -> item < 0).findAny().isPresent() ? "Algum não é positivo" : "Todos positivos"));
        //findFirt pegue o primeiro
        System.out.println((lista.stream().filter(item -> item < 0).findFirst().isPresent() ? "Algum não é positivo" : "Todos positivos"));
    }

    public static List<Integer> listaRemoverImpares(List<Integer> lista) {
        /*Desafio 4 - Remova todos os valores ímpares:
        Utilize a Stream API para remover os valores ímpares da lista e imprima a lista resultante no console.*/
        List<Integer> listaNoImpar;

        lista.stream().filter(item -> item % 2 == 0).forEach(item -> System.out.print(item + " "));
        listaNoImpar = lista.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());

        return listaNoImpar;

    }

    public static void listaMediaMaior5(List<Integer> lista) {
        /*Desafio 5 - Calcule a média dos números maiores que 5:
        Com a Stream API, calcule a média dos números maiores que 5 e exiba o resultado no console.*/
        long quat = lista.stream().filter(item -> item > 5).count();
        lista.stream().filter(item -> item > 5).reduce(Integer::sum).ifPresent(item -> System.out.println(item / quat));
        lista.stream().filter(item -> item > 5).mapToInt(Integer::intValue).average().ifPresent(System.out::println);
        System.out.println(lista.stream().filter(item -> item > 5).collect(Collectors.averagingInt(Integer::intValue)));
        System.out.println(lista.stream().filter(item -> item > 5).mapToInt(Integer::intValue).summaryStatistics().getAverage());
    }

    public static void listaContemMaior10(List<Integer> lista) {
        /*Desafio 6 - Verificar se a lista contém algum número maior que 10:
        Utilize a Stream API para verificar se a lista contém algum número maior que 10 e exiba o resultado no console.*/
        System.out.println((lista.stream().anyMatch(item -> item > 10) ? "Tem um numero maior que 10" : "Não tem um numero maior que 10"));
    }

    public static void listaSegundoMaior(List<Integer> lista) {
        /*Desafio 7 - Encontrar o segundo número maior da lista:
        Com a ajuda da Stream API, encontre o segundo número maior da lista e exiba o resultado no console.*/
        System.out.println(lista.stream().sorted().collect(Collectors.toList()).get(lista.size() - 2));
        lista.stream().sorted(Comparator.reverseOrder()).limit(2).min(Integer::compare).ifPresent(System.out::println);
        lista.stream().sorted((Comparator.comparing(Integer::intValue, Integer::compare).reversed())).limit(2).min(Integer::compare).ifPresent(System.out::println);
        lista.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
    }

    public static void listaSomarDigitos(List<Integer> lista) {
        /*Desafio 8 - Somar os dígitos de todos os números da lista:
        Utilizando a Stream API, realize a soma dos dígitos de todos os números da lista e exiba o resultado no console.*/
        int sum1 = lista.stream()
                .flatMapToInt(num -> String.valueOf(num).chars().map(Character::getNumericValue))
                .sum();
        System.out.println(sum1);
        int somaDigitos1 = numeros.stream()
                .flatMapToInt(num -> String.valueOf(num).chars())
                .map(ch -> ch - '0')
                .sum();
        System.out.println(somaDigitos1);
        
    }
    
    public static void listaTodosSaoDiferentes(List<Integer> lista) {
        /*Desafio 9 - Verificar se todos os números da lista são distintos (não se repetem):
        Com a Stream API, verifique se todos os números da lista são distintos (não se repetem) e exiba o resultado no console.*/
        System.out.println((lista.stream().distinct().count()==lista.stream().count()?"Todos são diferentes":"Nem todos são diferentes"));
        
    }

    public static void listaGrupoMult35(List<Integer> lista) {
        /*Desafio 10 - Agrupe os valores ímpares múltiplos de 3 ou de 5:
        Utilize a Stream API para agrupar os valores ímpares múltiplos de 3 ou de 5 e exiba o resultado no console.*/
        lista.stream().filter(item -> item%2!= 0 && (item%3== 0 || item%5==0)).forEach(System.out::println);
    }

}
