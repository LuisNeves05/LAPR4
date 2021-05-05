package eapli.base.especificarservico.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

/**
 * Classe do Value Object Keyword
 */
@Embeddable
public class Keyword implements ValueObject {

    private String keyword;

    public Keyword(){}
}
