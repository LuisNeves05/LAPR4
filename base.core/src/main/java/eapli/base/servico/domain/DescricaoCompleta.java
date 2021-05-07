package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class DescricaoCompleta implements ValueObject, Comparable<DescricaoCompleta> {

    private String descComp;

    protected DescricaoCompleta(){}

    public DescricaoCompleta(String descCompleta){
        if (StringPredicates.isNullOrEmpty(descCompleta) || !validaDescCompleta(descCompleta)) {
            throw new IllegalArgumentException(
                    "A descrição completa de um serviço deve ser alfanumérico entre 1 a 500 caracteres");
        }
        this.descComp = descCompleta;
    }

    private boolean validaDescCompleta(final String descCompleta) {
        String regex = ".{1,500}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(descCompleta);

        return matcherAlphaNumericCheck.find();
    }

    /**
     * Validação da descrição completa o que deve ser alfanumérica entre 1 a 500 caracteres
     * @return true se for válido / false se for inválido
     */
    public static DescricaoCompleta valueOf(final String descComp) {
        return new DescricaoCompleta(descComp);
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
        if (!(o instanceof DescricaoCompleta)) {
            return false;
        }

        final DescricaoCompleta that = (DescricaoCompleta) o;
        return this.descComp.equals(that.descComp);
    }

    /**
     * HashCode da descrição completa
     */
    @Override
    public int hashCode() {
        return this.descComp.hashCode();
    }

    /**
     * compareTo da descrição completa
     */
    @Override
    public int compareTo(final DescricaoCompleta o) {
        return this.descComp.compareTo(o.descComp);
    }

    /**
     * toString da descrição completa
     */
    @Override
    public String toString(){
        return this.descComp;
    }
}
