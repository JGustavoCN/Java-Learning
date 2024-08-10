package br.edu.ifs.farmacia.repository;

import br.edu.ifs.farmacia.model.login.Administrador;
import br.edu.ifs.farmacia.model.login.Usuario;
import br.edu.ifs.farmacia.util.Lista;
import java.io.Serializable;

/**
 * Singleton para gerenciamento de usuários.
 */
public class UsuarioRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    // Instância única do Singleton
    private static UsuarioRepository instance;

    // Lista de usuários
    private final Lista<Usuario> usuarios;

    

    // Construtor privado para evitar instância externa
    private UsuarioRepository() {
        this.usuarios = new Lista<>();
    }

    // Método para obter a instância única do Singleton
    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    // Retorna todos os usuários
    public Lista<Usuario> pegarTodosUsuario() {
        return usuarios;
    }

    // Adiciona um novo usuário
    public boolean adicionarUsuario(Usuario usuario) {
        if (usuario == null || usuarios.contem(usuario)) {
            return false;
        }
        usuarios.adicionar(usuario);
        return true;
    }

    // Busca um usuário por username e senha
    public Usuario buscarUsuario(String username, String password) {
        for (int i = 0; i < usuarios.tamanho(); i++) {
            Usuario usuario = usuarios.pegar(i);
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(Usuario usuario) {
        return buscarUsuario(usuario.getUsername(), usuario.getPassword());
    }
}
