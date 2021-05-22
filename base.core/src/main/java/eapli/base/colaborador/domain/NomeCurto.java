package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class NomeCurto implements ValueObject, Comparable<NomeCurto> {

    private String nomeCurto;

    protected NomeCurto(){}

    public NomeCurto(String nomeCurto){
        if (StringPredicates.isNullOrEmpty(nomeCurto) || !validaNomeCurto(nomeCurto)) {
            throw new IllegalArgumentException(
                    "O nome curto do colaborador deve ter apenas letras entre 1 a 30 caracteres");
        }
        this.nomeCurto = nomeCurto;
    }

    private boolean validaNomeCurto(final String nomeCurto) {
        String regex = "[A-Za-zÇ-ú]{1,30}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNameCheck = pattern.matcher(nomeCurto);

        return matcherNameCheck.find();
    }

    /**
     * Validação do nome curto o que deve ter apenas letras entre 1 a 30 caracteres
     * @return true se for válido / false se for inválido
     */
    public static NomeCurto valueOf(final String nomeCurto) {
        return new NomeCurto(nomeCurto);
    }

    /**
     * Verifica se os objetos são iguais
     * @return true se for igual / false se for diferente
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NomeCurto)) {
            return false;
        }

        final NomeCurto that = (NomeCurto) o;
        return this.nomeCurto.equals(that.nomeCurto);
    }

    /**
     * HashCode do nome curto
     */
    @Override
    public int hashCode() {
        return this.nomeCurto.hashCode();
    }

    /**
     * compareTo da nome curto
     */
    @Override
    public int compareTo(final NomeCurto o) {
        return this.nomeCurto.compareTo(o.nomeCurto);
    }

    /**
     * toString do nome curto
     */
    @Override
    public String toString(){
        return this.nomeCurto;
    }

}
