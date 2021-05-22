package eapli.base.workflow.domain;

import eapli.base.tarefa.domain.Tarefa;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class AtividadeAprovacao extends FluxoAtividade {

    @Id
    private Long id;

    @OneToMany
    private Set<Tarefa> tarefaSet;
}
