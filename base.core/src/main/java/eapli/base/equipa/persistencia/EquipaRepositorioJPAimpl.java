package eapli.base.equipa.persistencia;

import eapli.base.Application;
import eapli.base.equipa.domain.CodigoEquipa;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
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

}
