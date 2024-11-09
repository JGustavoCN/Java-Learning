package br.edu.ifs.ed2;import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArvoreBinariaVisualizacao extends JPanel {
    private ArvoreBinariaBusca arvore;
    private double zoom = 1.0;
    private int deslocamentoX = 0;
    private int deslocamentoY = 30;
    private int mouseX = 0, mouseY = 0;
    private boolean isDragging = false;

    public ArvoreBinariaVisualizacao(ArvoreBinariaBusca arvore) {
        this.arvore = arvore;

        // Ouvinte para zoom (roda do mouse)
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation() < 0) zoomIn();
                else zoomOut();
                repaint();
            }
        });

        // Ouvinte para arrastar a árvore
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                isDragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    deslocamentoX += e.getX() - mouseX;
                    deslocamentoY += e.getY() - mouseY;
                    mouseX = e.getX();
                    mouseY = e.getY();
                    repaint();
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    resetZoom();
                    repaint();
                }
            }
        });

        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Ativar anti-aliasing para suavizar as linhas e melhorar o visual
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Aplicar zoom e deslocamento
        g2d.scale(zoom, zoom);
        g2d.translate(deslocamentoX, deslocamentoY);

        if (arvore.getRaiz() != null) {
            int initialX = getWidth() / 2;
            desenharArvore(g, arvore.getRaiz(), initialX, 50, calcularDistancia(arvore.getAltura()));
        }

        desenharLegenda(g);
    }

    private void desenharArvore(Graphics g, No no, int x, int y, int distancia) {
        if (no == null) {
            return;
        }

        // Desenho do nó
        desenharNo(g, no, x, y);

        int novaDistancia = distancia / 2;  // Reduzir a distância horizontal à medida que descemos na árvore

        // Desenhando as linhas de conexão
        if (no.esquerdo != null) {
            desenharLinha(g, x, y, x - novaDistancia, y + 80, Color.RED); // Linha para o filho à esquerda
            desenharArvore(g, no.esquerdo, x - novaDistancia, y + 80, novaDistancia);
        }

        if (no.direito != null) {
            desenharLinha(g, x, y, x + novaDistancia, y + 80, Color.BLUE); // Linha para o filho à direita
            desenharArvore(g, no.direito, x + novaDistancia, y + 80, novaDistancia);
        }
    }

    // Desenha um nó na posição especificada
    private void desenharNo(Graphics g, No no, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(100, 181, 246));  // Cor de fundo azul claro
        g2d.fillOval(x - 30, y - 30, 60, 60);  // Nó com bordas arredondadas

        g2d.setColor(new Color(0, 82, 155));  // Cor de borda mais escura
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(x - 30, y - 30, 60, 60);

        // Adicionando o número do nó com uma fonte maior e centralizado
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g2d.getFontMetrics();
        int stringWidth = fm.stringWidth(String.valueOf(no.elemento));
        int stringHeight = fm.getHeight();
        g2d.drawString(String.valueOf(no.elemento), x - stringWidth / 2, y + stringHeight / 4);
    }

    // Desenha a linha de conexão entre dois nós
    private void desenharLinha(Graphics g, int x1, int y1, int x2, int y2, Color cor) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor);  // Usando a cor da linha (vermelha ou azul)
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(x1, y1 + 30, x2, y2 - 30); // Linha conecta diretamente os lados dos nós
    }

    // Desenha a legenda com os controles fixos
    private void desenharLegenda(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 14));
        g.drawString("Controles:", 10, getHeight() - 100);
        g.drawString("Roda do mouse: Zoom in/out", 10, getHeight() - 80);
        g.drawString("Clique e arraste: Mover árvore", 10, getHeight() - 60);
        g.drawString("Pressione 'R' para resetar zoom", 10, getHeight() - 40);
    }

    // Método para calcular a distância inicial entre nós com base na altura da árvore
    private int calcularDistancia(int altura) {
        return (int) (Math.pow(2, altura) * 10);  // Ajusta a distância com base na altura
    }

    // Método de zoom in (aumentar o zoom)
    private void zoomIn() {
        if (zoom < 2.0) { // Limite máximo do zoom
            zoom *= 1.1;
            ajustarDeslocamento();
        }
    }

    // Método de zoom out (diminuir o zoom)
    private void zoomOut() {
        if (zoom > 0.3) { // Limite mínimo do zoom
            zoom /= 1.1;
            ajustarDeslocamento();
        }
    }

    // Ajustar o deslocamento ao aplicar zoom para manter a árvore no centro
    private void ajustarDeslocamento() {
        deslocamentoX = (int) (deslocamentoX * 1.1);
        deslocamentoY = (int) (deslocamentoY * 1.1);
    }

    // Método para resetar o zoom ao estado inicial
    private void resetZoom() {
        zoom = 1.0;
        deslocamentoX = 0;
        deslocamentoY = 30;
    }
}
