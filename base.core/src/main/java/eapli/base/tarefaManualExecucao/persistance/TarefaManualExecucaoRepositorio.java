package eapli.base.tarefaManualExecucao.persistance;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.domain.repositories.DomainRepository;

public interface TarefaManualExecucaoRepositorio extends DomainRepository<Long, TarefaManualExecucao> {


    Iterable<TarefaManualExecucao> tarefasManuaisExecucaoNA(Equipa equipa);

    Iterable<TarefaManualExecucao> tarefasManuaisExecucaoPendentes(Colaborador colaborador);

    //Iterable<TarefaManualExecucao> tarefasManuaisExecucaoColab(Colaborador colaborador);
}