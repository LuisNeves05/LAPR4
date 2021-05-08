package eapli.base.criticidade.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Criticidade implements Comparable<Criticidade>, AggregateRoot<Criticidade> {


    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Etiqueta etiqueta;
    private ValorEscala valorDeEscala;
    private Cor cor;
    private Objetivos objetivos;



    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Criticidade identity() {
        return null;
    }
}
