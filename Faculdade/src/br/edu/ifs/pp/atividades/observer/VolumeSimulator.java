/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifs.pp.atividades.observer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;


// Interface Observer
interface VolumeObserver {
    void updateVolume(int volume);
}

// Classe Subject (Controle de Volume)
class VolumeControl {
    private List<VolumeObserver> observers = new ArrayList<>();
    private int volume = 50; // Valor inicial do volume

    // Adiciona um observer
    public void addObserver(VolumeObserver observer) {
        observers.add(observer);
    }

    // Remove um observer
    public void removeObserver(VolumeObserver observer) {
        observers.remove(observer);
    }

    // Notifica os observers
    public void notifyObservers() {
        for (VolumeObserver observer : observers) {
            observer.updateVolume(volume);
        }
    }

    // Atualiza o volume e notifica os observers
    public void setVolume(int volume) {
        this.volume = volume;
        notifyObservers();
    }

    public int getVolume() {
        return volume;
    }
}

// Classe para o Equalizador (Observer)
class EqualizerPanel extends JPanel implements VolumeObserver {
    private final int NUM_BARS = 10;
    private final int[] bars = new int[NUM_BARS];
    private final Color barColor = new Color(0, 204, 255);

    public EqualizerPanel() {
        Arrays.fill(bars, 0);
    }

    @Override
    public void updateVolume(int volume) {
        // Simula a resposta do equalizador variando as barras
        for (int i = 0; i < NUM_BARS; i++) {
            bars[i] = (int) (Math.random() * volume);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = getWidth() / NUM_BARS;
        for (int i = 0; i < NUM_BARS; i++) {
            int barHeight = bars[i];
            g.setColor(barColor);
            g.fillRect(i * barWidth, getHeight() - barHeight, barWidth, barHeight);
        }
    }
}

// Classe para o Gráfico de Intensidade de Som (Observer)
class VolumeGraph extends JPanel implements VolumeObserver {
    private final java.util.List<Integer> data = new ArrayList<>();

    @Override
    public void updateVolume(int volume) {
        // Adiciona o novo valor de volume à lista
        if (data.size() >= getWidth()) {
            data.remove(0);
        }
        data.add(volume);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        for (int i = 1; i < data.size(); i++) {
            int prevX = (i - 1);
            int prevY = getHeight() - data.get(i - 1);
            int currentX = i;
            int currentY = getHeight() - data.get(i);

            g.drawLine(prevX, prevY, currentX, currentY);
        }
    }
}

// Classe principal para criar a interface e integrar os componentes
public class VolumeSimulator extends JFrame {
    private VolumeControl volumeControl;
    private EqualizerPanel equalizerPanel;
    private VolumeGraph volumeGraph;
    private JSlider volumeSlider;

    public VolumeSimulator() {
        setTitle("Simulador de Controle de Volume");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        volumeControl = new VolumeControl();

        // Criação dos observers
        equalizerPanel = new EqualizerPanel();
        volumeGraph = new VolumeGraph();

        // Adicionando observers ao volume control
        volumeControl.addObserver(equalizerPanel);
        volumeControl.addObserver(volumeGraph);

        // Criação do controle deslizante de volume (JSlider)
        volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setMinorTickSpacing(1);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        volumeSlider.addChangeListener(e -> {
            volumeControl.setVolume(volumeSlider.getValue());
        });

        // Layout da interface
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(new JLabel("Controle de Volume"), BorderLayout.NORTH);
        controlPanel.add(volumeSlider, BorderLayout.CENTER);

        JPanel graphicsPanel = new JPanel();
        graphicsPanel.setLayout(new GridLayout(2, 1));
        graphicsPanel.add(equalizerPanel);
        graphicsPanel.add(volumeGraph);

        add(controlPanel, BorderLayout.NORTH);
        add(graphicsPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VolumeSimulator());
    }
}

