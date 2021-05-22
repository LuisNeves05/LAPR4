package eapli.base.equipa.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class CodigoEquipa implements ValueObject, Comparable<CodigoEquipa> {
    private String codigoEquipa;

    @Override
    public String toString() {
        return  codigoEquipa;
    }

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

    @Override
    public int compareTo(CodigoEquipa o) {
        return this.codigoEquipa.compareTo(o.codigoEquipa);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodigoEquipa)) {
            return false;
        }

        final CodigoEquipa that = (CodigoEquipa) o;
        return this.codigoEquipa.equals(that.codigoEquipa);
    }

    @Override
    public int hashCode() {
        return this.codigoEquipa.hashCode();
    }


}
