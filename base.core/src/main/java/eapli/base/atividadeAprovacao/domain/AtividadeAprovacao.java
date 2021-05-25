package eapli.base.atividadeAprovacao.domain;

import eapli.base.tarefaAprovacao.domain.TarefaAprovacao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AtividadeAprovacao implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<TarefaAprovacao> tarefasAprov;

    public AtividadeAprovacao(){
        tarefasAprov = new HashSet<>();
    }

    public void adicionaTarefaAprov(TarefaAprovacao tarAprov){
        tarefasAprov.add(tarAprov);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }
}
