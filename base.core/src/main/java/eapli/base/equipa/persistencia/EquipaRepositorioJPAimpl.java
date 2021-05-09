package eapli.base.equipa.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.equipa.domain.CodigoEquipa;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EquipaRepositorioJPAimpl extends JpaAutoTxRepository<Equipa, CodigoEquipa, Equipa>
        implements EquipaRepositorio{

    public EquipaRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Equipa findByKeyword(String keyword) {
        return null;
    }

    public List<Equipa> listarAcronimosEquipa(String acrText){
        /*
        EntityManager manager = new JpaRepository();

        Query equipas = manager.createQuery("select e from equipa e");
        List<Equipa> results = (List<Equipa>) equipas;

        System.out.println(results);
        return null;*/
        return null;
    }

    public List<Catalogo> catalogosPorEquipa(Equipa equipa){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT c FROM Catalogo c where equipas = ' " + equipa + "' ", Servico.class);
        return query.getResultList();
    }

    public List<Catalogo> catalogosPorEquipaPorTitulo(final Equipa equipa, final String titulo){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT c FROM Catalogo c where equipas = ' " + equipa + "' " +
                "AND titulo = ' " + titulo + "' ");
        return query.getResultList();
    }

    public List<Catalogo> catalogosPorEquipaPorDescBreve(final Equipa equipa, final String descBreve){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT c FROM Catalogo c where equipas = ' " + equipa + "' " +
                "AND descBreve = ' " + descBreve + "' ");
        return query.getResultList();
    }

}
