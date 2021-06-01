package eapli.base.catalogo.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.DescricaoBreve;
import eapli.base.servico.domain.DescricaoCompleta;
import eapli.base.servico.domain.Titulo;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Catalogo implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITULO")
    private Titulo titulo;
    /**
     * Descrição brece do serviço
     */
    @Column(name = "DESCRICAO BREVE")
    private DescricaoBreve descBreve;
    /**
     * Descrição completa do serviço
     */
    @Column(name = "DESCRICAO COMPLETA")
    private DescricaoCompleta descComp;
    /**
     * Ícone do serviço
     */
    @Column(name = "ICONE")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] icon;

    @OneToOne
    private Colaborador colaboradorResponsavel;

    @ManyToMany
    private Set<Equipa> equipas = new HashSet<>();

    @OneToOne(cascade= CascadeType.ALL)
    private NivelCriticidade nivelCriticidade;

    protected Catalogo(){}

    public Catalogo(Titulo titulo, DescricaoBreve descBreve, DescricaoCompleta descComp, byte[] icon, Colaborador colaboradorResponsavel, Set<Equipa> equipas) {
        this.titulo = titulo;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.icon = icon;
        this.colaboradorResponsavel = colaboradorResponsavel;
        this.equipas = equipas;
        this.nivelCriticidade= null;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString(){
        return ""+titulo;
    }

    public  boolean adicionarNivelCriticidade(NivelCriticidade nivelCriticidade){
        this.nivelCriticidade = nivelCriticidade;
        return  (this.nivelCriticidade!= null);
    }

    public Colaborador colaboradorResponsavelDoCatalogo(){
        return colaboradorResponsavel;
    }

    public NivelCriticidade nivelCritToService(){
        return this.nivelCriticidade;
    }
}
