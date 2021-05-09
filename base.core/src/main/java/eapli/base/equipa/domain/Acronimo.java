package eapli.base.equipa.domain;

import eapli.framework.domain.model.ValueObject;
import org.apache.commons.lang3.StringUtils;

public class Acronimo implements ValueObject {

    private String acronimo;

    public Acronimo(String acronimo) {

        if (!validaIdentificador(acronimo)) {
            throw new IllegalArgumentException(
                    "O acrónimo de uma equipa deve ser alfanumérico entre 1 a 15 caracteres");
        }
        this.acronimo = acronimo;
    }

    private boolean validaIdentificador(final String identificador) {
        return  StringUtils.isAlphanumeric(identificador);
    }

    public Acronimo() {}

    @Override
    public String toString() {
        return acronimo;
    }
}
