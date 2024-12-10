/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.pp.atividades.observer;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Aluno
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Agente {
    private String resposta;
    private boolean respostaDisponivel;

    // Método para o agente gerar uma resposta (simulada)
    public synchronized void gerarResposta() {
        // Simula o tempo de espera do agente para gerar a resposta
        new Timer(5000, e -> {
            resposta = "Resposta pronta!";
            respostaDisponivel = true; // Resposta pronta
            System.out.println("Agente: Resposta pronta.");
        }).start();
    }

    // Método para os atores verificarem a resposta
    public synchronized String verificarResposta() {
        if (respostaDisponivel) {
            respostaDisponivel = false; // Consome a resposta
            return resposta;
        }
        return null; // Ainda não tem resposta
    }

    // Retorna o estado do agente (processando ou pronto)
    public synchronized String getEstado() {
        return respostaDisponivel ? "Resposta pronta!" : "Agente processando...";
    }
}

class Ator implements Runnable {
    private JLabel label;
    private Agente agente;
    private int contador;

    public Ator(Agente agente, JPanel painel) {
        this.agente = agente;
        this.contador = 0;
        this.label = new JLabel("Ator aguardando resposta...");
        painel.add(label);
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Incrementa o contador de perguntas
                contador++;

                // Exibe a pergunta do ator
                label.setText("Ator perguntando ao agente... Pergunta nº " + contador);

                // O ator verifica se a resposta está disponível
                String resposta = null;
                while (resposta == null) {
                    // O ator aguarda a resposta
                    resposta = agente.verificarResposta();
                    label.setText("Ator aguardando resposta... Pergunta nº " + contador);
                    Thread.sleep(1000); // Aguarda 1 segundo para verificar novamente
                }

                // Exibe a resposta quando o agente responde
                label.setText("Ator recebeu a resposta: " + resposta);

                // Aguarda antes de fazer a próxima pergunta
                Thread.sleep(1000); // Tempo para ler a resposta antes de perguntar novamente
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SimulacaoSwing {
    public static void main(String[] args) {
        // Cria o painel de interface
        JFrame frame = new JFrame("Simulação de Atores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        frame.add(painel);

        // Cria o agente
        Agente agente = new Agente();
        JLabel labelAgente = new JLabel("Agente processando...");
        painel.add(labelAgente);

        // Cria múltiplos atores
        List<Ator> atores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {  // Exemplo com 3 atores
            Ator ator = new Ator(agente, painel);
            atores.add(ator);

            // Inicia a execução de cada ator em uma thread
            new Thread(ator).start();
        }

        // Atualiza o comportamento do agente
        new Timer(1000, e -> {
            labelAgente.setText(agente.getEstado()); // Atualiza a interface com o estado do agente
        }).start();

        // Exibe a interface gráfica
        frame.pack();
        frame.setVisible(true);

        // Simula o agente gerando uma resposta após algum tempo
        agente.gerarResposta();
    }
}