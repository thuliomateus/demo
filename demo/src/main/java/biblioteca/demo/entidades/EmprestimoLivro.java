package biblioteca.demo.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimo_livro")
public class EmprestimoLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_de_entrega", nullable = false)
    private LocalDate dataDeEntrega;

    @Column(name = "entrega_realizada")
    private boolean entregaRealizada;

    @OneToOne
    @JoinColumn(name = "livro_id", nullable = false, referencedColumnName = "id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    public EmprestimoLivro() {
    }

    public EmprestimoLivro(LocalDate dataDeEntrega, boolean entregaRealizada, Livro livro, Usuario usuario) {
        if (dataDeEntrega.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de entrega não pode ser menor que a data atual.");
        }
        this.dataDeEntrega = dataDeEntrega;
        this.entregaRealizada = entregaRealizada;
        this.livro = livro;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(LocalDate dataDeEntrega) {
        if (dataDeEntrega.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data de entrega não pode ser menor que a data atual.");
        }
        this.dataDeEntrega = dataDeEntrega;
    }

    public boolean isEntregaRealizada() {
        return entregaRealizada;
    }

    public void setEntregaRealizada(boolean entregaRealizada) {
        this.entregaRealizada = entregaRealizada;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
