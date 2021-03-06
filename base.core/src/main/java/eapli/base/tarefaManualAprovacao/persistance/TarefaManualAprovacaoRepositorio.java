package eapli.base.tarefaManualAprovacao.persistance;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.List;

public interface TarefaManualAprovacaoRepositorio extends DomainRepository<Long, TarefaManualAprovacao> {

    List<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador);

    List<TarefaManualAprovacao> tarefasAprovacaoDoTicket(Ticket ticket);
}