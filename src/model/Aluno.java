package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno implements GeneralEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_aluno")
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Date data_cadastro;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_cadastro() {
          SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data_cadastro);
    }

    public void setData_cadastro(String data_cadastro) {
          try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.data_cadastro = formato.parse(data_cadastro);
        } catch (ParseException ex) {
            
        }
    }
    

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
