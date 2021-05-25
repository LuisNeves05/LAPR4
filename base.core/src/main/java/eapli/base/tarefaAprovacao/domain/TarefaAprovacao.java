package eapli.base.tarefaAprovacao.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TarefaAprovacao implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<Colaborador> colabsAprova;

    public TarefaAprovacao(){
        this.colabsAprova = new HashSet<>();
    }

    public void adicionaColaboradorAprov(Colaborador colabAprov){
        colabsAprova.add(colabAprov);
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