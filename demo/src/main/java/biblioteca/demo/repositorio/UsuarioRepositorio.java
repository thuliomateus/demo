package biblioteca.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import biblioteca.demo.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    public List<Usuario> findByEmail(String email);
}
