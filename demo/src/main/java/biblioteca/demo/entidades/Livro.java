package biblioteca.demo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "ano_publicacao", nullable = false)
    private Integer anoPublicacao;

    @Column(name = "disponivel")
    private boolean disponivel;

    @OneToOne(mappedBy = "livro")
    private EmprestimoLivro emprestimoLivro;

    public Livro() {
    }

    public Livro(String titulo, Integer anoPublicacao, boolean disponivel) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public EmprestimoLivro getEmprestimoLivro() {
        return emprestimoLivro;
    }

    public void setEmprestimoLivro(EmprestimoLivro emprestimoLivro) {
        this.emprestimoLivro = emprestimoLivro;
    }
}
