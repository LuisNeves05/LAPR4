package eapli.base.catalogo.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CatalogoRepositorioJPAimpl extends JpaAutoTxRepository<Catalogo, Long, Long>
        implements CatalogoRepositorio {

    public CatalogoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public List<Catalogo> catalogoPorTitulo(final String titulo) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT c FROM Catalogo c where titulo = ' " + titulo + "' ", Catalogo.class);
        return query.getResultList();
    }

    @Override
    public List<Catalogo> catalogoPorDescBreve(final String descBreve) {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT c FROM Catalogo c where descBreve = ' " + descBreve + "' ", Catalogo.class);
        return query.getResultList();
    }
}
