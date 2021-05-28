package eapli.base.atividadeAprovacao.domain;

import eapli.base.tarefa.domain.TarefaManualAprovacao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AtividadeAprovacao implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COLABS_APROVACAO")
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<ColaboradoresAprovacao> colabsAprov;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<TarefaManualAprovacao> tarefasAprov;

    public AtividadeAprovacao(){
        this.tarefasAprov = new HashSet<>();
        this.colabsAprov = new HashSet<>();
    }

    public void adicionaTarefaAprov(TarefaManualAprovacao tarAprov){
        tarefasAprov.add(tarAprov);
    }

    public void adicionaColabAprov(ColaboradoresAprovacao colabAprov){
        colabsAprov.add(colabAprov);
    }

    public Set<ColaboradoresAprovacao> colabsDeAprovacao(){
        return this.colabsAprov;
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
