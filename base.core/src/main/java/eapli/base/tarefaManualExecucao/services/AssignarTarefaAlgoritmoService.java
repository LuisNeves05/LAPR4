package eapli.base.tarefaManualExecucao.services;


import eapli.base.Utils.SortValues;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.application.AssignarTarefaAlgoritmoController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;

import java.util.*;

import static eapli.base.Utils.HelpMethods.readFromProperties;


public class AssignarTarefaAlgoritmoService {


    public AssignarTarefaAlgoritmoService() {
    }

    public boolean selecionarColabComMenosTarefas() {
        final AssignarTarefaAlgoritmoController controllerAlg = new AssignarTarefaAlgoritmoController();
        final List<TarefaManualExecucao> listaTarefasManualExecucao = controllerAlg.tarefasPorExecutar();
        final TarefaManualExecucaoRepositorio repoTarefa = PersistenceContext.repositories().tarefaManualExecucaoRepositorio();

        Map<Colaborador, Integer> algoData = new HashMap<>();
        Set<Colaborador> setL = new LinkedHashSet<>();

        //System.out.println("LISTA :" + listaTarefasManualExecucao);

        if (!listaTarefasManualExecucao.isEmpty()) {
            TarefaManualExecucao tarefaManualExecucao = listaTarefasManualExecucao.get(0);
            Set<Equipa> equipasQueExecutam = tarefaManualExecucao.equipasQueExecutam();



            /**
             * Buscar as equipas de um determinado Servico
             */
            for (Equipa elems : equipasQueExecutam) {
                setL.addAll(elems.listaDeColaboradores());
            }

            /**
             * Extrapolar todos os colabs nao repetidos de uma equipa
             */
            for (Colaborador elems : setL) {
                List<TarefaManualExecucao> tarefasList = repoTarefa.tarefasDeCadaColaborador(elems);
                int perMax = 0;

                for (TarefaManualExecucao tar : tarefasList) {
                    perMax += tar.procurarTicket().periodoMaxRes();
                }

                algoData.put(elems, perMax);
            }


            Map<Colaborador, Integer> sortedAlgoData = SortValues.sortByMaxPeriodTime(algoData);
            Colaborador choosenColab = (Colaborador) SortValues.colaboradorComMenosTarefasTempo(sortedAlgoData);

            /*
            System.out.println("DEBUG : " + equipasQueExecutam);
            System.out.println("DEBUG : " + algoData);
            System.out.println("DEBUG : " + sortedAlgoData);
            System.out.println("DEBUG : " + choosenColab);

             */


            /**
             * Assignacao automaticamente a tarefa
             */

            controllerAlg.assignarTarefaExecutanteAUmColaborador(tarefaManualExecucao, choosenColab);

            if (controllerAlg.assignarTarefaExecutanteAUmColaborador(tarefaManualExecucao, choosenColab) != null) {
                System.out.println("Tarefa com sucesso e atribuida ao " + choosenColab.nomeToString());
                return true;
            }
        }

        return false;
    }

    public boolean selecionarFCFS() {
        return false;
    }

    public boolean assignarTarefasAoColabAutomaticamente() {
        String parameter = readFromProperties("algoritmoP");

        if (parameter.contains("fcfs")) {
            return selecionarFCFS();
        }

        if (parameter.contains("time")) {
            return selecionarColabComMenosTarefas();
        }

        return false;
    }
}
