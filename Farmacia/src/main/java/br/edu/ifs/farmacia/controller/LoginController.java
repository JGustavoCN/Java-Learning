package br.edu.ifs.farmacia.controller;

import br.edu.ifs.farmacia.model.login.Administrador;
import br.edu.ifs.farmacia.model.login.TipoUsuario;
import br.edu.ifs.farmacia.model.login.Usuario;
import br.edu.ifs.farmacia.persistence.UsuarioDataManager;
import br.edu.ifs.farmacia.repository.UsuarioRepository;
import br.edu.ifs.farmacia.view.MainSystem;
import javax.swing.JFrame;

/**
 *
 * @author Aluno
 */
public class LoginController {
    
    private static LoginController instance;
    private final UsuarioRepository usuarioRepository;

    private Usuario usuarioLogado;
    
    private LoginController() {
        usuarioRepository = UsuarioRepository.getInstance();
        // Carregar usuários do arquivo
        Administrador adm = new Administrador("admin", "admin");
        UsuarioDataManager.salvarUsuario(adm);
        UsuarioDataManager.carregarUsuarios(usuarioRepository);
    }

    public static LoginController getInstance() {
        
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }
    public boolean logar(Usuario usuarioLogando, JFrame frame) {
        Usuario usuario = usuarioRepository.buscarUsuario(usuarioLogando);
        if (usuario == null) return false;
        this.usuarioLogado = usuario;
        frame.dispose();
        MainSystem.main();
        return true;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    public boolean loginAdministrador() {
        return usuarioLogado != null && TipoUsuario.ADMINISTRADOR == usuarioLogado.getTipo();
    }

    public boolean loginFuncionario() {
        return usuarioLogado != null && TipoUsuario.FUNCIONARIO == usuarioLogado.getTipo();
    }
}
