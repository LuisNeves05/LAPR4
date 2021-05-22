package eapli.base.criticidade.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ValorEscala {

    private int valor;

    public ValorEscala(int valor) {
        if(checkValorEscala(valor)){
            this.valor = valor;
        }
    }

    private boolean checkValorEscala(int valor){
        if(!(valor < 4 && valor >1)){
            System.out.println("Escala Inválida!");
            return false;
        }
        return true;
    }

    public ValorEscala() {}

    @Override
    public String toString() {
        return String.valueOf(this.valor);
    }
}
