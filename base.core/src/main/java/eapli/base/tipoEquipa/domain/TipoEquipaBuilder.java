package eapli.base.tipoEquipa.domain;

import eapli.framework.domain.model.DomainFactory;
import java.awt.*;

public class TipoEquipaBuilder implements DomainFactory<TipoEquipa> {

    /**
     * Código que identifica um tipo de equipa.
     * É composto por até 15 carateres alfanuméricos.
     */
   private String codigoInterno;

    /**
     *Descreve um TipoEquipa, utilizando para tal no máximo 50 carateres.
     */
    private String descricaoTipoEquipa;

    /**
     * Cor que identifica um TipoEquipa
     */
    private Color cor;

    public TipoEquipaBuilder() {
    }
    public TipoEquipaBuilder comIdentificador(final String identificador) {
        this.codigoInterno = identificador;
        return this;
    }


    public TipoEquipaBuilder comCor(final Color cor) {
        this.cor = cor;
        return this;


    }

    public TipoEquipaBuilder comDescricao(final String descricaoTipoEquipa) {
        this.descricaoTipoEquipa = descricaoTipoEquipa;
        return this;


    }

    @Override
    public TipoEquipa build() {
        return new TipoEquipa(CodigoInterno.valueOf(codigoInterno),cor,DescricaoTipoEquipa.valueOf(descricaoTipoEquipa));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TipoEquipaBuilder)) {
            return false;
        }

        final TipoEquipaBuilder that = (TipoEquipaBuilder) other;
        return this.codigoInterno.equals(that.codigoInterno);
    }
}
