package eapli.base.equipa.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodigoEquipa implements ValueObject {
    private String codigoEquipa;


    public CodigoEquipa(String codigoEquipa) {

        if (!validaIdentificador(codigoEquipa)) {
            throw new IllegalArgumentException(
                    "O identificador de uma equipa deve ser alfanumérico entre 1 a 15 caracteres");
        }
        this.codigoEquipa = codigoEquipa;
    }


    public boolean validaIdentificador(final String identificador) {
        return  StringUtils.isAlphanumeric(identificador);
    }


    public CodigoEquipa() {}
}
