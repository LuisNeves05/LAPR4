package eapli.base.equipa.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.repositories.IntegrityViolationException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "Equipa")
public class Equipa implements AggregateRoot<CodigoEquipa> {

    /**
     *
     *  Identificador único da Equipa
     */
    @EmbeddedId
    private CodigoEquipa codigoEquipa;

    @OneToOne
    private TipoEquipa tipoEquipa;

    /**
     * Acrónimo Único da Equipa
     */
    @Column(name = "acronimo",unique = true)
    private Acronimo acr;

    /**
     * Designação da Equipa
     */
    private String designacao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="EQUIPA_RESPONSAVEL")
    private Set<Colaborador> listaColabsResponsaveis = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="EQUIPA_COLABORADOR")
    private Set<Colaborador> listaColabs = new HashSet<>();

    /**
     *
     * @param codigoEquipa codigo da equipa obrigatório no construtor
     * @param acr acrónimo da equipa obrigatório no construtor
     * @param designacao designação da equipa obrigatório no construtor
     */

    public Equipa(CodigoEquipa codigoEquipa, Acronimo acr, String designacao, Set<Colaborador> colabR, TipoEquipa tipoEquipa) {
        this.codigoEquipa = codigoEquipa;
        this.acr = acr;
        this.designacao = designacao;
        this.listaColabsResponsaveis = colabR;
        this.tipoEquipa = tipoEquipa;
    }


    public boolean adicionarColaboradorResponsavel(Colaborador colab) {
        listaColabs.add(colab);
        return listaColabsResponsaveis.add(colab);
    }

    public boolean adicionarColaborador(Colaborador colab) {
        if(colab.pertenceTipoEquipa(tipoEquipa))
            throw new IntegrityViolationException("ERRO! Colaborador ja pertence a uma equipa deste tipo!");
        if (temColab(colab))
            throw new IntegrityViolationException("ERRO! Colaborador já pertence a esta equipa!!");
        return listaColabs.add(colab);
    }

    public boolean removerColab(Colaborador colab){
        if (temResponsavel(colab))
            return listaColabsResponsaveis.remove(colab) && listaColabs.remove(colab);

        return listaColabs.remove(colab);
    }

    public boolean temTipoEquipa(TipoEquipa tipoEquipa) {
        return this.tipoEquipa.sameAs(tipoEquipa);
    }

    /**
     * Contrutor vazio obrigatório pela framework de JPA
     */
    public Equipa() {}

    @Override
    public int compareTo(CodigoEquipa other) {
        return 0;
    }

    @Override
    public CodigoEquipa identity() {
        return this.codigoEquipa;
    }

    @Override
    public String toString() {
        return this.codigoEquipa.toString();
    }

    public boolean temColab(Colaborador colab) {
        return this.listaColabs.contains(colab);
    }

    public boolean temResponsavel(Colaborador colab) {
        return this.listaColabsResponsaveis.contains(colab);
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }


}
