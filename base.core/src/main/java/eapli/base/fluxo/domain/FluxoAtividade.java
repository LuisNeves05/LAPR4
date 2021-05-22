package eapli.base.fluxo.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class FluxoAtividade implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    private Long id;


}
