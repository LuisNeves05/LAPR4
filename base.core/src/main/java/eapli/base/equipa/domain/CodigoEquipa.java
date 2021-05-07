package eapli.base.equipa.domain;

import eapli.framework.domain.model.ValueObject;

public class CodigoEquipa implements ValueObject {
    private Long codigoEquipa;

    public CodigoEquipa(Long codigoEquipa) {
        this.codigoEquipa = codigoEquipa;
    }

    public CodigoEquipa() {}
}
