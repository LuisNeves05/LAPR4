package eapli.base.colaborador.persistencia;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;

public interface ColaboradorRepositorio extends DomainRepository<MecanographicNumber, Colaborador> {

    Iterable<Equipa> equipasColaboradorPorUsername(Username username);

    Iterable<Colaborador> colabPorUsername(Username username);

    Iterable<Colaborador> colabsDoCatalogo(Equipa eq);
}
