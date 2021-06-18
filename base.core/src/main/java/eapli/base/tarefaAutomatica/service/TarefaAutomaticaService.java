package eapli.base.tarefaAutomatica.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class TarefaAutomaticaService {

    private final TarefaAutomaticaRepositorio tarefaRepo =  PersistenceContext.repositories().tarefaAutomaticaRepositorio();


    public List<TarefaAutomatica> buscarTarefasAutomaticas(String par){

        List<TarefaAutomatica> tarefasAut = tarefaRepo.tarefasAutomaticasPendentes();
        List<TarefaAutomatica> returnTarefasForP = new ArrayList<>();

        for(TarefaAutomatica elems : tarefasAut){
            long id = elems.identity();

            if(par.contains("P") && ((id % 2) == 0)){
                returnTarefasForP.add(elems);
            }

            if(par.contains("I") && ((id % 2) == 1)){
                returnTarefasForP.add(elems);
            }
        }

        return returnTarefasForP;

    }
}
