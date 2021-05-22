package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class NomeFormulario implements ValueObject {

    private String nome;

    public NomeFormulario(String nome){
        if(validaNome(nome))
            this.nome = nome;
        else
            System.out.println("Nome inválido!");
    }

    public NomeFormulario() {

    }

    private boolean validaNome(String nome){
        return nome.length() < 50;
    }

    @Override
    public String toString() {
        return nome;
    }
}
