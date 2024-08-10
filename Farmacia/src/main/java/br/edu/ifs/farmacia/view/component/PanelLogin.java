package br.edu.ifs.farmacia.view.component;

import br.edu.ifs.farmacia.controller.LoginController;
import br.edu.ifs.farmacia.model.login.Administrador;
import br.edu.ifs.farmacia.model.login.Funcionario;
import br.edu.ifs.farmacia.model.login.Usuario;
import br.edu.ifs.farmacia.view.swing.Button;
import br.edu.ifs.farmacia.view.swing.MyTextField;
import br.edu.ifs.farmacia.view.swing.MyPasswordField;
import br.edu.ifs.farmacia.util.ImageLoader;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelLogin extends javax.swing.JLayeredPane {
    
    private Funcionario funcionario;
    private Administrador administrador;

    public Usuario getUsuario() {
        if (funcionario != null) {
            return funcionario;
        }if (administrador != null) {
            return administrador;
        }
        return null;
    }

    
    
    public PanelLogin(ActionListener eventLogin) {
        initComponents();
        initAdministrador(eventLogin);
        initFuncionario(eventLogin);
        loginFuncionario.setVisible(false);
        loginAdministracao.setVisible(true);
        
    }

    private void initAdministrador(ActionListener loginAdministradorEvent) {
        
        loginAdministracao.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Administração");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        loginAdministracao.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(ImageLoader.loadImage("mail.png"));
        txtEmail.setHint("Email");
        loginAdministracao.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(ImageLoader.loadImage("pass.png"));
        txtPass.setHint("Senha");
        loginAdministracao.add(txtPass, "w 60%");
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(loginAdministradorEvent);
        cmd.setText("Entrar");
        loginAdministracao.add(cmd, "w 40%, h 40");
        
        cmd.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            String password = String.valueOf(txtPass.getPassword());
            funcionario = new Funcionario(email, password);
       });
    }

    private void initFuncionario(ActionListener loginFuncionarioEvent) {
        loginFuncionario.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Funcionário");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        loginFuncionario.add(label);
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(ImageLoader.loadImage("mail.png"));
        txtEmail.setHint("Email");
        loginFuncionario.add(txtEmail, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(ImageLoader.loadImage("pass.png"));
        txtPass.setHint("Senha");
        loginFuncionario.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Esqueceu sua senha ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginFuncionario.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(loginFuncionarioEvent);
        cmd.setText("Entrar");
        loginFuncionario.add(cmd, "w 40%, h 40");
        cmd.addActionListener(e -> {
            String email = txtEmail.getText().trim();
            String password = String.valueOf(txtPass.getPassword());
            funcionario = new Funcionario(email, password);
        });
    }
    
    public void trocarPanel(boolean show) {
        if (show) { 
            loginAdministracao.setVisible(true);
            loginFuncionario.setVisible(false);
        } else {
            loginAdministracao.setVisible(false);
            loginFuncionario.setVisible(true);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginFuncionario = new javax.swing.JPanel();
        loginAdministracao = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        loginFuncionario.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginFuncionarioLayout = new javax.swing.GroupLayout(loginFuncionario);
        loginFuncionario.setLayout(loginFuncionarioLayout);
        loginFuncionarioLayout.setHorizontalGroup(
            loginFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginFuncionarioLayout.setVerticalGroup(
            loginFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(loginFuncionario, "card3");

        loginAdministracao.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginAdministracaoLayout = new javax.swing.GroupLayout(loginAdministracao);
        loginAdministracao.setLayout(loginAdministracaoLayout);
        loginAdministracaoLayout.setHorizontalGroup(
            loginAdministracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginAdministracaoLayout.setVerticalGroup(
            loginAdministracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(loginAdministracao, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel loginAdministracao;
    private javax.swing.JPanel loginFuncionario;
    // End of variables declaration//GEN-END:variables
}
