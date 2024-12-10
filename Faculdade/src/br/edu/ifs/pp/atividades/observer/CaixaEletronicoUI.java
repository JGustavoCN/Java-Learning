/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.pp.atividades.observer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void atualizar(double saldo, List<String> historico);
}

// Classe Subject (Conta Bancária)
class ContaBancaria {
    private double saldo;
    private List<String> historico;
    private List<Observer> observers;

    public ContaBancaria() {
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // Método para adicionar um observer
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    // Método para remover um observer
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    // Método para notificar os observers
    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(saldo, historico);
        }
    }

    // Métodos para realizar transações
    public void depositar(double valor) {
        saldo += valor;
        historico.add("Depósito: " + valor);
        notificarObservers();
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            historico.add("Saque: " + valor);
            notificarObservers();
        } else {
            historico.add("Falha no saque: Saldo insuficiente.");
            notificarObservers();
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getHistorico() {
        return historico;
    }
}

// Observer para exibir o saldo
class ObserverSaldo implements Observer {
    private JLabel labelSaldo;

    public ObserverSaldo(JLabel labelSaldo) {
        this.labelSaldo = labelSaldo;
    }

    @Override
    public void atualizar(double saldo, List<String> historico) {
        labelSaldo.setText("Saldo: R$ " + saldo);
    }
}

// Observer para exibir o histórico de transações
class ObserverHistorico implements Observer {
    private JList<String> listHistorico;
    private DefaultListModel<String> model;

    public ObserverHistorico(JList<String> listHistorico) {
        this.listHistorico = listHistorico;
        this.model = new DefaultListModel<>();
        this.listHistorico.setModel(model);
    }

    @Override
    public void atualizar(double saldo, List<String> historico) {
        model.clear();
        for (String transacao : historico) {
            model.addElement(transacao);
        }
    }
}

// Observer para exibir alertas de segurança
class ObserverAlerta implements Observer {
    private JTextArea alertTextArea;

    public ObserverAlerta(JTextArea alertTextArea) {
        this.alertTextArea = alertTextArea;
    }

    @Override
    public void atualizar(double saldo, List<String> historico) {
        // Exibe alerta se houver falha em transações
        for (String transacao : historico) {
            if (transacao.contains("Falha")) {
                alertTextArea.setText("Alerta de Segurança: " + transacao);
                return;
            }
        }
        alertTextArea.setText("");
    }
}

// Classe principal para a interface gráfica
public class CaixaEletronicoUI {
    private JFrame frame;
    private JLabel labelSaldo;
    private JList<String> listHistorico;
    private JTextArea alertTextArea;
    private ContaBancaria contaBancaria;

    public CaixaEletronicoUI() {
        contaBancaria = new ContaBancaria();
        
        // Setup da janela
        frame = new JFrame("Simulador de Caixa Eletrônico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Painel de saldo
        JPanel panelSaldo = new JPanel();
        labelSaldo = new JLabel("Saldo: R$ 0,00");
        panelSaldo.add(labelSaldo);

        // Painel de histórico
        JPanel panelHistorico = new JPanel();
        listHistorico = new JList<>();
        panelHistorico.add(new JScrollPane(listHistorico));

        // Painel de alertas
        JPanel panelAlertas = new JPanel();
        alertTextArea = new JTextArea(5, 20);
        alertTextArea.setEditable(false);
        panelAlertas.add(new JScrollPane(alertTextArea));

        // Painel de transações
        JPanel panelTransacoes = new JPanel();
        JButton btnDepositar = new JButton("Depositar");
        JButton btnSacar = new JButton("Sacar");
        JTextField campoValor = new JTextField(10);
        panelTransacoes.add(campoValor);
        panelTransacoes.add(btnDepositar);
        panelTransacoes.add(btnSacar);

        // Adicionando componentes na janela
        frame.add(panelSaldo, BorderLayout.NORTH);
        frame.add(panelHistorico, BorderLayout.CENTER);
        frame.add(panelAlertas, BorderLayout.SOUTH);
        frame.add(panelTransacoes, BorderLayout.EAST);

        // Observadores
        ObserverSaldo observerSaldo = new ObserverSaldo(labelSaldo);
        ObserverHistorico observerHistorico = new ObserverHistorico(listHistorico);
        ObserverAlerta observerAlerta = new ObserverAlerta(alertTextArea);

        contaBancaria.adicionarObserver(observerSaldo);
        contaBancaria.adicionarObserver(observerHistorico);
        contaBancaria.adicionarObserver(observerAlerta);

        // Ações dos botões
        btnDepositar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(campoValor.getText());
                contaBancaria.depositar(valor);
                campoValor.setText("");
            }
        });

        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(campoValor.getText());
                contaBancaria.sacar(valor);
                campoValor.setText("");
            }
        });

        // Configuração da janela
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CaixaEletronicoUI();
    }
}
