package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Arrays;
import java.util.List;

@Embeddable
public class Etiqueta implements ValueObject {

    private String etiqueta;

    public Etiqueta(String etiqueta) {
        if(checkEtiqueta(etiqueta)){
            this.etiqueta = etiqueta;
        }
    }

    private boolean checkEtiqueta(String etiqueta){
        List<String> etiquetas = Arrays.asList(new String[]{"baixa", "média", "elevada"});

        if(!etiquetas.contains(etiqueta)){
            System.out.println("Etiqueta Inválida!");
            return false;
        }
        return true;
    }


    public Etiqueta() {}

    @Override
    public String toString() {
        return  etiqueta;
    }
}
