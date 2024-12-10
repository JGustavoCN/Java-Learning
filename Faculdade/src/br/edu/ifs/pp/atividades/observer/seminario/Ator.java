/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.pp.atividades.observer.seminario;

/**
 *
 * @author Aluno
 */
public class Ator {
    private String nome;
    private boolean papelDisponivel = false;

    public Ator(String nome) {
        this.nome = nome;
    }

    // Método para atualizar a notificação do ator
    public void atualizar(String mensagem) {
        this.papelDisponivel = true;
        System.out.println(nome + ": " + mensagem); // Exibe a mensagem de notificação
    }

    public String getNome() {
        return nome;
    }

    public boolean isPapelDisponivel() {
        return papelDisponivel;
    }
}
