package eapli.base.tipoEquipa.domain;

import junit.framework.TestCase;

public class CodigoInternoTest extends TestCase {

    public void testValueOf() {
        CodigoInterno codigoInterno1 = new CodigoInterno("teste");
        CodigoInterno codigoInterno2 = CodigoInterno.valueOf("teste");

        final boolean expected = codigoInterno1.equals(codigoInterno2);

        assertTrue(expected);
    }

    public void testCompareTo() {
        CodigoInterno codigoInterno1 = new CodigoInterno("teste");
        CodigoInterno codigoInterno2 = CodigoInterno.valueOf("teste");

        final boolean expected = codigoInterno1.compareTo(codigoInterno2) == 0;

        assertTrue(expected);
    }

    public void testEquals() {
        CodigoInterno codigoInterno1 = new CodigoInterno("teste");
        CodigoInterno codigoInterno2 = new CodigoInterno("teste");

        final boolean expected = codigoInterno1.equals(codigoInterno2);

        assertTrue(expected);
    }

    public void testEqualsFalso() {
        CodigoInterno codigoInterno1 = new CodigoInterno("teste");
        CodigoInterno codigoInterno2 = new CodigoInterno("diferente");

        final boolean expected = codigoInterno1.equals(codigoInterno2);

        assertFalse(expected);
    }
}