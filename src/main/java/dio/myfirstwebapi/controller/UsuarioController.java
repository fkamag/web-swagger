package dio.myfirstwebapi.controller;

import dio.myfirstwebapi.model.Usuario;
import dio.myfirstwebapi.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsuarioController {
  @Autowired
  private UsuarioRepository repository;

  @GetMapping()
  public List<Usuario> getUsers() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Usuario findById(@PathVariable Integer id) {
    return repository.findById(id);
  }

  @GetMapping("/login/{username}")
  public Usuario getOne(@PathVariable("username") String username) {
    return repository.findByUsername(username);
  }

  @PutMapping()
  public Usuario updateUsuario(@RequestBody Usuario usuario) {
    return repository.updateUsuario(usuario);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Integer id) {
    repository.deleteById(id);
  }

  @PostMapping()
  public void postUser(@RequestBody Usuario usuario) {
    repository.save(usuario);
  }

}
