package eapli.base.equipa.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Equipa implements Comparable<Equipa>, AggregateRoot<Equipa> {

    /**
     *
     *  Identificador único da Equipa
     */
    @Id
    @Column(unique = true)
    private Long codigoEquipa;

    @Column(unique = true)
    private Acronimo acr;

    private String designacao;

    //@OneToMany
    //private Set<Colaborador> colaboradores;

    public Equipa(Long codigoEquipa, Acronimo acr, String designacao) {
        this.codigoEquipa = codigoEquipa;
        this.acr = acr;
        this.designacao = designacao;
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

    @Override
    public String toString() {
        return String.format("Código Equipa: %d Acrónimo: %s Designação: %s",
                this.codigoEquipa, this.acr, this.designacao);
    }

}
