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

    @Convert(converter = ColorConverter.class)
    private Color cor;

    @Embedded
    private Objetivo objetivo;

    private boolean isDefault;

    public NivelCriticidade(Etiqueta etiqueta, ValorEscala valorDeEscala, Color cor, Objetivo objetivos, boolean isDefault) {
        this.etiqueta = etiqueta;
        this.valorDeEscala = valorDeEscala;
        this.cor = cor;
        this.objetivo = objetivos;
        this.isDefault = isDefault;
    }

    public NivelCriticidade() {
    }

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
        if (!(this.objetivo.equals(objetivo))) {
            this.objetivo = objetivo;
            flag = true;
        }
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

    public Objetivo objetivos() {
        return objetivo;
    }

    public boolean isDefault() {
        return isDefault;
    }


    @Override
    public String toString() {
        return "NivelCriticidade ID : " + id +
                "       Etiqueta : " +
                etiqueta+
                "       Valor de escala : " +
                valorDeEscala +
                "       Cor : " + toStringCor(cor)
                +
                "       Objetivo : " +
                objetivo.toString();
    }



    public String toStringCor (Color color){
        String cor="";
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=255,b=255]")){
            cor = "Branco ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=192,g=192,b=192]")){
            cor = "Cinzento Claro ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=128,g=128,b=128]")){
            cor = "Cinzento ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=64,g=64,b=64]")){
            cor = "Cinzento Escuro ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=0,b=0]")){
            cor = "Preto ";
        }

        if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=0,b=0]")){
            cor = "Vermelho ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=175,b=175]")){
            cor = "Rosa ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=200,b=0]")){
            cor = "Laranja ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=255,b=0]")){
            cor = "Amarelo ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=255,b=0]")){
            cor = "Verde ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=255,g=0,b=255]")){
            cor = "Magenta ";
        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=255,b=255]")){
            cor = "Ciano ";

        }
        if (color.toString().equalsIgnoreCase("java.awt.Color[r=0,g=0,b=255]")){
            cor = "Azul ";
        }

        return cor;

    }
}

