package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Classe responsavel por centralizar a lógica de persistẽncia em comum entre
 * grupos de entidades do contrato da interface GeneralEntity. Gerando um
 * sistema crud para qualquer entidade que assina com GeneralEntity
 *
 * @author Matheus Pinheiro
 */
public class DaoGenerics<T extends GeneralEntity> {

    private EntityManager manager = ConnectionFactory.getEntityManager();

    /**
     * Método de busca pelo Id. Como o método é generico pode ser usado para
     * qualquer objeto.
     *
     * @param object objeto a ser passado por parametro
     * @param id endereço unico do objeto
     * @return o objeto
     */
    public T findById(Class<T> object, Long id) {
        return manager.find(object, id);
    }

    public void save(T object) {
        try {
            manager.getTransaction().begin();
            manager.persist(object);

            //manager.merge(object);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    public void remove(Class<T> object, Long id) {
        T generics = findById(object, id);
        try {
            manager.getTransaction().begin();
            manager.remove(generics);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    public List<Aluno> alunoByIdCurso(Long id) {
        Query query = manager.createQuery("Select a FROM Aluno a join a.curso c where c.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Aluno> alunoByIdLivro(Long id) {
        Query query = manager.createQuery("Select a FROM LocacaoLivro lo join  lo.aluno a join lo.livro l where l.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Aluno> AlunoByIdEstado(String sigla) {
        Query query = manager.createQuery("Select a FROM Aluno a join a.cidade c where c.estado = :estado");
        query.setParameter("estado", sigla);
        return query.getResultList();
    }

    public Long contAlunoByCurso(Long id) {
        Query query = manager.createQuery("Select count(a) FROM Aluno a join a.curso c where c.id = :id");
        query.setParameter("id", id);
        return (Long) query.getSingleResult();
    }
    
    public List<Aluno> alunoLivrosAtrasados(){
        Query query = manager.createQuery("Select a FROM LocacaoLivro lo join Aluno a where (curdate()-date(lo.data_locacao) > 15");
        return query.getResultList();
    }
    
    public List<Livro> LivroByAutor(String nome){
        Query query = manager.createQuery("Select l  FROM Autor a join a.listLivros l  where a.nome = :nome");
        query.setParameter("nome",nome);
        return query.getResultList();
    }
    
    public List<Livro> LivroByStatus(Long id){
        Query query = manager.createQuery("Select l FROM LocacaoLivro lo join lo.livro  l join lo.status s where s.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    public List<Livro> LivroByName (String nome){
        Query query = manager.createQuery("Select l FROM Livro l where l.nome like :nome");
        query.setParameter("nome","%"+nome+"%");
        return query.getResultList();
    }
    
    
    public List<Livro> LivrosEmprestado(){
        Query query = manager.createQuery("Select l FROM LocacaoLivro lo join lo.livro l join lo.status s where s.nome = 'Emprestado'");
        return query.getResultList();
    }
}
