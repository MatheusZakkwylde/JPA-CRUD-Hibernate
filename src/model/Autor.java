
package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Autor implements GeneralEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_autor")
    private Long id;
    private String nome;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Livro> listLivros;
    
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

    public List<Livro> getListLivro() {
        return listLivros;
    }

    public void setListLivro(List<Livro> listLivro) {
        this.listLivros = listLivro;
    }
}
