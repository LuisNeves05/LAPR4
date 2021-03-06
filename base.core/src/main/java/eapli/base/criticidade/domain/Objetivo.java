package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Embeddable
public class Objetivo implements ValueObject, Comparable<Objetivo>{

    private int aprovacaoMax;
    private int resolucaoMax;
    private int aprovacaoMedia;
    private int resolucaoMedia;

    public Objetivo(int aprovacaoMax, int resolucaoMax, int aprovacaoMedia, int resolucaoMedia) {
        this.aprovacaoMax = aprovacaoMax;
        this.resolucaoMax = resolucaoMax;
        this.aprovacaoMedia = aprovacaoMedia;
        this.resolucaoMedia = resolucaoMedia;
    }

    public int tempoMaximoAprovacao() {
        return aprovacaoMax;
    }

    public int tempoMaximoResolucao() {
        return resolucaoMax;
    }

    public int tempoMedioAprovacao() { return aprovacaoMedia; }

    public int tempoMedioResolucao() { return resolucaoMedia; }

    public Objetivo(){}


    @Override
    public int compareTo(Objetivo o) {
        return 0;
    }

    @Override
    public String toString() {
        return " Período aprovação máximo : " + aprovacaoMax +
                "       Período aprovação médio : " + aprovacaoMedia +
                "       Período resolução máximo : " +   resolucaoMax+
                "       Período resolução médio : " + resolucaoMedia + "\n"
                ;
    }
}
