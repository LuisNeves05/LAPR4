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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Titulo do Servico
     */
    private String titulo;
    /**
     * Descrição brece do serviço
     */
    private String descBreve;
    /**
     * Descrição completa do serviço
     */
    private String descComp;
    /**
     * Ícone do serviço
     */
    private int icon; //TODO alterar para imagem
    /**
     * Modo de atividade de aprovação, podendo ser requerida ou não
     */
    private boolean atAprov;
    /**
     * Atividade de realização, podendo ser automática ou manual
     */
    private boolean atReal;
    /**
     * Conjunto de palavras chave de um serviço
     */
    @ElementCollection
    private Set<Keyword> keywords;
    /**
     * Estado de conclusão do serviço, podendo estar completo ou incompleto
     */
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
    public Servico(String titulo, String descBreve, String descComp, int icon, boolean atAprov, boolean atReal, Set<Keyword> keywords, String estado){
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
        return this.titulo +" "+ this.id;
    }
}
