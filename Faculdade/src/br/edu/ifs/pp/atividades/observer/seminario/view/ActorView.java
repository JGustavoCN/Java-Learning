package br.edu.ifs.pp.atividades.observer.seminario.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author José Gustavo
 */
public class ActorView extends JInternalFrame {

    private final JLabel messageLabel = new JLabel("Fazendo outra coisa...", SwingConstants.CENTER);

    public ActorView() {
        super("", false, false, false, false);

        // Configurações da janela
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 0)); // Transparente
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Painel central para imagem
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon originalIcon = new ImageIcon("src\\\\br\\\\edu\\\\ifs\\\\pp\\\\atividades\\\\observer\\\\seminario\\\\resource\\\\ator.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));

        // Configuração da mensagem
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setForeground(Color.DARK_GRAY);

        // Adicionar componentes ao layout principal
        add(imageLabel, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        // Configurações finais
        setPreferredSize(new Dimension(200, 200));
        setVisible(true);
        pack();
    }

    public void updateMessage(boolean isPaper) {
        messageLabel.setText(isPaper ? "Obrigado!" : "Fazendo outra coisa...");
    }
     public void updateMessage(String m) {
        messageLabel.setText(m);
    }
}
