package eapli.base.catalogo.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.*;
import eapli.framework.domain.model.DomainFactory;

import javax.persistence.*;
import java.util.Set;

public class CatalogoBuilder implements DomainFactory<Catalogo> {

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
    private Colaborador colaboradorResponsavel;
    private Set<Equipa> equipaSet;


    public CatalogoBuilder() {
    }

    public CatalogoBuilder comTitulo(final String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CatalogoBuilder comDescBreve(final String descBreve) {
        this.descBreve = descBreve;
        return this;
    }

    public CatalogoBuilder comDescComp(final String descComp) {
        this.descComp = descComp;
        return this;
    }

    public CatalogoBuilder comIcon(final int icon) {
        this.icon = icon;
        return this;
    }

    public CatalogoBuilder comColaboradorResponsavel(final Colaborador colaborador) {
        this.colaboradorResponsavel = colaborador;
        return this;
    }

    public CatalogoBuilder comListaEquipas(final Set<Equipa> equipaSet) {
        this.equipaSet = equipaSet;
        return this;
    }

    /**
     * Criação da instância Serviço
     */
    @Override
    public Catalogo build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        return new Catalogo(Titulo.valueOf(titulo), DescricaoBreve.valueOf(descBreve),
                DescricaoCompleta.valueOf(descComp), icon, colaboradorResponsavel, equipaSet);
    }

}
