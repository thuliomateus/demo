package biblioteca.demo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import biblioteca.demo.entidades.Usuario;
import biblioteca.demo.repositorio.UsuarioRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicos {

    @Autowired
    private static UsuarioRepositorio usuarioRepository;

    // Método para buscar todos os usuários
    public static List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método para criar um novo usuário
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método para buscar usuário por id
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método para deletar usuário por id
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para atualizar um usuário existente
    public Usuario updateUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(existingUsuario -> {
                    existingUsuario.setNome(usuario.getNome());
                    existingUsuario.setCpf(usuario.getCpf());
                    return usuarioRepository.save(existingUsuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public List<Usuario> buscarUsuarioPorEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUsuarioPorEmail'");
    }
    
}
