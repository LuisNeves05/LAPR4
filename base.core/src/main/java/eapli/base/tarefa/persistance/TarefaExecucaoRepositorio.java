package eapli.base.tarefa.persistance;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefa.domain.TarefaManual;
import eapli.base.tarefa.domain.TarefaManualAprovacao;
import eapli.base.tarefa.domain.TarefaManualExecucao;
import eapli.framework.domain.repositories.DomainRepository;

public interface TarefaExecucaoRepositorio extends DomainRepository<Long, TarefaManual> {


    Iterable<TarefaManualExecucao> tarefasManuaisExecucaoNA(Equipa equipa);

    Iterable<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador);


}