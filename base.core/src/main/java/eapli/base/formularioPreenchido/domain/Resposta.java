package eapli.base.formularioPreenchido.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Resposta {

    private String resposta;

    private String pergunta;

    public Resposta(){}

    public Resposta(String resposta, String pergunta){
        this.resposta = resposta;
        this.pergunta= pergunta;
    }

}
