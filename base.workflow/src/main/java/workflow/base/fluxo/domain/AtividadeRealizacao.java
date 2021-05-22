package workflow.base.fluxo.domain;

import eapli.base.tarefa.domain.Tarefa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
public class AtividadeRealizacao {

    @Id
    private Long id;


    private Set<Tarefa> tarefas;
}
