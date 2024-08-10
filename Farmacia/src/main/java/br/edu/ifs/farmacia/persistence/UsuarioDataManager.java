package br.edu.ifs.farmacia.persistence;

import br.edu.ifs.farmacia.model.login.Usuario;
import br.edu.ifs.farmacia.repository.UsuarioRepository;
import br.edu.ifs.farmacia.util.Lista;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Aluno
 */
public class UsuarioDataManager {

    private static final String FILE_NAME = "serialized_objects/usuarios.dat";

    public static void salvarUsuarios(UsuarioRepository usuarioRepository) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFilePath(FILE_NAME)))) {
            oos.writeObject(usuarioRepository);
             System.out.println("Usuários salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void salvarUsuario(Usuario usuario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFilePath(FILE_NAME)))) {
            UsuarioRepository.getInstance().adicionarUsuario(usuario);
            oos.writeObject(UsuarioRepository.getInstance());
             System.out.println("Usuários salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarUsuarios(UsuarioRepository usuarioRepository) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFilePath(FILE_NAME)))) {
            UsuarioRepository loadedRepository = (UsuarioRepository) ois.readObject();
            Lista<Usuario> usuarios = loadedRepository.pegarTodosUsuario();
            for (int i = 0; i < usuarios.tamanho(); i++) {
                usuarioRepository.adicionarUsuario(usuarios.pegar(i));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(String fileName) {
        // Acessa o arquivo a partir do classpath
        return new File("src/main/resources/" + fileName).getAbsolutePath();
    }
}

