package eapli.base.tipoEquipa.domain;

import junit.framework.TestCase;

public class DescricaoTipoEquipaTest extends TestCase {

    public void testValueOf() {
        DescricaoTipoEquipa descricaoTipoEquipa1 = new DescricaoTipoEquipa("teste");
        DescricaoTipoEquipa descricaoTipoEquipa2 = DescricaoTipoEquipa.valueOf("teste");

        final boolean expected = descricaoTipoEquipa1.equals(descricaoTipoEquipa2);

        assertTrue(expected);
    }

    public void testCompareTo() {
        DescricaoTipoEquipa descricaoTipoEquipa1 = new DescricaoTipoEquipa("teste");
        DescricaoTipoEquipa descricaoTipoEquipa2 = new DescricaoTipoEquipa("teste");

        final boolean expected = descricaoTipoEquipa1.compareTo(descricaoTipoEquipa2) == 0;

        assertTrue(expected);
    }
}