package eapli.base.tarefaManual.application;

import eapli.base.Utils.HelpMethods;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.persistencia.ColaboradorRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.base.tarefaManual.persistance.TarefaExecucaoRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueriesTarefaController {

    private final TarefaExecucaoRepositorio repoTarefasExec = PersistenceContext.repositories().tarefaExecucaoRepositorio();
    private final ColaboradorRepositorio colaboradorRepositorio = PersistenceContext.repositories().colaboradorRepositorio();

    public String tarefasManuaisAprovDTO(Colaborador colaborador) {
        Iterable<TarefaManualExecucao> tarefasList = repoTarefasExec.tarefasManuaisExecucaoPendentes(colaborador);
        List<String> tarefas = new ArrayList<>();

        for (TarefaManualExecucao tarefaM : tarefasList) {
            tarefas.add(tarefaM.toDTO().toString());
        }

        return HelpMethods.arrayToString(tarefas);
    }

    public Colaborador colabPorID(String id) {
        MecanographicNumber numeroMecanografico = new MecanographicNumber(id);

        Optional<Colaborador> t = colaboradorRepositorio.ofIdentity(numeroMecanografico);
        return t.orElse(null);
    }

}
