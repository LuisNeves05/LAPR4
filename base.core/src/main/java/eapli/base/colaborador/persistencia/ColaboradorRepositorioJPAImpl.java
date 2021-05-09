package eapli.base.colaborador.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;

public class ColaboradorRepositorioJPAImpl extends JpaAutoTxRepository<Colaborador, MecanographicNumber, MecanographicNumber> implements ColaboradorRepositorio {

    public ColaboradorRepositorioJPAImpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    public List<Equipa> equipasColaboradorPorUsername(Username username){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT equipas FROM Colaborador c where SYSTEMUSER_USERNAME = ' "
                + username + "' ");
        return query.getResultList();
    }
}
