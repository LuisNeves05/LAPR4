package eapli.base.servico.domain;

import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class DescricaoBreve implements Comparable<DescricaoBreve> {

    private String descBreve;

    protected DescricaoBreve(){}

    public DescricaoBreve(String descBreve){
        /*if (StringPredicates.isNullOrEmpty(descBreve) || !validaDescricaoBreve(descBreve)) {
            throw new IllegalArgumentException(
                    "A descrição breve de um serviço entre 1 a 40 caracteres");
        }*/
        this.descBreve = descBreve;
    }

    private boolean validaDescricaoBreve(final String descBreve) {
        String regex = "(.|[ \\n\\t]){1,40}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(descBreve);

        return matcher.find();
    }

    /**
     * Validação da descrição breve o que deve ser alfanumérica entre 1 a 40 caracteres
     * @return true se for válido / false se for inválido
     */
    public static DescricaoBreve valueOf(final String descBreve) {
        return new DescricaoBreve(descBreve);
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
        if (!(o instanceof DescricaoBreve)) {
            return false;
        }

        final DescricaoBreve that = (DescricaoBreve) o;
        return this.descBreve.equals(that.descBreve);
    }

    /**
     * HashCode da descrição breve
     */
    @Override
    public int hashCode() {
        return this.descBreve.hashCode();
    }

    /**
     * compareTo da descrição breve
     */
    @Override
    public int compareTo(final DescricaoBreve o) {
        return this.descBreve.compareTo(o.descBreve);
    }

    /**
     * toString da descrição breve
     */
    @Override
    public String toString(){
        return this.descBreve;
    }
}
