package biblioteca.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biblioteca.demo.entidades.Livro;
import biblioteca.demo.servicos.LivroServicos;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroServicos livroServicos;

    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {
        final List<Livro> livros = livroServicos.getAllLivros();
        if (livros.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(livros);
        }
    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro createdLivro = livroServicos.createLivro(livro);
        return new ResponseEntity<>(createdLivro, HttpStatus.CREATED);
    }
    
    // Endpoint para buscar o livro por ID
    @GetMapping("/{buscarId}")
    public ResponseEntity<Optional<Livro>> getLivroById(@PathVariable Long id) {
        Optional<Livro> livro = livroServicos.getLivroById(id);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar um livro por ID
    @DeleteMapping("/{deletarId}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroServicos.deleteLivro(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar um livro
    @PutMapping("/{atualizarLivro}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Livro updatedLivro = livroServicos.updateLivro(id, livro);
        if (updatedLivro != null) {
            return ResponseEntity.ok(updatedLivro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
