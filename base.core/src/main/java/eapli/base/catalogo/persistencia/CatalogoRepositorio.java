package eapli.base.catalogo.persistencia;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.domain.repositories.DomainRepository;

public interface CatalogoRepositorio extends DomainRepository<Long, Catalogo> {

    //TODO funções mais especificas

}
