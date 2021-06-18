
package eapli.base.Utils;

import eapli.base.servico.domain.Servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class QueryMaker {


    public List<Servico> queryServicoIncompleto() {
        Query query = criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where estado='INCOMPLETO'", Servico.class);
        return query.getResultList();
    }

    public <E> List<E> queryServicoIncompleto(E outputClass, String queryJPQL) {
        List<E> query = criarEntityManager("eapli.base").createQuery(queryJPQL).getResultList();
        return query;
    }


    public < E > Query updateValueInDB(E outputClass, String queryJPQL){
        Query query = criarEntityManager("eapli.base").createQuery("UPDATE Colaborador SET Colaborador.equipa = 325");
        return query;
    }

    public EntityManager criarEntityManager(String persistenceUnit) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory(persistenceUnit);
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

}
