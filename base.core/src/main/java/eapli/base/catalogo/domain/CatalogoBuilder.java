package eapli.base.catalogo.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.DomainFactory;

import javax.persistence.*;

public class CatalogoBuilder implements DomainFactory<Servico> {

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
    private int icon; //TODO alterar para imagem

    @OneToOne
    private Colaborador colaboradorResponsavel;

    @Override
    public Servico build() {
        return null;
    }

    //TODO ONE TO MANY, UM CATALOGO DA ACESSO A MUITAS EQUIPAS
    //private Equipa equipa;

}
