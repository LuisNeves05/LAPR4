package eapli.base.equipa.domain;

import eapli.framework.domain.model.ValueObject;

public class Acronimo implements ValueObject {

    private String acronimo;

    public Acronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public Acronimo() {
    }

    @Override
    public String toString() {
        return acronimo;
    }
}
