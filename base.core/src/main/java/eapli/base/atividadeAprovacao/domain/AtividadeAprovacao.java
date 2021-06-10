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

    @OneToMany
    private Set<TarefaManualAprovacao> tarefasAprov;

    @OneToMany
    private Set<Formulario> formularios;

    public AtividadeAprovacao(){
        this.tarefasAprov = new HashSet<>();
        this.colabsAprov = new HashSet<>();
        this.formularios = new HashSet<>();
    }

    @Override
    public String toString() {
        return colabsAprov.toString() + "CO" +tarefasAprov + "CON";
    }

    public void adicionaTarefaAprov(TarefaManualAprovacao tarAprov){
        tarefasAprov.add(tarAprov);
    }

    public void adicionaColabAprov(ColaboradoresAprovacao colabAprov){
        colabsAprov.add(colabAprov);
    }

    public void adicionaFormulario(Formulario f){
        if(!this.formularios.contains(f)){
            formularios.add(f);
        }
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

    public Set<TarefaManualAprovacao> tarefasAprovList() {
        return tarefasAprov;
    }
}
