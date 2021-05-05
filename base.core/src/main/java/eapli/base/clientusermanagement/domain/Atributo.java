package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;


public class Atributo implements ValueObject {

    private String nomeVar, lable, descAjuda;
    private TipoDados tipoDados;

    public Atributo(String nomeVar, String lable, String descAjuda, TipoDados tipoDados) {
        this.nomeVar = nomeVar;
        this.lable = lable;
        this.descAjuda = descAjuda;
        this.tipoDados = tipoDados;
    }

    public Atributo(){}
}
