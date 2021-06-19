package eapli.base.colaborador.persistencia;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;

public class ColaboradorRepositorioJPAImpl extends JpaAutoTxRepository<Colaborador, MecanographicNumber, MecanographicNumber> implements ColaboradorRepositorio {

    public ColaboradorRepositorioJPAImpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }


    public Iterable<Colaborador> colabPorUsername(Username username){
        Query query = super.createQuery("SELECT c FROM Colaborador c where c.systemUser.username = :username",
                Colaborador.class);
        query.setParameter("username", username);
        return query.getResultList();
    }


    public Iterable<Colaborador> colabsDoCatalogo(Equipa eq){
        Query query = super.createQuery("SELECT e.listaColabs FROM Equipa e where e = :equipa",
                Iterable.class);
        query.setParameter("equipa", eq);
        return query.getResultList();
    }
}
