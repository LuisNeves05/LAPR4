package eapli.base.tarefaManualAprovacao.persistance;

import eapli.base.Application;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefaManualAprovacao.domain.EstadoAprovacao;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import javax.persistence.Query;
import java.util.List;


public class TarefaManualAprovacaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaManualAprovacao, Long, Long>
        implements TarefaManualAprovacaoRepositorio {

    public TarefaManualAprovacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public List<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador) {
        Query query = super.createQuery("SELECT t from TarefaManualAprovacao t where t.estadoAprovacao = :a and :colaborador = colabAprov", TarefaManualAprovacao.class);
        query.setParameter("colaborador", colaborador);
        query.setParameter("a", EstadoAprovacao.POR_APROVAR);
        return query.getResultList();
    }


    @Override
    public List<TarefaManualAprovacao> tarefasAprovacaoDoTicket(Ticket ticket) {
        Query query = super.createQuery("SELECT t from TarefaManualAprovacao t where :ticket = t.ticket", TarefaManualAprovacao.class);
        query.setParameter("ticket", ticket);
        return query.getResultList();
    }
}
