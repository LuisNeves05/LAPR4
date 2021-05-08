package eapli.base.servico.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ListarServicosController {

    private final ServicoRepositorio repoServico = PersistenceContext.repositories().servicoRepositorio();

    public List<Servico> listarServico(){
        return (List<Servico>) repoServico.findAll();
    }

    /*public List<Servico> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM Servico Where ESTADO = INCOMPLETO");
        return query.getResultList();
    }*/

    private EntityManager criarEntityManager(String persistenceUnit) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory(persistenceUnit);
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
}
