package eapli.base.Utils;

import eapli.base.servico.domain.Servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class QueryMaker {

    /**
     * @return List of Objects to be cast to whatever the programmer wants
     */
    public List<Servico> queryToDB() {
        Query query = criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where estado='INCOMPLETO'", Servico.class);
        return query.getResultList();
    }


    public EntityManager criarEntityManager(String persistenceUnit) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory(persistenceUnit);
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

}
