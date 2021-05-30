package eapli.base.tarefaManual.persistance;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManual.domain.TarefaManual;
import eapli.base.tarefaManual.domain.TarefaManualAprovacao;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.framework.domain.repositories.DomainRepository;

public interface TarefaExecucaoRepositorio extends DomainRepository<Long, TarefaManual> {


    Iterable<TarefaManualExecucao> tarefasManuaisExecucaoNA(Equipa equipa);

    Iterable<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador);

    Iterable<TarefaManualExecucao> tarefasManuaisExecucaoPendentes(Colaborador colaborador);
}