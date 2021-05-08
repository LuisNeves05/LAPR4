package eapli.base.colaborador.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class NomeCompleto implements ValueObject, Comparable<NomeCompleto> {

    private String nomeCompleto;

    protected NomeCompleto(){}

    public NomeCompleto(String nomeCompleto){
        if (StringPredicates.isNullOrEmpty(nomeCompleto) || !validaNomeCompleto(nomeCompleto)) {
            throw new IllegalArgumentException(
                    "O nome completo do colaborador deve ter apenas letras entre 1 a 80 caracteres");
        }
        this.nomeCompleto = nomeCompleto;
    }

    private boolean validaNomeCompleto(final String nomeCompleto) {
        String regex = "[A-Za-zÇ-ú]{1,80}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherNameCheck = pattern.matcher(nomeCompleto);

        return matcherNameCheck.find();
    }

    /**
     * Validação do nome completo o que deve ter apenas letras entre 1 a 80 caracteres
     * @return true se for válido / false se for inválido
     */
    public static NomeCompleto valueOf(final String nomeCompleto) {
        return new NomeCompleto(nomeCompleto);
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
        if (!(o instanceof NomeCompleto)) {
            return false;
        }

        final NomeCompleto that = (NomeCompleto) o;
        return this.nomeCompleto.equals(that.nomeCompleto);
    }

    /**
     * HashCode do nome completo
     */
    @Override
    public int hashCode() {
        return this.nomeCompleto.hashCode();
    }

    /**
     * compareTo do nome completo
     */
    @Override
    public int compareTo(final NomeCompleto o) {
        return this.nomeCompleto.compareTo(o.nomeCompleto);
    }

    /**
     * toString do nome completo
     */
    @Override
    public String toString(){
        return this.nomeCompleto;
    }





}
