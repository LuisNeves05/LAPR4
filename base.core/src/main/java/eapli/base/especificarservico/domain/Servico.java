package eapli.base.especificarservico.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Classe da Entidade Serviço
 */
@Entity
@Table(name = "Servico")
public class Servico {

    /**
     * Titulo do Servico
     */
    @Column(name = "Título")
    private String titulo;
    /**
     * Descrição brece do serviço
     */
    @Column(name = "Descrição Breve")
    private String descBreve;
    /**
     * Descrição completa do serviço
     */
    @Column(name = "Descrição Completa")
    private String descComp;
    /**
     * Ícone do serviço
     */
    @Column(name = "Ícone")
    int icon; //TODO alterar para imagem
    /**
     * Modo de atividade de aprovação, podendo ser requerida ou não
     */
    @Column(name = "Requer Aprovação?")
    private String atAprov;
    /**
     * Atividade de realização, podendo ser automática ou manual
     */
    @Column(name = "Tipo Atividade Realização")
    private String atReal;
    /**
     * Estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    @Column(name = "Estado de Conclusão")
    private String estado;

    /**
     * Conjunto de palavras chave de um serviço
     */
    @ElementCollection
    private Set<Keyword> keywords;
    /**
     * Identificador único do Serviço
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Construtor da entidade Servico
     * @param titulo do Servico
     * @param descBreve descrição breve do serviço
     * @param descComp descrição completa do serviço
     * @param icon ícone associado
     * @param atAprov atividade de aprovação, podendo ser requerida ou não
     * @param atReal atividade de realização, podendo ser automática ou manual
     * @param estado estado de conclusão do serviço, podendo estar completo ou incompleto
     */
    public Servico(String titulo, String descBreve, String descComp, int icon, String atAprov, String atReal, String estado, Set<Keyword> keywords){
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
    public Servico(){}
}
