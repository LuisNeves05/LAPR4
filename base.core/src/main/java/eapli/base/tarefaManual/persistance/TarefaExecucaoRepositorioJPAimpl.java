package eapli.base.tarefaManual.persistance;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManual.domain.TarefaManual;
import eapli.base.tarefaManual.domain.TarefaManualAprovacao;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.base.tarefaManual.domain.estado.EstadoAprovacao;
import eapli.base.tarefaManual.domain.estado.EstadoRealizacao;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;


public class TarefaExecucaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaManual, Long, Long>
        implements TarefaExecucaoRepositorio {

    public TarefaExecucaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public List<TarefaManualExecucao> tarefasManuaisExecucaoNA(List<Equipa> equipas) {

        QueryMaker qm = new QueryMaker();
        final Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from TarefaManualExecucao t where t.equipasExecuta.size != 0 and :equipa MEMBER of t.equipasExecuta", TarefaManualExecucao.class);
        query.setParameter("equipa", equipas);
        return query.getResultList();

    }

    @Override
    public Iterable<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador) {
        QueryMaker qm = new QueryMaker();
        final Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from TarefaManualAprovacao t where t.estadoAprovacao = :a and :colaborador MEMBER of colabsAprova", TarefaManualAprovacao.class);
        query.setParameter("colaborador", colaborador);
        query.setParameter("a", EstadoAprovacao.POR_APROVAR);
        return query.getResultList();
    }

    @Override
    public Iterable<TarefaManualExecucao> tarefasManuaisExecucaoPendentes(Colaborador colaborador) {
        QueryMaker qm = new QueryMaker();
        final Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from TarefaManualExecucao t where t.estadoRealizacao = :a and :colaborador = t.colabExecuta", TarefaManualExecucao.class);
        query.setParameter("colaborador", colaborador);
        query.setParameter("a", EstadoRealizacao.POR_EXECUTAR);
        return query.getResultList();
    }

    /*
    @Override
    public Iterable<TarefaManualExecucao> tarefasManuaisExecucaoColab(Colaborador colab) {
        QueryMaker qm = new QueryMaker();
        final Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from TarefaManualExecucao t where t.colabExecuta = :colab", TarefaManualExecucao.class);
        query.setParameter("colab", colab);
        return query.getResultList();
    }

     */
}
