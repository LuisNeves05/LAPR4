package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

public class TipoDados implements ValueObject {

    private String tipo;

    public TipoDados(String tipo){
        if(validaTipo(tipo))
            this.tipo = tipo;
    }

    public TipoDados(){}

    public String getTipo(){
        return this.tipo;
    }

    private boolean validaTipo(String tipo){
        return tipo.equals(Tipo.STRING.name()) || tipo.equals(Tipo.INT.name()) || tipo.equals(Tipo.DATA.name()) || tipo.equals(Tipo.BOOLEANO.name());
    }

    enum Tipo {
        STRING,
        INT,
        DATA,
        BOOLEANO
    }
}
