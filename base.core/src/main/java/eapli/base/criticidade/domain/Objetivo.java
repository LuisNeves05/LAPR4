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

    public Objetivo(){}


    @Override
    public int compareTo(Objetivo o) {
        return 0;
    }

}
