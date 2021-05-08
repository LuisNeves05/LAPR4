package eapli.base.tipoEquipa.domain;

import eapli.base.Utils.ColorConverter;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table
public class TipoEquipa implements Comparable<TipoEquipa>, AggregateRoot<TipoEquipa> {

    /**
     * Código que identifica um tipo de equipa.
     * É composto por até 15 carateres alfanuméricos.
     */
    @EmbeddedId
    @Column(name="ID")
    private CodigoInterno codigoInterno;

    /**
     * Cor que identifica um TipoEquipa
     */

    @Convert ( converter = ColorConverter.class)
    @Column(name="COR")
    private Color  color;

    /**
     *Descreve um TipoEquipa, utilizando para tal no máximo 50 carateres.
     */
    @Embedded
    @Column(name="DESCRICAO")
    private DescricaoTipoEquipa descricaoTipoEquipa;

    /**
     * Construtor vazio requerido da entidade TipoEquipa
     */
    protected TipoEquipa() {
    }

    /**
     *Construtor TipoEquipa
     * @param codigoInterno Código que identifica um tipo de equipa.É composto por até 15 carateres alfanuméricos.
     * @param color Cor que identifica um TipoEquipa
     * @param descricaoTipoEquipa Descreve um TipoEquipa, utilizando para tal no máximo 50 carateres.
     */
    public TipoEquipa(CodigoInterno codigoInterno, Color color, DescricaoTipoEquipa descricaoTipoEquipa) {
        this.codigoInterno = codigoInterno;
        this.color = color;
        this.descricaoTipoEquipa = descricaoTipoEquipa;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(TipoEquipa other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public TipoEquipa identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(TipoEquipa otherId) {
        return AggregateRoot.super.hasIdentity(otherId);
    }
}
