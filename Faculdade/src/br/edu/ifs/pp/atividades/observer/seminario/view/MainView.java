package br.edu.ifs.pp.atividades.observer.seminario.view;

import br.edu.ifs.pp.atividades.observer.seminario.controller.AppController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Gustavo
 */
public class MainView extends javax.swing.JFrame {

    private List<ActorView> actors;
    private List<ActorView> actorsSem;
    private AgentView agent;
    private AgentView agentSem;
    private AppController controller;

    public MainView() {
        initComponents();
        init();
    }

    public void init() {
        actors = new ArrayList<>();

        controller = new AppController();
        agent = new AgentView(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.atualizarActorViews(actors);
            }
        });
        comObserver.add(agent);
        controller.criarActorViews(actors);
        for (ActorView actor : actors) {
            comObserver.add(actor);
        }

        actorsSem = new ArrayList<>();
        agentSem = new AgentView(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agenteAtivo = !agenteAtivo;
                if (agenteAtivo) {
                    agentSem.setMessage("Tem papel!");
                    for (ActorView actor : actorsSem) {
                        actor.updateMessage("Finalmente!!!!");
                    }
                } else {
                    agentSem.setMessage("Não tem papel!");
                    reiniciarLoop = true;
                }

            }
        });
        semObserver.add(agentSem);
        for (int i = 0; i < 3; i++) {
            ActorView actor = new ActorView();
            actorsSem.add(actor);
            semObserver.add(actor);
        }

        // Cria um novo thread para executar o loop de mensagens
        new Thread(this::gerenciarLoop).start();
    }

    private boolean reiniciarLoop = true; // Controla o reinício do loop
    private boolean agenteAtivo = false;
// Método que gerencia o loop das perguntas dos atores

    private void gerenciarLoop() {
        while (true) {
            if (!agenteAtivo && reiniciarLoop) {
                reiniciarLoop = false; // Reseta o sinal de reinício
                executarLoopAtores(); // Executa o loop dos atores
            }
            try {
                Thread.sleep(500); // Verifica o estado do agente a cada 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Loop para executar as perguntas dos atores
    private void executarLoopAtores() {
        int contador = 0;
        while (!agenteAtivo) { // Continua enquanto o agente estiver inativo
            contador++;
            for (ActorView actor : actorsSem) {
                actor.updateMessage("Tem Papel? nº " + contador);
            }
            try {
                Thread.sleep(2000); // Pausa de 2 segundos entre as perguntas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JTabbedPane();
        semObserver = new javax.swing.JDesktopPane();
        comObserver = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout semObserverLayout = new javax.swing.GroupLayout(semObserver);
        semObserver.setLayout(semObserverLayout);
        semObserverLayout.setHorizontalGroup(
            semObserverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        semObserverLayout.setVerticalGroup(
            semObserverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        mainPanel.addTab("semObserver", semObserver);

        javax.swing.GroupLayout comObserverLayout = new javax.swing.GroupLayout(comObserver);
        comObserver.setLayout(comObserverLayout);
        comObserverLayout.setHorizontalGroup(
            comObserverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        comObserverLayout.setVerticalGroup(
            comObserverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        mainPanel.addTab("comObserver", comObserver);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane comObserver;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JDesktopPane semObserver;
    // End of variables declaration//GEN-END:variables

}
