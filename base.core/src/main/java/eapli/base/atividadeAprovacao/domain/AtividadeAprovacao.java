package eapli.base.atividadeAprovacao.domain;

import eapli.base.formulario.domain.Formulario;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
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

    @OneToOne
    private Formulario formulario;

    public AtividadeAprovacao(){
        this.colabsAprov = new HashSet<>();
    }

    @Override
    public String toString() {
        return colabsAprov.toString();
    }

    public void adicionaColabAprov(ColaboradoresAprovacao colabAprov){
        colabsAprov.add(colabAprov);
    }

    public void adicionaFormulario(Formulario f){
        this.formulario = f;
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

    public Formulario formularioAprovacao() {
        return formulario;
    }
}
