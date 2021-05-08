package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Funcao {

    private String listaFuncao;
    protected Funcao(){}

    @Override
    public String toString() {
        return listaFuncao + " ";
    }

    public Funcao(String funcao){
         this.listaFuncao = funcao;
    }

}
