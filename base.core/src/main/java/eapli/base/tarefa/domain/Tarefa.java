package eapli.base.tarefa.domain;


import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.domain.model.AggregateRoot;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tarefa implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    private Long id;


    protected Tarefa(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Long other) {
        return 0;
    }

    @Override
    public Long identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return false;
    }
}
