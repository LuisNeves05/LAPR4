package eapli.base.tipoEquipa.domain;

import eapli.base.Utils.ColorConverter;
import eapli.base.Utils.TColor;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table
public class TipoEquipa implements Comparable<TipoEquipa>, AggregateRoot<TipoEquipa> {
    @Id
    private CodigoInterno codigoInterno;


    @Convert(converter = ColorConverter.class)
    private TColor color;


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
