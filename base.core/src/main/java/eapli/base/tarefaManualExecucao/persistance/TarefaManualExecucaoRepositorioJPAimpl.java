package eapli.base.tarefaManualExecucao.persistance;

import eapli.base.Application;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManualExecucao.domain.EstadoRealizacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;


public class TarefaManualExecucaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaManualExecucao, Long, Long>
        implements TarefaManualExecucaoRepositorio {

    public TarefaManualExecucaoRepositorioJPAimpl(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public TarefaManualExecucaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public List<TarefaManualExecucao> tarefasManuaisExecucaoNA(List<Equipa> equipas) {
        Query query = super.createQuery("SELECT t from TarefaManualExecucao t where t.equipasExecuta.size != 0 and :equipa MEMBER of t.equipasExecuta", TarefaManualExecucao.class);
        query.setParameter("equipa", equipas);
        return query.getResultList();
    }


    @Override
    public List<TarefaManualExecucao> tarefasManuaisExecucaoPendentes(Colaborador colaborador) {
        Query query = super.createQuery("SELECT t from TarefaManualExecucao t where t.estadoRealizacao = :a and :colaborador = t.colabExecuta", TarefaManualExecucao.class);
        query.setParameter("colaborador", colaborador);
        query.setParameter("a", EstadoRealizacao.POR_EXECUTAR);
        return query.getResultList();
    }


    @Override
    public List<TarefaManualExecucao> tarefasManuaisExecEmExecucao(Colaborador colaborador) {
        Query query = super.createQuery("SELECT t from TarefaManualExecucao t where t.estadoRealizacao = :a and :colaborador = t.colabExecuta", TarefaManualExecucao.class);
        query.setParameter("colaborador", colaborador);
        query.setParameter("a", EstadoRealizacao.EM_EXECUCAO);
        return query.getResultList();
    }

    @Override
    public List<TarefaManualExecucao> tarefasPorExecutar() {
        Query query = super.createQuery("select t from TarefaManualExecucao t where t.estadoRealizacao = :estado and t.colabExecuta = null" ,TarefaManualExecucao.class);
        query.setParameter("estado", EstadoRealizacao.POR_EXECUTAR);
        return query.getResultList();
    }

    @Override
    public List<TarefaManualExecucao> tarefasDeCadaColaborador(Colaborador colaborador) {
        Query query = super.createQuery("select t from TarefaManualExecucao t where t.estadoRealizacao = :estado and t.colabExecuta = :colab" ,TarefaManualExecucao.class);
        query.setParameter("estado", EstadoRealizacao.POR_EXECUTAR);
        query.setParameter("colab", colaborador);
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
