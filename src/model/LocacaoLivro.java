
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LocacaoLivro implements GeneralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_locacao")
    private Long id;
    private Date data_locacao;
    private Date data_entrega;
    
    @ManyToOne
    @JoinColumn(name="id_aluno")
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name="id_status")
    private StatusLocacao status;
    @ManyToOne
    @JoinColumn(name="id_livro")
    private Livro livro;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_locacao() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data_locacao);
    }

    public void setData_locacao(String data_locacao) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.data_locacao = formato.parse(data_locacao);
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getData_entrega() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data_entrega);
    }

    public void setData_entrega(String data_entrega) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.data_entrega = formato.parse(data_entrega);
        } catch (ParseException ex) {
            Logger.getLogger(LocacaoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public StatusLocacao getStatus() {
        return status;
    }

    public void setStatus(StatusLocacao status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
