package eapli.base.servico.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.catalogo.domain.Catalogo;
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
    public List<Servico> servicoPorIdentificador(final String ident, final Catalogo catalogo){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where servicoIdent = ' " + ident + "' AND catalogo = " +
                "' " + catalogo + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorTitulo(final String titulo, final Catalogo catalogo) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where titulo = ' " + titulo + "' AND catalogo = " +
                "' " + catalogo + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorDescBreve(final String descBreve, final Catalogo catalogo) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where descBreve = ' " + descBreve + "' AND catalogo = " +
                "' " + catalogo + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> servicoPorKeyword(final String keyword, final Catalogo catalogo) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where keywords = ' " + keyword + "' AND catalogo = " +
                "' " + catalogo + "' ", Servico.class);
        return query.getResultList();
    }

    @Override
    public List<Servico> findByEstado(final String estado) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT s FROM Servico s where estado = ' " + estado + "' ", Servico.class);
        return query.getResultList();
    }
}
