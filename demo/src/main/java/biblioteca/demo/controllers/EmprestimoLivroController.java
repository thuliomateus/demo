package biblioteca.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import biblioteca.demo.entidades.EmprestimoLivro;
import biblioteca.demo.servicos.EmprestimoLivroServicos;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoLivroController {

    @Autowired
    private EmprestimoLivroServicos emprestimoLivroServicos;

    @GetMapping
    public ResponseEntity<List<EmprestimoLivro>> getAllEmprestimos() {
        List<EmprestimoLivro> emprestimos = emprestimoLivroServicos.getAllEmprestimos();
        if (emprestimos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(emprestimos);
        }
    }

    @PostMapping
    public ResponseEntity<EmprestimoLivro> createEmprestimo(@RequestBody EmprestimoLivro emprestimoLivro) {
        EmprestimoLivro createdEmprestimo = emprestimoLivroServicos.createEmprestimo(emprestimoLivro);
        return new ResponseEntity<>(createdEmprestimo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/entregar")
    public ResponseEntity<Void> entregarLivro(@PathVariable Long id) {
        emprestimoLivroServicos.entregarLivro(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoLivro> getEmprestimoById(@PathVariable Long id) {
        return emprestimoLivroServicos.getEmprestimoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
