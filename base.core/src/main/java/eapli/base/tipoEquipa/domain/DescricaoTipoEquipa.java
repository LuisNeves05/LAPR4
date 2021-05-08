package eapli.base.tipoEquipa.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class DescricaoTipoEquipa implements ValueObject,Comparable<DescricaoTipoEquipa> {

    private  String descricao;


    public DescricaoTipoEquipa(String descricao) {
        if(validaIdentificador(descricao))
            this.descricao = descricao;
    }

    protected DescricaoTipoEquipa(){}



    private boolean validaIdentificador(final String descricao) {
        String regex = "[a-zA-Z0-9]{1,50}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(descricao);

        return matcherAlphaNumericCheck.find();
    }

    public static DescricaoTipoEquipa valueOf(final String descricao) {
        return new DescricaoTipoEquipa(descricao);
    }

    @Override
    public int compareTo(final DescricaoTipoEquipa o) {
        return this.descricao.compareTo(o.descricao);
    }
}


