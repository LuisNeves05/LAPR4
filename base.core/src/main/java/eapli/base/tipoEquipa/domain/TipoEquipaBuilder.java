package eapli.base.tipoEquipa.domain;

import eapli.framework.domain.model.DomainFactory;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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


    public TipoEquipaBuilder comCor(int numeroCor) {
        Map<Integer, Color> cores = new HashMap<>();
        cores.put(1, Color.white);
        cores.put(2, Color.lightGray);
        cores.put(3, Color.gray);
        cores.put(4, Color.darkGray);
        cores.put(5, Color.black);
        cores.put(6, Color.red);
        cores.put(7, Color.pink);
        cores.put(8, Color.orange);
        cores.put(9, Color.yellow);
        cores.put(10, Color.green);
        cores.put(11, Color.magenta);
        cores.put(12, Color.cyan);
        cores.put(13, Color.blue);

        final Color cor= cores.get(numeroCor);
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
