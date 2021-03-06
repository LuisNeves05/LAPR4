package eapli.base.servico.domain;


import eapli.base.catalogo.domain.Catalogo;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.formulario.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe da Entidade Serviço
 */
@Entity
@Table
public class Servico implements AggregateRoot<ServicoIdentificador>, Comparable<ServicoIdentificador> {

    /**
     * Identificador único do Serviço
     */
    @EmbeddedId
    @Column(name = "ID")
    private ServicoIdentificador servicoIdent;
    /**
     * Titulo do Servico
     */
    @Column(name = "TITULO")
    private Titulo titulo;
    /**
     * Descrição brece do serviço
     */
    @Column(name = "DESCRICAO_BREVE")
    @Embedded
    private DescricaoBreve descBreve;
    /**
     * Descrição completa do serviço
     */
    @Column(name = "DESCRICAO_COMPLETA")
    @Embedded
    private DescricaoCompleta descComp;
    /**
     * Ícone do serviço
     */
    @Column(name = "ICONE")
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] icon;
    /**
     * Conjunto de palavras chave de um serviço
     */
    @Column(name = "PALAVRAS_CHAVE")
    @ElementCollection
    private Set<Keyword> keywords;
    /**
     * Estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    @Column(name = "ESTADO")
    @Enumerated(EnumType.STRING)
    private EstadoServico estado;
    /**
     * Servico é pertencente a um Catalogo
     */
    @OneToOne
    private Catalogo catalogo;

    @OneToMany
    private Set<Formulario> formularios;
    /**
     * Feedback do colaborador que requisitou o serviço
     */
    @Column(name="REQUER_FEEDBACK")
    private boolean requerFeedback;

    /**
     * Nível de Criticidade associada ao serviço
     */
    @OneToOne
    private NivelCriticidade nivelCriticidade;

    @OneToOne
    private FluxoAtividade fluxoAtividade;


    /**
     * Construtor da entidade Servico
     * @param titulo    do Servico
     * @param descBreve descrição breve do serviço
     * @param descComp  descrição completa do serviço
     * @param icon      ícone associado
     * @param keywords  conjunto de palavras chave
     * @param estado    estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    public Servico(ServicoIdentificador idServ, Titulo titulo, DescricaoBreve descBreve, DescricaoCompleta descComp, byte[] icon,
                   Set<Keyword> keywords, EstadoServico estado, FluxoAtividade fluxoAtiv,Catalogo catalogo, boolean requerFeedback, NivelCriticidade nivelCriticidade) {
        this.servicoIdent = idServ;
        this.titulo = titulo;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.icon = icon;
        this.estado = estado;
        this.keywords = keywords;
        this.catalogo = catalogo;
        this.requerFeedback = requerFeedback;
        this.formularios = new HashSet<>();
        this.nivelCriticidade = nivelCriticidade;
        this.fluxoAtividade = fluxoAtiv;
    }

    /**
     * Construtor vazio requerido da entidade Servico
     */
    protected Servico(){}

    public void adicionaFormulario(Formulario f){
        if(!this.formularios.contains(f)){
            formularios.add(f);
        }
    }

    public boolean adicionarNivelCriticidade(NivelCriticidade nivelCriticidade){
        this.nivelCriticidade = nivelCriticidade;
        return  (this.nivelCriticidade!= null);
    }

    /**
     * Identidade do Servico
     */
    @Override
    public ServicoIdentificador identity() {
        return this.servicoIdent;
    }

    /**
     * Equals do Servico
     */
    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Servico)) {
            return false;
        }

        final Servico that = (Servico) other;
        return this.servicoIdent.equals(that.servicoIdent);
    }

    public Titulo tituloDoServico(){
        return this.titulo;
    }

    public DescricaoBreve descricaoBreveDoServico(){return this.descBreve;}

    public DescricaoCompleta descricaoCompletaDoServico(){return this.descComp;}

    public byte[] iconDoServico(){return this.icon;}

    public Set<Keyword> listaKewordsDoServico(){
        return this.keywords;
    }

    public EstadoServico estado(){
        return this.estado;
    }

    public Catalogo catalogo(){return this.catalogo;}

    public boolean requerFeedbackDoServico(){return this.requerFeedback;}

    public Set<Formulario> formulariosDoServico(){
        return this.formularios;
    }

    public  NivelCriticidade nivelCriticidadeServico(){return this.nivelCriticidade;}

    public FluxoAtividade fluxoDoServico(){return fluxoAtividade;}

    public boolean estaCompleto() {
        return this.servicoIdent != null && this.titulo != null && this.descBreve != null
                && this.descComp != null && keywords.size() > 0 && this.catalogo != null && fluxoAtividade != null && !formularios.isEmpty() && nivelCriticidade!=null;
    }

    public void completar() {
        this.estado = EstadoServico.COMPLETO;
    }
    /**
     * toString do Servico
     */
    @Override
    public String toString() {
        return this.titulo + " - " + estado;
    }


}
