package biblioteca.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import biblioteca.demo.entidades.Livro;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {
    public List<Livro> findByTitulo(String titulo);
}
