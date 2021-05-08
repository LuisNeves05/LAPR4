package eapli.base.criticidade.domain;

import java.util.Arrays;
import java.util.List;

public class Etiqueta {

    private String etiqueta;

    public Etiqueta(String etiqueta) {
        if(checkEtiqueta(etiqueta)){
            this.etiqueta = etiqueta;
        }
    }

    private boolean checkEtiqueta(String etiqueta){
        List<String> etiquetas = Arrays.asList(new String[]{"baixa", "média", "elevada"});

        if(!etiquetas.contains(etiquetas)){
            System.out.println("Etiqueta Inválida!");
            return false;
        }
        return true;
    }


    public Etiqueta() {}

    @Override
    public String toString() {
        return this.etiqueta;
    }
}
