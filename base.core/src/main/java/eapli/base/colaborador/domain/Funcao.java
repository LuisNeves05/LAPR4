package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Funcao {

    private String funcao;
    protected Funcao(){}



   public Funcao(String funcao){
         this.funcao = funcao;
    }

}
