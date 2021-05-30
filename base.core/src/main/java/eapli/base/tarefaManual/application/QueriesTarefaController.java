package eapli.base.tarefaManual.application;

import eapli.base.Utils.HelpMethods;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.base.tarefaManual.persistance.TarefaExecucaoRepositorio;

import java.util.ArrayList;
import java.util.List;

public class QueriesTarefaController {

    private final TarefaExecucaoRepositorio repoTarefasExec = PersistenceContext.repositories().tarefaExecucaoRepositorio();

    public String tarefasManuaisAprovDTO(Colaborador colaborador){
        Iterable<TarefaManualExecucao> tarefasList= repoTarefasExec.tarefasManuaisExecucaoPendentes(colaborador);
        List<String> tarefas = new ArrayList<>();

        for(TarefaManualExecucao tarefaM : tarefasList){
            tarefas.add(tarefaM.toDTO().toString());
        }

        return HelpMethods.arrayToString(tarefas);
    }

}
