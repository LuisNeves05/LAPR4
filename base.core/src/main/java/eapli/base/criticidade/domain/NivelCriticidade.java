package eapli.base.criticidade.domain;

import eapli.base.Utils.ColorConverter;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;
import java.awt.*;

@Entity
public class NivelCriticidade implements Comparable<Long>, AggregateRoot<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Etiqueta etiqueta;

    @Embedded
    private ValorEscala valorDeEscala;

    @Convert ( converter = ColorConverter.class)
    @Column(name="COR")
    private Color cor;

    @Embedded
    private Objetivo objetivo;


    public NivelCriticidade(Etiqueta etiqueta, ValorEscala valorDeEscala, Color cor, Objetivo objetivos) {
        this.etiqueta = etiqueta;
        this.valorDeEscala = valorDeEscala;
        this.cor = cor;
        this.objetivo = objetivos;
    }

    public NivelCriticidade(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }


    public boolean definirObjetivoCustomizado(Objetivo objetivo) {
        boolean flag = false;
        if (!(this.objetivo.equals(objetivo))){
        this.objetivo = objetivo;
        flag= true;}
        return flag;

    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public ValorEscala getValorDeEscala() {
        return valorDeEscala;
    }

    public Color getCor() {
        return cor;
    }
}
