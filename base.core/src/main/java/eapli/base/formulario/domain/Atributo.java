package eapli.base.formulario.domain;

//import eapli.base.clientusermanagement.domain.TipoDados;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


/**
 * Classe do Value Object Atributo
 */
@Embeddable
public class Atributo implements ValueObject {

    /**
     * Nome de variável
     */
    private String nomeVar;
    /**
     * Label de apresentação
     */
    private String lable;
    /**
     * Descrição de ajuda
     */
    private String descAjuda;
    /**
     * Tipo de dados base
     */
    private TipoDados tipoDados;
    /**
     * Expressão regular
     */
    private String expRegular;

    /**
     * Construtor vazio requerido do Atributo
     */
    public Atributo(String nomeVar, String lable, String descAjuda, TipoDados tipoDados, String expRegular) {
        this.nomeVar = nomeVar;
        this.lable = lable;
        this.descAjuda = descAjuda;
        this.tipoDados = tipoDados;
        this.expRegular = expRegular;
    }

    @Override
    public String toString() {
        return "Atributo{" +
                "nomeVar='" + nomeVar + '\'' +
                ", lable='" + lable + '\'' +
                ", descAjuda='" + descAjuda + '\'' +
                ", tipoDados=" + tipoDados +
                ", expRegular='" + expRegular + '\'' +
                '}';
    }

    /**
     * Construtor vazio requerido do Atributo
     */
    public Atributo() {
    }
}
