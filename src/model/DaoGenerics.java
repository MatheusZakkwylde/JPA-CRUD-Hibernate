package model;

import javax.persistence.EntityManager;

/**
 * Classe responsavel por centralizar a lógica de persistẽncia em comum entre
 * grupos de entidades do contrato da interface GeneralEntity. Gerando um
 * sistema crud para qualquer entidade que assina com GeneralEntity
 *
 * @author Matheus Pinheiro
 */
public class DaoGenerics<T extends GeneralEntity> {

    private  EntityManager manager = ConnectionFactory.getEntityManager();

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

    public void saveOrUpdate(T object) {
        try {
            manager.getTransaction().begin();
            if (object.getId() == null) {
                manager.persist(object);
            } else {
                manager.merge(object);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }
    
    
    public void remove(Class<T> object,Long id){
        T generics = findById(object,id);
        try{
            manager.getTransaction().begin();
            manager.remove(generics);
            manager.getTransaction().commit();
        }catch(Exception e){
            manager.getTransaction().rollback();
        }
    }
}
