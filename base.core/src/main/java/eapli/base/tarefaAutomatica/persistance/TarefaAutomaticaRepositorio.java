package eapli.base.tarefaAutomatica.persistance;

import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Set;

public interface TarefaAutomaticaRepositorio extends DomainRepository<Long, TarefaAutomatica> {

    List<TarefaAutomatica> tarefasAutomaticasPendentes();



}