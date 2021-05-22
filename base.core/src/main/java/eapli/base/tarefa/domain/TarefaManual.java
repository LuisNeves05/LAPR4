package eapli.base.tarefa.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class TarefaManual extends TarefaExecucao implements AggregateRoot<TarefaManual>, Comparable<TarefaManual> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colabExecuta;

    @OneToOne
    private TipoTarefa tipoTarefa;

    @OneToOne
    private Ticket ticket;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public TarefaManual identity() {
        return null;
    }
}