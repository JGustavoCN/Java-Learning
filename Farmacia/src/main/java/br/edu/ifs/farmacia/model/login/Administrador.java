package br.edu.ifs.farmacia.model.login;

import java.io.Serializable;

/**
 *
 * @author Aluno
 */
public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    public Administrador(String username, String password) {
        super(username, password);
    }
    
    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMINISTRADOR;
    }
    
}
