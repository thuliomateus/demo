package biblioteca.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.demo.entidades.EmprestimoLivro;


@Repository
public interface EmprestimoLivroRepositorio extends JpaRepository<EmprestimoLivro, Long> {
    
    
    // Método para contar o número de empréstimos não realizados para um usuário específico
    long countByEntregaRealizadaFalseAndIdUsuario(Long idUsuario);
    // Método para buscar empréstimos de um usuário específico com uma determinada entrega realizada
    boolean existsByUsuarioIdAndLivroId(Long usuario, Long livro);
}
