package eapli.base.tarefaManualExecucao.application;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.framework.domain.repositories.IntegrityViolationException;

import java.util.List;

public class AssignarTarefaAlgoritmoController {

    private final TarefaManualExecucaoRepositorio tarefaManualExecucaoRepositorio =  PersistenceContext.repositories().tarefaManualExecucaoRepositorio();


    public List<TarefaManualExecucao> tarefasPorExecutar() {
        return tarefaManualExecucaoRepositorio.tarefasPorExecutar();
    }

    public TarefaManualExecucao assignarTarefaExecutanteAUmColaborador(TarefaManualExecucao tarefa, Colaborador colab) {
        tarefa.retirarEquipa();
        tarefa.defineColaboradorExecutante(colab);

        try {
            return tarefaManualExecucaoRepositorio.save(tarefa);
        } catch (IntegrityViolationException violation) {
            System.out.println("Erro na persistência da tarefa!");
        }
        return null;
    }
}
