package eapli.base.tarefaManualExecucao.persistance;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TarefaManualExecucaoRepositorio extends DomainRepository<Long, TarefaManualExecucao> {


    List<TarefaManualExecucao> tarefasManuaisExecucaoNA(List<Equipa> equipas);


    List<TarefaManualExecucao> tarefasManuaisExecucaoPendentes(Colaborador colaborador);

    //Iterable<TarefaManualExecucao> tarefasManuaisExecucaoColab(Colaborador colaborador);

    List<TarefaManualExecucao> tarefasManuaisExecEmExecucao(Colaborador colaborador);

    List<TarefaManualExecucao> tarefasPorExecutar();

    List<TarefaManualExecucao> tarefasDeCadaColaborador(Colaborador colaborador);
}