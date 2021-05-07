package eapli.base.tipoEquipa.domain;

import eapli.base.Utils.ColorConverter;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table
public class TipoEquipa implements Comparable<TipoEquipa>, AggregateRoot<TipoEquipa> {
    @EmbeddedId
    private CodigoInterno codigoInterno;


    @Convert ( converter = ColorConverter.class)
    private Color color;

    @Embedded
    private DescricaoTipoEquipa descricaoTipoEquipa;


    public TipoEquipa() {
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
