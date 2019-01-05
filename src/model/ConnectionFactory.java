
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static final EntityManagerFactory manager = Persistence.createEntityManagerFactory("connect-database");
    
    public static EntityManager getEntityManager (){
        return manager.createEntityManager();
    }
}
