package br.edu.ifs.pp.atividades.decorator.avaliacao.view;

import br.edu.ifs.pp.atividades.decorator.avaliacao.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.util.Enumeration;

public class AcaiGUI extends JFrame {
    private Acai acai; // Objeto que representa a tigela de açaí
    private JTextArea resumoArea;
    private ButtonGroup baseGroup; // Grupo de botões de rádio para as bases

    public AcaiGUI() {
        setTitle("Monte sua Tigela de Açaí");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Painel de bases
        JPanel basesPanel = createBasesPanel();

        // Painel de adicionais
        JPanel adicionaisPanel = createAdicionaisPanel();

        // Painel de drop para montar a tigela
        JPanel dropPanel = createDropPanel();

        // Campo para exibir resumo do pedido
        resumoArea = new JTextArea(5, 20);
        resumoArea.setEditable(false);
        resumoArea.setBorder(BorderFactory.createTitledBorder("Resumo do Pedido"));

        // Adiciona os componentes à janela
        add(basesPanel, BorderLayout.NORTH);
        add(adicionaisPanel, BorderLayout.WEST);
        add(dropPanel, BorderLayout.CENTER);
        add(new JScrollPane(resumoArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createBasesPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Selecione a Base"));

        baseGroup = new ButtonGroup();

        JRadioButton acaiPuroButton = new JRadioButton("Açaí Puro");
        acaiPuroButton.setActionCommand("AcaiPuro");
        baseGroup.add(acaiPuroButton);
        panel.add(acaiPuroButton);

        JRadioButton acaiBananaButton = new JRadioButton("Açaí com Banana");
        acaiBananaButton.setActionCommand("AcaiComBanana");
        baseGroup.add(acaiBananaButton);
        panel.add(acaiBananaButton);

        JRadioButton acaiCupuacuButton = new JRadioButton("Açaí com Cupuaçu");
        acaiCupuacuButton.setActionCommand("AcaiComCupuacu");
        baseGroup.add(acaiCupuacuButton);
        panel.add(acaiCupuacuButton);

        // Seleciona uma base padrão
        acaiPuroButton.setSelected(true);

        return panel;
    }

    private JPanel createAdicionaisPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Adicionais"));

        // Cria os labels arrastáveis para cada adicional
        panel.add(createDraggableLabel("Granola", new Granola(null)));
        panel.add(createDraggableLabel("Leite Condensado", new LeiteCondensado(null)));
        panel.add(createDraggableLabel("Paçoca", new Pacoca(null)));
        panel.add(createDraggableLabel("Castanha", new Castanha(null)));

        return panel;
    }

    private JLabel createDraggableLabel(String text, Acai adicional) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.CYAN);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        label.setTransferHandler(new ValueExportTransferHandler(adicional));

        label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                JComponent c = (JComponent) e.getSource();
                c.getTransferHandler().exportAsDrag(c, e, TransferHandler.COPY);
            }
        });

        return label;
    }

    private JPanel createDropPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createTitledBorder("Monte sua Tigela Aqui"));

        new DropTarget(panel, new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {
                try {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY);
                    Acai adicional = (Acai) dtde.getTransferable()
                            .getTransferData(new DataFlavor(Acai.class, "Acai"));

                    // Define a base se ainda não foi configurada
                    if (acai == null) {
                        acai = getSelectedBase();
                        if (acai == null) {
                            JOptionPane.showMessageDialog(null, "Selecione uma base antes de adicionar adicionais!", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    acai = adicional.getClass().getConstructor(Acai.class).newInstance(acai);

                    resumoArea.setText(acai.getNome()+ " - R$ " + acai.getPreco());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, 
                        "Erro ao adicionar adicional: " + e.getMessage(), 
                        "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return panel;
    }

    private Acai getSelectedBase() {
        String selectedBase = null;
        for (Enumeration<AbstractButton> buttons = baseGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                selectedBase = button.getActionCommand();
                break;
            }
        }

        switch (selectedBase) {
            case "AcaiPuro":
                return new AcaiPuro();
            case "AcaiComBanana":
                return new AcaiComBanana();
            case "AcaiComCupuacu":
                return new AcaiComCupuacu();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AcaiGUI::new);
    }

    // Classe auxiliar para transferir os valores via Drag and Drop
    private static class ValueExportTransferHandler extends TransferHandler {
        private final Acai adicional;

        public ValueExportTransferHandler(Acai adicional) {
            this.adicional = adicional;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new AcaiTransferable(adicional);
        }

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }
    }

    // Classe personalizada para Transferable
    private static class AcaiTransferable implements Transferable {
        private final Acai acai;

        public AcaiTransferable(Acai acai) {
            this.acai = acai;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{new DataFlavor(Acai.class, "Acai")};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.getRepresentationClass() == Acai.class;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
            if (isDataFlavorSupported(flavor)) {
                return acai;
            }
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
