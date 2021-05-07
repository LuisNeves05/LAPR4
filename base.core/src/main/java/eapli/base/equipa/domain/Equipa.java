package eapli.base.equipa.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Equipa implements Comparable<Equipa>, AggregateRoot<Equipa> {

    /**
     *
     *  Identificador único da Equipa
     */
    @Id
    private Long codigoEquipa;

    @Column(name = "ACRONIMO")
    private Acronimo acr;

    private String designacao;

    public Equipa(Long codigoEquipa) {
        this.codigoEquipa = codigoEquipa;
    }

    /**
     * Contrutor vazio obrigatório pela framework de JPA
     */
    protected Equipa() {}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Equipa other) {
        return 0;
    }

    @Override
    public Equipa identity() {
        return null;
    }

}
