package eapli.base.servico.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.base.fluxo.domain.AtividadeAprovacao;
import eapli.base.fluxo.domain.AtividadeRealizacao;
import eapli.base.formulario.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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
     * Modo de atividade de aprovação, podendo ser requerida ou não
     */
    @Column(name = "ATIVIDADE_APROVACAO")
    private boolean atAprov;
    /**
     * Atividade de realização, podendo ser automática ou manual
     *
     * SE TRUE, é automático, SE FALSE, é manual
     */
    @Column(name = "ATIVIDADE_REALIZACAO")
    private boolean atAuto;

    @OneToOne
    private Colaborador colabExec;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="SERVICO_EQUIPASEXEC")
    private Set<Equipa> equipasExec;
    /**
     * Conjunto de palavras chave de um serviço
     */
    @Column(name = "PALAVRAS_CHAVE")
    @ElementCollection
    private Set<Keyword> keywords;
    /**
     * Conjunto de colaboradores que aprovam um serviço
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="SERVICO_COLABORADOR_APROVACAO")
    private Set<Colaborador> colabsAprov;
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

    @OneToOne
    private AtividadeAprovacao atividadeAprovacao;

    @OneToOne
    private AtividadeRealizacao atividadeRealizacao;

    /**
     * Nível de Criticidade associada ao serviço
     */
    @OneToOne(cascade = CascadeType.ALL)
    private NivelCriticidade nivelCriticidade;


    /**
     * Construtor da entidade Servico
     *
     * @param titulo    do Servico
     * @param descBreve descrição breve do serviço
     * @param descComp  descrição completa do serviço
     * @param icon      ícone associado
     * @param atAprov   atividade de aprovação, podendo ser requerida ou não
     * @param atAuto    atividade de realização, podendo ser automática ou manual
     * @param keywords  conjunto de palavras chave
     * @param estado    estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    public Servico(ServicoIdentificador idServ, Titulo titulo, DescricaoBreve descBreve, DescricaoCompleta descComp, byte[] icon,
                   boolean atAprov, boolean atAuto, Colaborador colabExec, Set<Keyword> keywords, EstadoServico estado, Catalogo catalogo, boolean requerFeedback, NivelCriticidade nivelCriticidade) {
        this.servicoIdent = idServ;
        this.titulo = titulo;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.icon = icon;
        this.atAprov = atAprov;
        this.atAuto = atAuto;
        this.colabExec = colabExec;
        this.estado = estado;
        this.keywords = keywords;
        this.catalogo = catalogo;
        this.requerFeedback = requerFeedback;
        this.formularios = new HashSet<>();
        this.colabsAprov = new HashSet<>();
        this.equipasExec = new HashSet<>();
        this.nivelCriticidade = nivelCriticidade;

    }

    /**
     * Construtor vazio requerido da entidade Servico
     */
    protected Servico() {}

    public void adicionaFormulario(Formulario f){
        if(!this.formularios.contains(f)){
            formularios.add(f);
        }
    }

        public void adicionaColaboradorAprov(List<Colaborador> colabs){
        if(!this.colabsAprov.contains(colabs)){
            colabsAprov.addAll(colabs);
        }
    }

    public void adicionaEquipaExec(List<Equipa> equipas){
        if(!this.equipasExec.contains(equipas)){
            equipasExec.addAll(equipas);
        }
    }

    public  boolean adicionarNivelCriticidade(NivelCriticidade nivelCriticidade){
        this.nivelCriticidade = nivelCriticidade;
        return  (this.nivelCriticidade!= null);
    }

    public void limpaForms(){
        this.formularios.clear();
    }
    public void limpaColabs() {
        this.colabsAprov.clear();
    }
    public void limpaEquipasExec() {
        this.equipasExec.clear();
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

    public boolean atividadeAprovacao(){return this.atAprov;}

    public Set<Colaborador> colabsAprov(){return this.colabsAprov;}

    public boolean atividadeRealizacao(){return this.atAuto;}

    public Set<Keyword> listaKewordsDoServico(){
        return this.keywords;
    }

    public EstadoServico estado(){
        return this.estado;
    }

    public Catalogo catalogo(){return this.catalogo;}

    public boolean requerFeedbackDoServico(){return this.requerFeedback;}

    public Colaborador colabExecucao() {
        return this.colabExec;
    }
    public Set<Formulario> formulariosDoServico(){
        return this.formularios;
    }

    public Set<Equipa> equipasExecDoServico(){
        return this.equipasExec;
    }

    public Set<Colaborador> colabsAprovDoServico(){
        return this.colabsAprov;
    }

    public  NivelCriticidade nivelCriticidadeServico(){return this.nivelCriticidade;};

    /**
     * toString do Servico
     */
    @Override
    public String toString() {
        return servicoIdent.toString() + " " + this.titulo + " " + descBreve;
    }


}
