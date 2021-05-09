package eapli.base.tipoEquipa.domain;

import junit.framework.TestCase;

import java.awt.*;

public class TipoEquipaBuilderTest extends TestCase {

    public void testComIdentificador() {

        final TipoEquipaBuilder tipoEquipaBuilder1 =  new TipoEquipaBuilder().comIdentificador("teste");
        final TipoEquipaBuilder tipoEquipaBuilder2 =  new TipoEquipaBuilder().comIdentificador("teste");

        final boolean expected = tipoEquipaBuilder1.equals(tipoEquipaBuilder2);

        assertTrue(expected);
    }

    public void testBuild() {
        final TipoEquipa tipoEquipa1 = new TipoEquipaBuilder().comIdentificador("falso")
                .comCor(Color.BLACK).comDescricao("teste").build();
        final TipoEquipa tipoEquipa2 = new TipoEquipaBuilder().comIdentificador("falso")
                .comCor(Color.BLACK).comDescricao("teste").build();

        final boolean expected = tipoEquipa1.sameAs(tipoEquipa2);

        assertTrue(expected);
    }
}