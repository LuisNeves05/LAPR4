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

    /**
     * Acrónimo Único da Equipa
     */
    @Column(unique = true)
    private Acronimo acr;

    /**
     * Designação da Equipa
     */
    private String designacao;

    @OneToMany
    private Set<Colaborador> colabResponsavel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogoId", nullable = false)
    private Catalogo catalogo;

    /**
     *
     * @param codigoEquipa codigo da equipa obrigatório no construtor
     * @param acr acrónimo da equipa obrigatório no construtor
     * @param designacao designação da equipa obrigatório no construtor
     */

    public Equipa(Long codigoEquipa, Acronimo acr, String designacao, Set<Colaborador> colabR) {
        this.codigoEquipa = codigoEquipa;
        this.acr = acr;
        this.designacao = designacao;
        this.colabResponsavel = colabR;
    }

    /**
     * Contrutor vazio obrigatório pela framework de JPA
     */
    public Equipa() {}

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
