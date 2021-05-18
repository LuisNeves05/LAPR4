package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Titulo implements ValueObject, Comparable<Titulo> {

    /**
     * Titulo do serviço
     */
    private String titulo;

    /**
     * Construtor do Titulo
     * @param titulo Titulo do serviço
     */
    public Titulo(String titulo){
        /*if (!StringPredicates.isNullOrEmpty(titulo) || !validaTitulo(titulo)) {
            throw new IllegalArgumentException(
                    "O Título deve ser alfanumérico entre 1 a 50 caracteres");
        }*/
        this.titulo = titulo;
    }

    /**
     * Construtor vazio do Titulo
     */
    protected Titulo(){}

    /**
     * Validação do Titulo do serviço que deve ser alfanumérico entre 1 a 15 caracteres
     * @return true se for válido / false se for inválido
     */
    private boolean validaTitulo(final String titulo) {
        String regex = ".{1,50}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(titulo);

        return matcherAlphaNumericCheck.find();
    }

    /**
     * Validação do Titulo do serviço que deve ser alfanumérico entre 1 a 15 caracteres
     * @return true se for válido / false se for inválido
     */
    public static Titulo valueOf(final String titulo) {
        return new Titulo(titulo);
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
        if (!(o instanceof Titulo)) {
            return false;
        }

        final Titulo that = (Titulo) o;
        if(this.titulo == null){
            return that.titulo == null;
        }
        return this.titulo.equals(that.titulo);
    }

    /**
     * HashCode do Titulo
     */
    @Override
    public int hashCode() {
        return this.titulo.hashCode();
    }

    /**
     * compareTo do Titulo
     */
    @Override
    public int compareTo(final Titulo o) {
        return this.titulo.compareTo(o.titulo);
    }

    /**
     * toString do Titulo
     */
    @Override
    public String toString(){
        return this.titulo;
    }
}
