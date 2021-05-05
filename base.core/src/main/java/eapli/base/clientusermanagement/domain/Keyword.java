package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
public class Keyword implements ValueObject {

    @Id
    private Long id;

    private String keyword;

    @ManyToOne
    private Servico servico;

    public Keyword(){}
}
