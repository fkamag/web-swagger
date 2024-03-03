package dio.myfirstwebapi.repository;

import dio.myfirstwebapi.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {
  private List<Usuario> usuarios = new ArrayList<>();
  public void save(Usuario usuario) {
    System.out.println("SAVE - Recebendo o usuário na camada repository");
    usuarios.add(usuario);
  }

  public void deleteById(Integer id) {
    System.out.print("DELETE/id - Recebendo o id: ");
    Usuario usuario = this.findById(id);
    System.out.println(usuario);

    usuarios.remove(usuario);
  }

  public List<Usuario> findAll() {
    System.out.println("LIST - Listando os usuários do sistema");

    return usuarios;
  }

  public Usuario findById(Integer id) {
    for (Usuario usuario : usuarios) {
      if (Objects.equals(usuario.getId(), id)) {
        return usuario;
      }
    }
    return null;
  }

  public Usuario findByUsername(String usermame) {
    System.out.printf("FIND/username - Recebendo o username %s", usermame);
    for (Usuario usuario : usuarios) {
      if (Objects.equals(usuario.getLogin(), usermame)) {
        return usuario;
      }
    }
    return null;
  }

  public Usuario updateUsuario(Usuario usuarioAlterado) {
    Usuario usuario = this.findById(usuarioAlterado.getId());
    if (usuario == null) {
      return null;
    }
    usuario.setLogin(usuarioAlterado.getLogin());
    usuario.setPassword(usuarioAlterado.getPassword());
    return usuario;
  }

}
