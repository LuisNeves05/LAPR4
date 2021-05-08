package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class NrContacto implements ValueObject {

    private int nrContacto;

    protected NrContacto(){}

    public NrContacto(int nrContacto){
        if (StringPredicates.isNullOrEmpty(String.valueOf(nrContacto)) || !validaNrContacto(nrContacto)) {
            throw new IllegalArgumentException(
                    "O nr de contacto do colaborador deve 9 dígitos");
        }
        this.nrContacto = nrContacto;
    }

    private boolean validaNrContacto( int nrContacto) {
        String regex = "[0-9]{9}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNumberCheck = pattern.matcher(String.valueOf(nrContacto));

        return matcherNumberCheck.find();
    }


}
