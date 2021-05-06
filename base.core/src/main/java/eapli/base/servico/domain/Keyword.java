package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

/**
 * Classe do Value Object Keyword
 */
@Embeddable
public class Keyword implements ValueObject {

    private String keyword;

    public Keyword(String keyword){
        this.keyword = keyword;
    }

    public Keyword(){}
}
