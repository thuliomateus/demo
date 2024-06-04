package biblioteca.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import biblioteca.demo.entidades.Usuario;
import biblioteca.demo.servicos.UsuarioServicos;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServicos usuarioService;

    // Endpoint para listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllLivros() {
        final List<Usuario> livros = UsuarioServicos.getAllUsuarios();
        if (livros.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(livros);
        }
    }

    // Endpoint para cadastro de usuário
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        // Validação de campos obrigatórios pode ser adicionada no serviço
        Usuario usuarioSalvo = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    // Endpoint para buscar usuário por ID
    @GetMapping("/{buscarId}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para buscar usuário por email
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Usuario>> buscarUsuarioPorEmail(@PathVariable("email") String email) {
        List<Usuario> usuarios = usuarioService.buscarUsuarioPorEmail(email);
        if (!usuarios.isEmpty()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
}
