package br.edu.ifs.pp.atividades.observer.seminario.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author José Gustavo
 */
public class AgentView extends JInternalFrame {

    private final JLabel messageLabel = new JLabel("Não tem papel!", SwingConstants.CENTER);
    private final JCheckBox paperCheckBox = new JCheckBox();

    public AgentView(ActionListener event) {
        super("", false, false, false, false);

        // Configurações da janela
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 0)); // Transparente
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Painel central para imagem
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon originalIcon = new ImageIcon("src\\br\\edu\\ifs\\pp\\atividades\\observer\\seminario\\resource\\agent.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));

        // Painel inferior para checkbox e mensagem
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setOpaque(false);

        // Configuração da mensagem
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setForeground(Color.DARK_GRAY);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(messageLabel);

        // Configuração do checkbox
        paperCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        paperCheckBox.addActionListener(e -> {
            event.actionPerformed(e);
            messageLabel.setText(paperCheckBox.isSelected() ? "Tem papel!" : "Não tem papel!");
        });
        bottomPanel.add(Box.createRigidArea(new Dimension(3, 10))); // Espaçamento
        bottomPanel.add(paperCheckBox);

        // Adicionar componentes ao layout principal
        add(imageLabel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.NORTH);

        // Configurações finais
        setPreferredSize(new Dimension(200, 200));
        setVisible(true);
        pack();
    }

    void setMessage(String m) {
       messageLabel.setText(m);
    }

}
