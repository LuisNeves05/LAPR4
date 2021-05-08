package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Funcao {

    private String listaFuncao;
    protected Funcao(){}



   public Funcao(String funcao){
         this.listaFuncao = funcao;
    }

}
