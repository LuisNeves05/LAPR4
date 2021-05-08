package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;

public class NomeFormulario implements ValueObject {

    private String nome;

    public NomeFormulario(String nome){
        if(validaNome(nome))
            this.nome = nome;
        else
            System.out.println("Nome inválido!");
    }

    private boolean validaNome(String nome){
        return nome.length() < 50;
    }
}
