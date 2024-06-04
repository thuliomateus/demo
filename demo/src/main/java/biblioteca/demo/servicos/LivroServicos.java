package biblioteca.demo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.demo.entidades.Livro;
import biblioteca.demo.repositorio.LivroRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServicos {

    @Autowired
    private LivroRepositorio livroRepository;

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    // Método para buscar por id
    public Optional<Livro> getLivroById(Long Servicos) {
        return livroRepository.findById(Servicos);
    }

    // Método para deletar um livro por id
    public void deleteLivro(Long Sevicos) {
        livroRepository.deleteById(Sevicos);
    }

    // Método para atualizar um livro existente
    public Livro updateLivro(Long id, Livro livroDetails) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setTitulo(livroDetails.getTitulo());
        livro.setAnoPublicacao(livroDetails.getAnoPublicacao());

        return livroRepository.save(livro);
    }
}
