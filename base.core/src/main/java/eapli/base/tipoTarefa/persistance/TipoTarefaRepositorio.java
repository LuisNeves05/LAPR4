package eapli.base.tipoTarefa.persistance;

import eapli.base.servico.domain.Servico;
import eapli.base.ticket.domain.Ticket;
import eapli.base.tipoTarefa.domain.TipoTarefa;
import eapli.framework.domain.repositories.DomainRepository;

public interface TipoTarefaRepositorio extends DomainRepository<Long, TipoTarefa> {

    Iterable<TipoTarefa> tipoTarefaPeloServico(final Servico s);

}