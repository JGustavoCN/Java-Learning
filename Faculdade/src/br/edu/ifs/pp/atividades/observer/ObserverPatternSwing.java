/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.pp.atividades.observer;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Subject (Observável)
class Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String text;

    public void setText(String text) {
        this.text = text;
        notifyObservers();
    }

    public String getText() {
        return text;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(text);
        }
    }
}

// Observer (Observador)
interface Observer {
    void update(String text);
}

// Janela Principal
public class ObserverPatternSwing{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Padrão Observer com Java Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            // Modelo (Subject)
            Subject subject = new Subject();

            // Observadores (Múltiplos JLabel)
            JPanel observersPanel = new JPanel();
            observersPanel.setLayout(new GridLayout(3, 1));

            JLabel observer1 = new JLabel("Observador 1: ");
            JLabel observer2 = new JLabel("Observador 2: ");
            JLabel observer3 = new JLabel("Observador 3: ");

            observer1.setFont(new Font("Arial", Font.PLAIN, 16));
            observer2.setFont(new Font("Arial", Font.PLAIN, 16));
            observer3.setFont(new Font("Arial", Font.PLAIN, 16));

            subject.addObserver(text -> observer1.setText("Observador 1: " + text));
            subject.addObserver(text -> observer2.setText("Observador 2: " + text));
            subject.addObserver(text -> observer3.setText("Observador 3: " + text));

            observersPanel.add(observer1);
            observersPanel.add(observer2);
            observersPanel.add(observer3);

            // Entrada para atualizar o modelo
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new BorderLayout());

            JLabel inputLabel = new JLabel("Digite algo: ");
            inputLabel.setFont(new Font("Arial", Font.BOLD, 16));

            JTextField inputField = new JTextField();
            inputField.setFont(new Font("Arial", Font.PLAIN, 16));

            inputField.addActionListener(e -> subject.setText(inputField.getText()));

            inputPanel.add(inputLabel, BorderLayout.WEST);
            inputPanel.add(inputField, BorderLayout.CENTER);

            // Adiciona componentes ao frame
            frame.add(inputPanel, BorderLayout.NORTH);
            frame.add(observersPanel, BorderLayout.CENTER);

            // Exibe a janela
            frame.setVisible(true);
        });
    }
}
