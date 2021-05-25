package eapli.base.tipoTarefa.domain;

import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class TipoTarefa implements Comparable<Long>, AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Servico servico;

    private String descricao;

    protected TipoTarefa(){}

    public TipoTarefa(Servico serv, String descricao){
        this.servico = serv;
        this.descricao = descricao;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}
