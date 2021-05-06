package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;

public class TipoDados implements ValueObject {

    private String tipo;
    private static final String string = "STRING";
    private static final String inteiro = "INT";
    private static final String data = "DATA";
    private static final String booleano = "BOOLEANO";

    public TipoDados(String tipo){
        if(validaTipo(tipo))
            this.tipo = tipo;
    }

    public TipoDados(){}

    private boolean validaTipo(String tipo){
        return tipo.equals(string) || tipo.equals(inteiro) || tipo.equals(data) || tipo.equals(booleano);
    }
}