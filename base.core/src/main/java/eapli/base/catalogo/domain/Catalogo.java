package eapli.base.catalogo.domain;

import eapli.base.colaborador.domain.Colaborador;
import javax.persistence.*;

@Entity
@Table
public class Catalogo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    /**
     * Descrição brece do serviço
     */
    @Column
    private String descBreve;
    /**
     * Descrição completa do serviço
     */
    @Column
    private String descComp;
    /**
     * Ícone do serviço
     */
    @Column
    int icon; //TODO alterar para imagem

    @OneToOne
    Colaborador colaboradorResponsavel;

    //TODO esperar que o tiago de push e implementar one to many de equipas que tem acesso

    protected Catalogo(){}

    public Catalogo(Long id, String titulo, String descBreve, String descComp, int icon, Colaborador colaboradorResponsavel) {
        this.id = id;
        this.titulo = titulo;
        this.descBreve = descBreve;
        this.descComp = descComp;
        this.icon = icon;
        this.colaboradorResponsavel = colaboradorResponsavel;
    }
}
