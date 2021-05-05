package eapli.base.clientusermanagement.domain.servico;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * Classe do Value Object Keyword
 */
@Embeddable
public class Keyword implements ValueObject {

    private String keyword;

    public Keyword(){}
}
