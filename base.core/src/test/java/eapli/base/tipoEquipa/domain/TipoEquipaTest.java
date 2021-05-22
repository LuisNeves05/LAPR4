package eapli.base.tipoEquipa.domain;

import junit.framework.TestCase;

import java.awt.*;

public class TipoEquipaTest extends TestCase {

    public static TipoEquipa dummyTipoEquipa() {

        final TipoEquipaBuilder tipoEquipaBuilder = new TipoEquipaBuilder();
        return tipoEquipaBuilder.comIdentificador("teste").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();
    }

    private TipoEquipa getdummyTipoEquipa() {
        return dummyTipoEquipa();
    }

    public void testMesmoIdentificadorTipoEquipaEquals(){


        final TipoEquipa tipoEquipa1 = new TipoEquipaBuilder().comIdentificador("teste").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();

        final TipoEquipa tipoEquipa2 = new TipoEquipaBuilder().comIdentificador("teste").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();

        final boolean expected = tipoEquipa1.identity().equals(tipoEquipa2.identity());

        assertTrue(expected);
    }

    public void testDiferentesIdentificadorTipoEquipaEquals() {

        final TipoEquipa tipoEquipa1 = new TipoEquipaBuilder().comIdentificador("teste").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();

        final TipoEquipa tipoEquipa2 = new TipoEquipaBuilder().comIdentificador("falso").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();

        final boolean expected = tipoEquipa1.equals(tipoEquipa2);

        assertFalse(expected);
    }

    public void testMesmoTipoEquipa() {
        TipoEquipa tipoEquipa = getdummyTipoEquipa();

        final boolean expected = tipoEquipa.equals(tipoEquipa);

        assertTrue(expected);
    }

    public void testObjetoDiferenteServico() {

        final TipoEquipa tipoEquipa = new TipoEquipaBuilder().comIdentificador("teste").comDescricao("diferente")
                .comDescricao("teste").comCor(5).build();

        final boolean expected = tipoEquipa.equals(getdummyTipoEquipa());

        assertFalse(expected);
    }

    public void testMesmaInstanciaTipoEquipa() {

        final TipoEquipa tipoEquipa = new TipoEquipaBuilder().comIdentificador("teste").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();

        final boolean expected = tipoEquipa.sameAs(getdummyTipoEquipa());

        assertTrue(expected);
    }

    public void testDoisTipoEquipaIdentificadorDiferentes() {

        final TipoEquipa tipoEquipa1 = new TipoEquipaBuilder().comIdentificador("teste").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();

        final TipoEquipa tipoEquipa2 = new TipoEquipaBuilder().comIdentificador("falso").comDescricao("teste")
                .comDescricao("teste").comCor(5).build();

        final boolean expected = tipoEquipa1.sameAs(tipoEquipa2);

        assertFalse(expected);
    }


}