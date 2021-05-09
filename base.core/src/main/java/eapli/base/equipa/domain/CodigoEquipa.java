package eapli.base.equipa.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodigoEquipa implements ValueObject {
    private String codigoEquipa;


    public CodigoEquipa(String codigoEquipa) {

        System.out.println(codigoEquipa);
        System.out.println(validaIdentificador(codigoEquipa));
        if (!validaIdentificador(codigoEquipa)) {
            throw new IllegalArgumentException(
                    "O identificador de uma equipa deve ser alfanumérico entre 1 a 15 caracteres");
        }
        this.codigoEquipa = codigoEquipa;
    }


    private boolean validaIdentificador(final String identificador) {
        String regex = "[A-Za-z0-9]{1,15}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(identificador);

        return matcherAlphaNumericCheck.find();
    }


    public CodigoEquipa() {}
}
