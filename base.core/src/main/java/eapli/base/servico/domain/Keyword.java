package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe do Value Object Keyword
 */
@Embeddable
public class Keyword implements ValueObject, Comparable<Keyword> {

    /**
     * Palavra chave (keyword) do Servico
     */
    private String keyword;

    /**
     * Construtor do Keyword
     * @param keyword Palavra chave do Servico
     */
    public Keyword(String keyword){
        if (StringPredicates.isNullOrEmpty(keyword) || !validaKeyword(keyword)) {
            throw new IllegalArgumentException(
                    "A keyword deve ser alfanumérico entre 1 a 50 caracteres");
        }
        this.keyword = keyword;
    }

    /**
     * Construtor vazio do Keyword
     */
    protected Keyword(){}

    /**
     * Validação da keyword que deve ser alfanumérico entre 1 a 50 caracteres
     * @return true se for válido / false se for inválido
     */
    private boolean validaKeyword(final String keyword) {
        String regex = ".{1,50}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(keyword);

        return matcherAlphaNumericCheck.find();
    }

    /**
     * Validação da keyword que deve ser alfanumérico entre 1 a 50 caracteres
     * @return true se for válido / false se for inválido
     */
    public static Keyword valueOf(final String keyword) {
        return new Keyword(keyword);
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
        if (!(o instanceof Keyword)) {
            return false;
        }

        final Keyword that = (Keyword) o;
        return this.keyword.equals(that.keyword);
    }

    /**
     * HashCode da Keyword
     */
    @Override
    public int hashCode() {
        return this.keyword.hashCode();
    }

    /**
     * compareTo da Keyword
     */
    @Override
    public int compareTo(final Keyword o) {
        return this.keyword.compareTo(o.keyword);
    }

    /**
     * toString da Keyword
     */
    @Override
    public String toString(){
        return this.keyword;
    }
}
