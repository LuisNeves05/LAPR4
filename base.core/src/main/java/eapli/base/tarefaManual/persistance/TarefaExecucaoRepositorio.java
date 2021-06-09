package eapli.base.tarefaManual.persistance;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManual.domain.TarefaManual;
import eapli.base.tarefaManual.domain.TarefaManualAprovacao;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TarefaExecucaoRepositorio extends DomainRepository<Long, TarefaManual> {


    List<TarefaManualExecucao> tarefasManuaisExecucaoNA(List<Equipa> equipas);


    List<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador);

    Iterable<TarefaManualExecucao> tarefasManuaisExecucaoPendentes(Colaborador colaborador);

    //Iterable<TarefaManualExecucao> tarefasManuaisExecucaoColab(Colaborador colaborador);

     List<TarefaManualExecucao> tarefasManuaisExecEmExecucao(Colaborador colaborador);
}