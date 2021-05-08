package eapli.base.servico.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.*;

import java.util.HashMap;
import java.util.Map;


public class ServicoRepositorioJPAimpl extends JpaAutoTxRepository<Servico, Long, ServicoIdentificador>
        implements ServicoRepositorio {

    public ServicoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public List<Servico> servicoPorIdentificador(final String ident){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where servicoIdent = ' " + ident + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorTitulo(final String titulo) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where titulo = ' " + titulo + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorDescBreve(final String descBreve) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where descBreve = ' " + descBreve + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorKeyword(final String keyword) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where keywords = ' " + keyword + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> findByEstado(final String estado) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where estado = ' " + estado + "' ", Servico.class);
        return query.getResultList();
    }
}
