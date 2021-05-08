package eapli.base.servico.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.formulario.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
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
    private int icon; //TODO alterar para imagem
    /**
     * Modo de atividade de aprovação, podendo ser requerida ou não
     */
    @Column(name = "ATIVIDADE_APROVACAO")
    private boolean atAprov;
    /**
     * Atividade de realização, podendo ser automática ou manual
     */
    @Column(name = "ATIVIDADE_REALIZACAO")
    private boolean atReal;
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
    private String estado;
    /**
     * Servico é pertencente a um Catalogo
     */
    @OneToOne
    private Catalogo catalogo;

    /**
     * Construtor da entidade Servico
     *
     * @param titulo    do Servico
     * @param descBreve descrição breve do serviço
     * @param descComp  descrição completa do serviço
     * @param icon      ícone associado
     * @param atAprov   atividade de aprovação, podendo ser requerida ou não
     * @param atReal    atividade de realização, podendo ser automática ou manual
     * @param keywords  conjunto de palavras chave
     * @param estado    estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    public Servico(ServicoIdentificador idServ, Titulo titulo, DescricaoBreve descBreve, DescricaoCompleta descComp, int icon,
                   boolean atAprov, boolean atReal, Set<Keyword> keywords, String estado, Catalogo catalogo) {
        this.servicoIdent = idServ;
        this.titulo = titulo;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.icon = icon;
        this.atAprov = atAprov;
        this.atReal = atReal;
        this.estado = estado;
        this.keywords = keywords;
        this.catalogo = catalogo;
    }

    /**
     * Construtor vazio requerido da entidade Servico
     */
    protected Servico() {}

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

    /**
     * Identidade do Servico
     */
    @Override
    public ServicoIdentificador identity() {
        return this.servicoIdent;
    }

    /**
     * toString do Servico
     */
    @Override
    public String toString() {
        return servicoIdent.toString() + " " + this.titulo + " " + descBreve;
    }

}
