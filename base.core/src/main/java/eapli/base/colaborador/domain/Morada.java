package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Morada implements ValueObject {

    private String distrito;
    private String concelho;

    protected Morada (){}

    public Morada(String distrito, String concelho){
        this.distrito = distrito;
        this.concelho = concelho;

    }



    @Override
    public String toString() {
        return "Morada{" + "distrito='" + distrito + '\'' + ", concelho='" + concelho + '\'' +'}';
    }
}
