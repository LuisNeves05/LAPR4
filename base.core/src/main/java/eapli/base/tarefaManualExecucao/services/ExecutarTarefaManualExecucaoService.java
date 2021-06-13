package eapli.base.tarefaManualExecucao.services;


import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;

public class ExecutarTarefaManualExecucaoService {

    public void comecarTarefaManualExec(TarefaManualExecucao tarefa) {
        // todo fazer execucacao da tarefa manual
        tarefa.definirMomentoRealizacao();
    }

}

