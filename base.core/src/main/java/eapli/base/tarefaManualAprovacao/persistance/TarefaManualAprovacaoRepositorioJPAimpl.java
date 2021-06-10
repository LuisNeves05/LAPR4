package eapli.base.tarefaManualAprovacao.persistance;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefaManualAprovacao.domain.EstadoAprovacao;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;


public class TarefaManualAprovacaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaManualAprovacao, Long, Long>
        implements TarefaManualAprovacaoRepositorio {

    public TarefaManualAprovacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador) {
        QueryMaker qm = new QueryMaker();
        final Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from TarefaManualAprovacao t where t.estadoAprovacao = :a and :colaborador MEMBER of colabsAprova", TarefaManualAprovacao.class);
        query.setParameter("colaborador", colaborador);
        query.setParameter("a", EstadoAprovacao.POR_APROVAR);
        return query.getResultList();
    }
}