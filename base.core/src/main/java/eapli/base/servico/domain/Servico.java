package eapli.base.servico.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe da Entidade Serviço
 */
@Entity
@Table
public class Servico implements Comparable<Servico>, AggregateRoot<Servico> {
    /**
     * Identificador único do Serviço
     */
    @EmbeddedId
    @Column(name="ID")
    private ServicoIdentificador servicoIdent;
    /**
     * Titulo do Servico
     */
    @Column(name="TITULO")
    private String titulo;
    /**
     * Descrição brece do serviço
     */
    @Column(name="DESCRICAO_BREVE")
    private String descBreve;
    /**
     * Descrição completa do serviço
     */
    @Column(name="DESCRICAO_COMPLETA")
    private String descComp;
    /**
     * Ícone do serviço
     */
    @Column(name="ICONE")
    private int icon; //TODO alterar para imagem
    /**
     * Modo de atividade de aprovação, podendo ser requerida ou não
     */
    @Column(name="ATIVIDADE_APROVACAO")
    private boolean atAprov;
    /**
     * Atividade de realização, podendo ser automática ou manual
     */
    @Column(name="ATIVIDADE_REALIZACAO")
    private boolean atReal;
    /**
     * Conjunto de palavras chave de um serviço
     */
    @Column(name="PALAVRAS_CHAVE")
    @ElementCollection
    private Set<Keyword> keywords;
    /**
     * Estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    @Column(name="ESTADO")
    private String estado;

    /**
     * Construtor da entidade Servico
     * @param titulo do Servico
     * @param descBreve descrição breve do serviço
     * @param descComp descrição completa do serviço
     * @param icon ícone associado
     * @param atAprov atividade de aprovação, podendo ser requerida ou não
     * @param atReal atividade de realização, podendo ser automática ou manual
     * @param keywords conjunto de palavras chave
     * @param estado estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    public Servico(ServicoIdentificador idServ, String titulo, String descBreve, String descComp, int icon, boolean atAprov, boolean atReal, Set<Keyword> keywords, String estado){
        this.servicoIdent = idServ;
        this.titulo = titulo;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.icon = icon;
        this.atAprov = atAprov;
        this.atReal = atReal;
        this.estado = estado;
        this.keywords = keywords;
    }
/**
 * Construtor vazio requerido da entidade Servico
 */
    protected Servico(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Servico o) {
        return 0;
    }

    @Override
    public Servico identity() {
        return null;
    }

    @Override
    public String toString(){
        return servicoIdent.toString() + " " + this.titulo + " " + descBreve;
    }
}
