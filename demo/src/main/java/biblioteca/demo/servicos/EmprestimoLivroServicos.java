package biblioteca.demo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import biblioteca.demo.entidades.EmprestimoLivro;
import biblioteca.demo.repositorio.EmprestimoLivroRepositorio;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoLivroServicos {

    @Autowired
    private EmprestimoLivroRepositorio emprestimoLivroRepositorio;

    public List<EmprestimoLivro> getAllEmprestimos() {
        return emprestimoLivroRepositorio.findAll();
    }

    public EmprestimoLivro createEmprestimo(EmprestimoLivro emprestimoLivro) {
        // Validar se o ID do empréstimo está nulo
    
        
        // Adicionar outras validações aqui, se necessário
        
        return emprestimoLivroRepositorio.save(emprestimoLivro);
    }

    // Método para entregar livro
    public void entregarLivro(Long emprestimoId) {
        EmprestimoLivro emprestimoLivro = (EmprestimoLivro) emprestimoLivroRepositorio.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        emprestimoLivro.setEntregaRealizada(true);
        emprestimoLivroRepositorio.save(emprestimoLivro);
    }

    // Método para buscar por id
    public Optional<EmprestimoLivro> getEmprestimoById(Long emprestimoId) {
        return Optional.empty();
    }


}
