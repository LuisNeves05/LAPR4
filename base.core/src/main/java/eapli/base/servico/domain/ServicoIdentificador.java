package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class ServicoIdentificador implements ValueObject, Comparable<ServicoIdentificador> {

    /**
     * Identificador único do Serviço
     */
    private String identificador;

    /**
     * Construtor do ServicoIdentificador
     * @param identificador identificador único do Serviço
     */
    public ServicoIdentificador(String identificador){
        if (StringPredicates.isNullOrEmpty(identificador) || !validaIdentificador(identificador)) {
            throw new IllegalArgumentException(
                    "O identificador de um serviço deve ser alfanumérico entre 1 a 15 caracteres");
        }
        this.identificador = identificador;
    }

    /**
     * Construtor vazio do ServicoIdentificador
     */
    protected ServicoIdentificador(){}

    /**
     * Validação do identificador único do serviço que deve ser alfanumérico entre 1 a 15 caracteres
     * @return true se for válido / false se for inválido
     */
    private boolean validaIdentificador(final String identificador) {
        String regex = "[a-zA-Z0-9]{1,15}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(identificador);

        return matcherAlphaNumericCheck.find();
    }

    /**
     * Validação do identificador único do serviço que deve ser alfanumérico entre 1 a 15 caracteres
     * @return true se for válido / false se for inválido
     */
    public static ServicoIdentificador valueOf(final String identificador) {
        return new ServicoIdentificador(identificador);
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
        if (!(o instanceof ServicoIdentificador)) {
            return false;
        }

        final ServicoIdentificador that = (ServicoIdentificador) o;
        return this.identificador.equals(that.identificador);
    }

    /**
     * HashCode do identificador
     */
    @Override
    public int hashCode() {
        return this.identificador.hashCode();
    }

    /**
     * compareTo do identificador
     */
    @Override
    public int compareTo(final ServicoIdentificador o) {
        return this.identificador.compareTo(o.identificador);
    }

    /**
     * toString do identificador
     */
    @Override
    public String toString(){
        return this.identificador;
    }
}
