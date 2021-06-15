package eapli.base.catalogo.persistencia;

import eapli.base.Application;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.DescricaoBreve;
import eapli.base.servico.domain.Titulo;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;

public class CatalogoRepositorioJPAimpl extends JpaAutoTxRepository<Catalogo, Long, Long>
        implements CatalogoRepositorio {

    public CatalogoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    public Iterable<Catalogo> catalogosPorEquipa(final Equipa equipa){
        Query query = super.createQuery("SELECT c FROM Catalogo c where :equipa member of c.equipas", Catalogo.class);
        query.setParameter("equipa", equipa);
        return query.getResultList();
    }

    public Iterable<Catalogo> catalogosPorEquipaPorTitulo(final Equipa equipa, final String titulo){
        Query query = super.createQuery("SELECT c from Catalogo c where c.titulo = :titulo and :equipa MEMBER of c.equipas", Catalogo.class);
        query.setParameter("equipa", equipa);
        query.setParameter("titulo", new Titulo(titulo));
        return query.getResultList();
    }

    public Iterable<Catalogo> catalogosPorEquipaPorDescBreve(final Equipa equipa, final String descBreve){
        Query query = super.createQuery("SELECT c from Catalogo c where c.descBreve = :descBreve and :equipa MEMBER of c.equipas", Catalogo.class);
        query.setParameter("equipa", equipa);
        query.setParameter("descBreve", new DescricaoBreve(descBreve));
        return query.getResultList();
    }

    @Override
    public Iterable<Catalogo> catalogosSemNivelCriticidade() {
        Query query = super.createQuery("SELECT c from Catalogo c where c.nivelCriticidade = null ", Catalogo.class);
        return query.getResultList();
    }

}
